package ru.otus.open.tests;

import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import ru.otus.model.CcyPairs;
import ru.otus.model.DealRequest;
import ru.otus.model.DealResponse;
import ru.otus.model.PriceFeed;

import java.util.Arrays;
import java.util.Collection;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

    @Test
    public void shouldReturnFeeAndSizeInfo() {
        //Arrange
        ChangeRequest request = new ChangeRequest("RUB", "USD", 100);
        DealResponse responseToBe = new DealResponse(CcyPairs.USD_RUB, 99d, 81.05);

        //Act
        DealResponse responseAsIs = sendDealReq(request);

        //Assert
        assertThat(responseAsIs, equalTo(responseToBe));
    }

    @Test
    public void dealsChangeWalletAmount() {
        ChangeRequest request = new ChangeRequest("USD", "EUR", 50);

        sendDealReq(request);
        Double amountEur = getWalletValue("EUR");

        assertThat(amountEur, equalTo(47.5));
    }

    private DealResponse sendDealReq(ChangeRequest request) {
        return given().baseUri("http://localhost:8081/api")
                .contentType(ContentType.JSON).body(request)
                .when().post("/change")
                .then().statusCode(200)
                .extract().as(DealResponse.class);
    }

    private Double getWalletValue(String ccy) {
        return given().baseUri("http://localhost:8081/api")
                .accept(ContentType.JSON)
                .when().get("/wallet/" + ccy)
                .then().statusCode(200)
                .extract().body().jsonPath().getDouble(ccy);
    }





    @Test
    public void negativeFeed() {
        PriceFeed feed = new PriceFeed("JPY/RUB", -1);
        setNewFeed(feed);

        ChangeRequest request = new ChangeRequest("RUB", "JPY", 100);

        //Act
        DealResponse responseAsIs = sendDealReq(request);

        //Assert
        assertThat(responseAsIs, equalTo(null));
    }

    @Test
    public void sendToExchangeSizeMultPrice(){
        PriceFeed feed = new PriceFeed("EUR/RUB", 90);
        setNewFeed(feed);

        ChangeRequest request = new ChangeRequest("RUB", "EUR", 200);
        DealRequest reqToBe = new DealRequest(CcyPairs.EUR_RUB, 18000, 200);

        sendDealReq(request);

        DealRequest reqAsIs = getHistory()[0].getBodyRequest();

        assertThat(reqAsIs, equalTo(reqToBe));
    }


    private void setNewFeed(PriceFeed feed) {
        given().baseUri("http://localhost:8090/stub/feed/add").contentType(ContentType.JSON).body(feed)
                .when().post().then().statusCode(200);
    }


    private StubCall[] getHistory(){
        return given().baseUri("http://localhost:8090/history")
                .accept(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .extract().as(StubCall[].class);
    }

    private void clearHistory(){
        given().baseUri("http://localhost:8090/history/clear")
                .accept(ContentType.JSON)
                .when().delete()
                .then().statusCode(200);
    }
}

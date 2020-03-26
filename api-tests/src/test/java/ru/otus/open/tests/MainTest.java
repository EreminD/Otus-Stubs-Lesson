package ru.otus.open.tests;

import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import ru.otus.model.CcyPairs;
import ru.otus.model.DealResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

    @Before
    public void setUp(){
        baseURI = "http://localhost:8081";
        basePath = "/api";
    }

    @Test
    public void shouldReturnFeeAndSizeInfo(){
        //Arrange
        ChangeRequest request = new ChangeRequest("RUB","USD", 100);
        DealResponse responseToBe = new DealResponse(CcyPairs.USD_RUB, 99d, 81.05);

        //Act
        DealResponse responseAsIs = sendDealReq(request);

        //Assert
        assertThat(responseAsIs, equalTo(responseToBe));
    }

    @Test
    public void dealsChangeWalletAmount(){
        ChangeRequest request = new ChangeRequest("USD","EUR", 50);

        sendDealReq(request);
        Double amountEur = getWalletValue("EUR");

        assertThat(amountEur, equalTo(47.5));
    }

    private DealResponse sendDealReq(ChangeRequest request) {
        return given().contentType(ContentType.JSON).body(request)
                .when().post("/change")
                .then().statusCode(200)
                .extract().as(DealResponse.class);
    }

    private Double getWalletValue(String ccy){
        return given().accept(ContentType.JSON)
                .when().get("/wallet/"+ccy)
                .then().statusCode(200)
                .extract().body().jsonPath().getDouble(ccy);
    }
}
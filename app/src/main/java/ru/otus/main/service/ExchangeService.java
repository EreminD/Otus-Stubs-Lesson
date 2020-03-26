package ru.otus.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.otus.model.DealRequest;
import ru.otus.model.CcyPairs;
import ru.otus.model.DealResponse;
import ru.otus.model.PriceFeed;

import java.util.Collections;

@Service
public class ExchangeService {
    @Autowired
    private RestTemplate rest;

    @Value("${exchange.address}")
    private String exchangeUrl;


    public DealResponse newDeal(CcyPairs pair, PriceFeed priceFeed, long size) {
        DealRequest deal = new DealRequest(pair, priceFeed.getPrice()* size, size);
        return rest.postForObject(exchangeUrl, deal, DealResponse.class, Collections.EMPTY_LIST);
    }
}

package ru.otus.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.otus.model.CcyPairs;
import ru.otus.model.PriceFeed;

@Service
public class FeedService {
    @Autowired
    private RestTemplate rest;

    @Value("${feed.address}")
    private String feedUrl;

    public PriceFeed getPrice(CcyPairs pair) {
        return rest.getForObject(feedUrl, PriceFeed.class, pair);
    }
}

package ru.otus.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.model.CcyPairs;
import ru.otus.model.DealResponse;
import ru.otus.model.PriceFeed;

@Service
public class AppService {
    @Autowired
    private FeedService feeds;

    @Autowired
    private ExchangeService exchange;

    public DealResponse change(CcyPairs pair, long amount){
        PriceFeed priceFeed = feeds.getPrice(pair);
        DealResponse response = exchange.newDeal(pair, priceFeed, amount);
        return response;
    }
}

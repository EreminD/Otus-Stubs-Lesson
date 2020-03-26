package ru.otus.pricefeed.repository;

import org.springframework.stereotype.Service;
import ru.otus.model.CcyPairs;
import ru.otus.model.PriceFeed;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static ru.otus.model.CcyPairs.*;

@Service
public class FeedRepository {
    private final Map<CcyPairs, PriceFeed> feeds = new HashMap<>();

    @PostConstruct
    private void fillMap(){
        feeds.put(USD_RUB, new PriceFeed(USD_RUB,81.05));
        feeds.put(GBP_RUB, new PriceFeed(GBP_RUB,95.00));
        feeds.put(EUR_RUB, new PriceFeed(EUR_RUB,88.47));
        feeds.put(JPY_RUB, new PriceFeed(JPY_RUB,70.71));
        feeds.put(EUR_USD, new PriceFeed(EUR_USD,1.08));
    }

    public Collection<PriceFeed> getAll(){
        return feeds.values();
    }

    public PriceFeed getByName(CcyPairs name){
        return feeds.get(name);
    }
}

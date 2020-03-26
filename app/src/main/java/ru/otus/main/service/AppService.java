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

    @Autowired
    private WalletService wallet;

    public DealResponse change(CcyPairs pair, long size){
        // get price info
        PriceFeed priceFeed = feeds.getPrice(pair);

        //withdraw
        String paymentCcy = pair.getSecond();
        double paymentAmount = priceFeed.getPrice() * size;
        wallet.withdraw(paymentCcy, paymentAmount);

        //deal
        DealResponse response = exchange.newDeal(pair, priceFeed, size);

        //fill wallet
        String incomingCcy = response.getPair().getFirst();
        double incomingAmount = response.getTotalChanged();
        wallet.add(incomingCcy, incomingAmount);

        return response;
    }
}

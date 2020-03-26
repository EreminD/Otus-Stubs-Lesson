package ru.otus.model;

public enum CcyPairs {
    USD_RUB("USD/RUB"),
    GBP_RUB("GBP/RUB"),
    EUR_RUB("EUR/RUB"),
    JPY_RUB("JPY/RUB"),
    EUR_USD("EUR/USD");

    private String ccyPair;

    CcyPairs(String ccyPair) {
        this.ccyPair = ccyPair;
    }

    public String pair() {
        return ccyPair;
    }
}

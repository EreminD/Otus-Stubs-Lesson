package ru.otus.main.model;

public class ChangeCurrencyRequest {
    private final String ccyFrom;
    private final String ccyTo;
    private final long amount;

    public ChangeCurrencyRequest(String ccyFrom, String ccyTo, long amount) {
        this.ccyFrom = ccyFrom;
        this.ccyTo = ccyTo;
        this.amount = amount;
    }

    public String getCcyFrom() {
        return ccyFrom;
    }

    public String getCcyTo() {
        return ccyTo;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "ChangeCurrencyRequest{" +
                "ccyFrom='" + ccyFrom + '\'' +
                ", ccyTo='" + ccyTo + '\'' +
                ", amount=" + amount +
                '}';
    }
}

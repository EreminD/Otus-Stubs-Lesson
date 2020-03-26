package ru.otus.model;

import ru.otus.model.CcyPairs;

import java.io.Serializable;

public class DealRequest implements Serializable {
    private CcyPairs pair;
    private double amountInCcy1;
    private long amount;

    public DealRequest() {
    }

    public DealRequest(CcyPairs pair, double amountInCcy1, long amount) {
        this.pair = pair;
        this.amountInCcy1 = amountInCcy1;
        this.amount = amount;
    }

    public CcyPairs getPair() {
        return pair;
    }

    public void setPair(CcyPairs pair) {
        this.pair = pair;
    }

    public double getAmountInCcy1() {
        return amountInCcy1;
    }

    public void setAmountInCcy1(double amountInCcy1) {
        this.amountInCcy1 = amountInCcy1;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "DealRequest{" +
                "pair=" + pair +
                ", amountInCcy1=" + amountInCcy1 +
                ", amount=" + amount +
                '}';
    }
}

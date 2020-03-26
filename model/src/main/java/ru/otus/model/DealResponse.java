package ru.otus.model;

import java.io.Serializable;

public class DealResponse implements Serializable {
    private CcyPairs pair;
    private double totalChanged;
    private double feeCharge;

    public DealResponse() {
    }

    public DealResponse(CcyPairs pair, double totalChanged, double feeCharge) {
        this.pair = pair;
        this.totalChanged = totalChanged;
        this.feeCharge = feeCharge;
    }

    public CcyPairs getPair() {
        return pair;
    }

    public void setPair(CcyPairs pair) {
        this.pair = pair;
    }

    public double getTotalChanged() {
        return totalChanged;
    }

    public void setTotalChanged(double totalChanged) {
        this.totalChanged = totalChanged;
    }

    public double getFeeCharge() {
        return feeCharge;
    }

    public void setFeeCharge(double feeCharge) {
        this.feeCharge = feeCharge;
    }

    @Override
    public String toString() {
        return "DealResponse{" +
                "pair=" + pair +
                ", totalChanged=" + totalChanged +
                ", feeCharge=" + feeCharge +
                '}';
    }
}

package ru.otus.main.model;

public class ChangeCurrencyRequest {
    private final String ccyFrom;
    private final String ccyTo;
    private final long size;

    public ChangeCurrencyRequest(String ccyFrom, String ccyTo, long size) {
        this.ccyFrom = ccyFrom;
        this.ccyTo = ccyTo;
        this.size = size;
    }

    public String getCcyFrom() {
        return ccyFrom;
    }

    public String getCcyTo() {
        return ccyTo;
    }

    public long getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "ChangeCurrencyRequest{" +
                "ccyFrom='" + ccyFrom + '\'' +
                ", ccyTo='" + ccyTo + '\'' +
                ", amount=" + size +
                '}';
    }
}

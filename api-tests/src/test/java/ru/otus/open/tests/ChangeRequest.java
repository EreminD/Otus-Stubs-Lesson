package ru.otus.open.tests;

public class ChangeRequest {
    private String ccyFrom;
    private String ccyTo;
    private long size;

    public ChangeRequest() {
    }

    public ChangeRequest(String ccyFrom, String ccyTo, long size) {
        this.ccyFrom = ccyFrom;
        this.ccyTo = ccyTo;
        this.size = size;
    }

    public String getCcyFrom() {
        return ccyFrom;
    }

    public void setCcyFrom(String ccyFrom) {
        this.ccyFrom = ccyFrom;
    }

    public String getCcyTo() {
        return ccyTo;
    }

    public void setCcyTo(String ccyTo) {
        this.ccyTo = ccyTo;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ChangeRequest{" +
                "ccyFrom='" + ccyFrom + '\'' +
                ", ccyTo='" + ccyTo + '\'' +
                ", amount=" + size +
                '}';
    }
}

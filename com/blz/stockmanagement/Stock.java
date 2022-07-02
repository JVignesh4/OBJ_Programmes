package com.blz.stockmanagement;
public class Stock {
    private String stokeName;
    private int noOfShare;
    private double sharePrice;
    public static double totalStockValue;

    public Stock(String stokeName, int noOfShare, double sharePrice) {
        this.stokeName = stokeName;
        this.noOfShare = noOfShare;
        this.sharePrice = sharePrice;
    }


    public double getTotalStockValue() {
        return totalStockValue;
    }

    public void setTotalStockValue(double totalStockValue) {
        Stock.totalStockValue = totalStockValue;
    }

    public String getStokeName() {
        return stokeName;
    }

    public void setStokeName(String stokeName) {
        this.stokeName = stokeName;
    }

    public int getNoOfShare() {
        return noOfShare;
    }

    public void setNoOfShare(int noOfShare) {
        this.noOfShare = noOfShare;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(double sharePrice) {
        this.sharePrice = sharePrice;
    }
}
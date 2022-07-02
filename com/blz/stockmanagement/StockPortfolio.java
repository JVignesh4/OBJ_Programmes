package com.blz.stockmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class StockPortfolio {
    ArrayList<Stock> stockArray;
    public StockPortfolio(){
        stockArray =new ArrayList<>();
    }
    Scanner in=new Scanner(System.in);
    public void readStockDetails(){
        Stock newStock=new Stock();
        System.out.println("Enter Stock Name");
        newStock.setStokeName(in.next());
        System.out.println("Enter number of stock");
        newStock.setNoOfShare(in.nextInt());
        System.out.println("Enter Stock Price");
        newStock.setSharePrice(in.nextDouble());
        stockArray.add(newStock);
    }
    public void readStockDetailsFromFile(){
        Stock newStock=new Stock();
        System.out.println("Enter Stock Name");
        newStock.setStokeName(in.next());
        System.out.println("Enter number of stock");
        newStock.setNoOfShare(in.nextInt());
        System.out.println("Enter Stock Price");
        newStock.setSharePrice(in.nextDouble());
        stockArray.add(newStock);
    }

    public void calculateStockPrice(){
        for (Stock objStock:stockArray
        ) {
            objStock.setTotalStockValue((double) objStock.getNoOfShare() * objStock.getSharePrice());
        }
    }

    public void printReport(){
        for (Stock objStock:stockArray
        ) {
            System.out.println("Stock Name: "+objStock.getStokeName());
            System.out.println("Each Stock Price: "+objStock.getSharePrice());
            System.out.println("Stock Total value: "+objStock.getTotalStockValue());
        }
    }
}
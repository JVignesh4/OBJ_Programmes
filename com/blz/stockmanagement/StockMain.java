package com.blz.stockmanagement;
import java.util.Scanner;

public class StockMain {
    public static void main(String[] args) {
        StockPortfolio stockPortfolio = new StockPortfolio();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter No of ");
        for (int i = 0; i < 2; i++) {
            stockPortfolio.readStockDetails();
        }
        stockPortfolio.calculateStockPrice();
        stockPortfolio.printReport();

    }
}

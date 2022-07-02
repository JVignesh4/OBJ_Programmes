package com.blz.stockmanagement;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StockMain {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\bridgelabz\\StockAccount\\Stock.csv");
        StockPortfolio stockPortfolio = new StockPortfolio(file);
        stockPortfolio.calculateStockPrice();
        stockPortfolio.printReport();
        int choice = 0;

        do {
            System.out.println("1. Print report \n2. Credit Wallet \n3. Debit Wallet\n4. Buy\n5. Sell\n0. Exit");
            choice = inputInteger("Enter Choice: ");
            switch (choice) {
                case 1:
                    stockPortfolio.printReport();
                    break;
                case 2:
                    stockPortfolio.credit();
                    break;
                case 3:
                    stockPortfolio.debit();
                    break;
                case 4:
                    stockPortfolio.buy();
                    break;
                case 5:
                    stockPortfolio.sell();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("invalid choice.");
            }
        } while (choice != 0);
    }

    private static int inputInteger(String message) {
        System.out.println(message);
        return in.nextInt();
    }
}
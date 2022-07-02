package com.blz.stockmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class StockPortfolio {
    ArrayList<Stock> stockArray;
    Scanner in = new Scanner(System.in);

    public StockPortfolio(File file) throws FileNotFoundException {
        stockArray = new ArrayList<>();
        Scanner sc = new Scanner(file);
        while (sc.hasNext())  //returns a boolean value
        {
            String[] str = sc.next().split(",");
            stockArray.add(new Stock(str[0], Integer.parseInt(str[1]), Double.parseDouble(str[2])));
        }
        sc.close();
    }

    public void buy() {
        displayStockName();
        System.out.print("enter Stock name: ");
        String stockName = in.next();
        for (Stock objStock : stockArray
        ) {
            if (objStock.getStokeName().equalsIgnoreCase(stockName)) {
                System.out.println("enter number of shares: ");
                int noOfShares = in.nextInt();
                double totalPrice = noOfShares * objStock.getSharePrice();
                if (totalPrice < Account.balance) {
                    Account.balance -= totalPrice;
                    Account.totalAmount += totalPrice;
                    objStock.setNoOfShare(objStock.getNoOfShare() - noOfShares);
                    stockTransaction("buy", stockName, noOfShares, totalPrice);
                } else System.out.println("Please add amount in your wallet");
            }
        }
    }

    public void sell() {
        displayStockName();
        System.out.print("enter Stock name: ");
        String stockName = in.next();
        for (Stock objStock : stockArray
        ) {
            if (objStock.getStokeName().equalsIgnoreCase(stockName)) {
                System.out.println("enter number of shares: ");
                int noOfShares = in.nextInt();
                double totalPrice = noOfShares * objStock.getSharePrice();
                if (totalPrice < Account.balance) {
                    Account.balance += totalPrice;
                    Account.totalAmount -= totalPrice;
                    objStock.setNoOfShare(objStock.getNoOfShare() - noOfShares);
                    stockTransaction("sell", stockName, noOfShares, totalPrice);
                } else System.out.println("Please add amount in your wallet");
            }
        }
    }

    public void stockTransaction(String type, String stockName, int noOfShares, double totalPrice) {
        ArrayList<String> transactionArray = new ArrayList<>();
        transactionArray.add(type);
        transactionArray.add(stockName);
        transactionArray.add(String.valueOf(noOfShares));
        transactionArray.add(String.valueOf(totalPrice));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        transactionArray.add(dtf.format(now));
        Account.stockTransactionArray.add(transactionArray);
    }

    public void displayStockName() {
        System.out.println("Stock Name \t\t price \t\t number of shares");
        for (Stock objStock : stockArray
        ) {
            System.out.println(objStock.getStokeName() + "\t\t\t  " + objStock.getSharePrice() + "\t\t" + objStock.getNoOfShare());
        }
    }

    public void debit() {
        System.out.print("Enter Amount to debit: ");
        int debitAmount = in.nextInt();
        if (debitAmount < Account.balance)
            Account.balance -= debitAmount;
        else
            System.out.println("Debit amount exceeded account balance.");
    }

    public void credit() {
        System.out.print("Enter Amount to Add in Wallet: ");
        int creditAmount = in.nextInt();
        if (creditAmount > 0)
            Account.balance += creditAmount;
        else
            System.out.println("please enter amount greater then zero ");
    }

    public void calculateStockPrice() {
        for (Stock objStock : stockArray
        ) {
            objStock.setTotalStockValue((double) objStock.getNoOfShare() * objStock.getSharePrice());
            Stock.totalStockValue += objStock.getTotalStockValue();//store every stock company total share value to total amount
        }
    }

    double valueOf() {
        return Account.totalAmount;
    }


    public void printReport() {
        for (Stock objStock : stockArray
        ) {
            System.out.println("---------------------");
            System.out.println("Stock Name: " + objStock.getStokeName());
            System.out.println("Each Stock Price: " + objStock.getSharePrice());
            System.out.println("Total Stock : " + objStock.getNoOfShare());
        }
        System.out.println("---------------------");
        System.out.println("Stock Total value: " + Stock.totalStockValue);
        System.out.println("---------------------");
        System.out.println("Total Share Amount in Account: " + valueOf());
        System.out.println("Total Amount in Balance/wallet: " + Account.balance);

        System.out.println("Type \tStock Name \t price \t number of shares");
        for (Object data : Account.stockTransactionArray) {
            System.out.println(data.toString() + "\t");
        }
    }
}
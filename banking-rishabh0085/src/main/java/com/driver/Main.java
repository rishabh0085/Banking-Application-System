package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        BankAccount obj = new BankAccount("Raj", 5000, 1000);
        String accnum = obj.generateAccountNumber(5, 30);
        System.out.println(accnum);
    }
}
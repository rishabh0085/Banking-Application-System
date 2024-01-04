package com.driver;

public class BankAccount {

    public String name;
    public double balance;
    public double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        // Each digit of an account number can lie between 0 and 9 (both inclusive)
        // Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        // If it is not possible, throw "Account Number can not be generated" exception
        if (sum < 0 || sum > 9 * digits) {
            throw new Exception("Account Number can not be generated");
        }

        StringBuilder accountNumber = new StringBuilder();
        int dupSum = sum;
        // Generate digits for the account number
        for(int i=0; i<digits; i++)
        {
            if(dupSum>9)
            {
                accountNumber = new StringBuilder(accountNumber + "9");
                dupSum-=9;
            }
            else if (dupSum > 0)
            {
                String lastnum = ""+dupSum;
                accountNumber = new StringBuilder(accountNumber + lastnum);
                dupSum = 0;
            }
            else
            {
                accountNumber = new StringBuilder(accountNumber + "0");
            }
        }

        return accountNumber.toString();
    }

    public void deposit(double amount) {
        // add amount to balance
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception if the remaining amount would be less than the minimum balance
        if (balance - amount < minBalance) {
            throw new Exception("Insufficient Balance");
        }
        balance -= amount;
    }
}

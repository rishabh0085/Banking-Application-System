package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount {

        String tradeLicenseId; // consists of Uppercase English characters only

public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;

        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        if (balance < 5000) {
        throw new Exception("Insufficient Balance");
        }
        }

public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are the same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        char[] chars = tradeLicenseId.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
        if (chars[i] == chars[i + 1]) {
        // rearrange characters to create a valid license Id

        Arrays.sort(chars);
        if (chars[i] == chars[i + 1]) {
        throw new Exception("Valid License can not be generated");
        }
        }
        }
        }
        }
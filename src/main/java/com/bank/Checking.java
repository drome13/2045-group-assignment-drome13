package com.bank;

import com.bank.Account;

public class Checking extends Account {
    private static int fee = 5;
    static int balance;
    static int rate;

    public static void compute() {
        int period = getPeriod();
        for (int i = 0; i <= period; i++) {

            int newBalance = balance * rate;
            newBalance = balance - fee;
            setBalance(newBalance);


        }

    }
}

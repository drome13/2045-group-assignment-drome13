package com.bank;

public class Account {
    private static double balance = 0;
    private static int rate = 0;
    private static int period = 0;


    public static void setBalance(double balance)
    {
        double newBalance = balance;
    }
    public static void setRate(int rate)
    {
        int newRate = rate;
    }
    public static void setPeriod(int period)
    {
        int newPeriod = period;
    }

    public double getBalance()
    {
        return balance;
    }

    public int getRate()
    {
        return rate;
    }
    public static int getPeriod()
    {
        return period;
    }

    public static void compute()
    {
        int period = getPeriod();
        for(int i = 0; i<= period; i++)
        {
          int newBalance = (int) (balance * rate);
          setBalance(newBalance);


        }

    }
}

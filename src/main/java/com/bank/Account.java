package com.bank;

public class Account {
    private double balance = 0;
    private int rate = 0;
    private int period = 0;


    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    public void setRate(int rate)
    {
        this.rate = rate;
    }
    public void setPeriod(int period)
    {
        this.period = period;
    }

    public double getBalance()
    {
        return balance;
    }

    public int getRate()
    {
        return rate;
    }
    public int getPeriod()
    {
        return period;
    }

    public static void compute()
    {
        int period = getPeriod();
        for(int i = 0; i<= period; i++)
        {
          int newBalance = balance * rate;
          setBalance(newBalance);


        }

    }
}

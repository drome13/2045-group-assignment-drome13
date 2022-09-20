package com.bank;

import com.bank.Account;

public class CertificateOfDeposit extends Account {
    private int term;
    public void setTerm(int term)
    {
        this.term = term;
    }
    public int getTerm()
    {
        return term;
    }
}

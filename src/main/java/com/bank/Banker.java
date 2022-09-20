package com.bank;

import javax.swing.*;
import java.util.ArrayList;

public class Banker {

    public static final String CHECKING = "com.bank.Checking";
    public static final String SAVINGS = "com.bank.Savings";
    public static final String CERTIFICATEOF_DEPOSIT = "CertificateofDeposit";

    private static ArrayList<Account> allAccounts = new ArrayList<Account>();
    public static void main(String[] args) {
        System.out.println("Welcome to ROME bank.");
        promptUser();
    }



        public static void promptUser() {
            int goAgain = JOptionPane.NO_OPTION;
           do {
               String[] accountOptions = {CHECKING, SAVINGS, CERTIFICATEOF_DEPOSIT};
               Object accountType = JOptionPane.showInputDialog(null, "Select an account type", "Select com.bank.Account type", JOptionPane.QUESTION_MESSAGE, null, accountTypes, CHECKING);

               Account account = createAccount(accountType);
               String startingBalance = JOptionPane.showInputDialog("Enter your starting balance.");
               int balance = Integer.parseInt(startingBalance);
               Account.setBalance(balance);

               String startingRate = JOptionPane.showInputDialog("Enter your starting rate.");
               int rate = Integer.parseInt(startingRate);
               Account.setRate(rate);

               String startingPeriod = JOptionPane.showInputDialog("Enter the number of periods.");
               int period = Integer.parseInt(startingPeriod);
               Account.setPeriod(period);
               allAccounts.add(account);

               JOptionPane.showConfirmDialog(null,"Would you like to create another account?", "Create another account?", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);


           } while (goAgain == JOptionPane.YES_OPTION);

            /**
             * Method to create and return a subclass of type com.bank.Account
             *
             * @param selectedAccount A string representing the account type we want to create.
             * @return the created account
             */

            public static Account createAccount(final Object selectedAccount)
            {
                Account account;
                if (selectedAccount.toString().equals(CHECKING))
                {
                    account = new Checking();
                }
                else if (selectedAccount.toString().equals(SAVINGS))
                {
                    account = new Savings();
                }
                else if (selectedAccount.toString().equals(CERTIFICATEOF_DEPOSIT))
                {

                    account = new CertificateOfDeposit();
                }
                // allAccounts.add(account);
                return account;

            }
        }

        public static void displayBalance()
        {
            do{
                for (Account account : allAccounts)
                {
                    account.compute();
                    JOptionPane.showMessageDialog(null, "Account balance: " /*balance?*/ );
                }
            }

        }


        public static void depositMoney()
        {

        }

        public static void withdrawMoney()
        {

        }







}

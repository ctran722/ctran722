package edu.brandeis.rseg102.concurrency;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MoneyMarket {
     //Create the money market with accounts and initial balance
  public MoneyMarket(int n, double initialBalance) {
    accounts = new double[n];
    for (int i = 0; i < accounts.length; i++)
      accounts[i] = initialBalance;
    bankLock = new ReentrantLock();
    sufficientFunds = bankLock.newCondition();
  }
    //Transfers money from one account to another account
  public void transfer(int from, int to, double amount) throws InterruptedException {
    bankLock.lock();
    try {
      while (accounts[from] < amount)
        sufficientFunds.await();
      System.out.print(Thread.currentThread()+",edu.brandeis.MoneyMarket.MoneyMarketMain");
      accounts[from] -= amount;
      System.out.printf(" %10.2f from %d to %d", amount, from, to);
      accounts[to] += amount;
      System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
      sufficientFunds.signalAll();
    } finally {
      bankLock.unlock();
    }
  }
    //Gather sum of all account balances.
  public double getTotalBalance() {
    bankLock.lock();
    try {
      double sum = 0;
      for (double ac : accounts)
        sum += ac;
      return sum;
    } finally {
      bankLock.unlock();
    }
  }
   //Get accounts in the bank.
  public int size() {
    return accounts.length;
  }
  
  private final double[] accounts;
  private Lock bankLock;
  private Condition sufficientFunds;
}

class Transfer implements Runnable {

  public Transfer(MoneyMarket bk, int fromA, double maxA) {
    bank = bk;
    fromAccount = fromA;
    maxAmount = maxA;
  }

  public void run() {
    try {
      while (true) {
        int toAccount = (int) (bank.size() * Math.random());
        double amount = maxAmount * Math.random();
        bank.transfer(fromAccount, toAccount, amount);
        Thread.sleep((int) (DELAY * Math.random()));
      }
    } catch (InterruptedException e) {
    }
  }

  private MoneyMarket bank;
  private int fromAccount;
  private double maxAmount;
  private int DELAY = 10;
}

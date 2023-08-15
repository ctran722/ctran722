package edu.brandeis.rseg102.concurrency;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MoneyMarketMain {
  public static void main(String[] args) {
	//starting to create money market balance with treads
    MoneyMarket money = new MoneyMarket(NACCOUNTS, INITIAL_BALANCE);
    int i;
    for (i = 0; i < NACCOUNTS; i++) {
      Transfer tr = new Transfer(money, i, INITIAL_BALANCE);
      Thread t = new Thread(tr);
      t.start();
      
      try {
            t.interrupt();
        }catch (Exception e) {
            System.out.println("Exception handled");}
        }
    }
  	//setting variables
    public static final int NACCOUNTS = 10;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;
  }

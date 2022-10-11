package com.programming.techie.productservice.repository;

public class Account implements Runnable {

  private int balance = 100;
  public int getBalance(){
    return balance;
  }
  public void setBalance(int balance){
    this.balance = balance;
  }

  public synchronized boolean withdraw(int amount){
    if(amount > 0 && amount <= balance){
      balance = balance-amount;
      return true;
    }
    return false;
  }

  public void run(){
    withdraw(30);
  }

  public static void main(String[] args) {
    Account s1=new Account();
    Account s2= new Account();
    Thread t1= new Thread(s1);
    Thread t2 = new Thread(s2);
    t1.run();
    t2.run();
    System.out.println(s1.getBalance());
    System.out.println(s2.getBalance());
  }

}

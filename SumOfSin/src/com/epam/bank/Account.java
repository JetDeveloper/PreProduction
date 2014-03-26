/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Dmytro_Svynarenko
 */
class Account {

    private int balance;
    private Lock lock;
    public Account(int balance) {
        this.balance = balance;
        lock = new ReentrantLock();
    }

    public int getBalance() {
        return balance;
    }

    public Lock getLock() {
        return lock;
    }
    
    void withdraw(int amount) {
        balance-=amount;
    }

    void deposit(int amount) {
         balance+=amount;
    }
    
}

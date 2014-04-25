/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.bank;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class Bank {

   private List<Account> acounts;

    public Bank() {
        this.acounts = new LinkedList<>();
        for(int i=0; i<5; i++) {
            acounts.add(new Account(new Random().nextInt(10000)));
        }
    }

    public int calculateSum() {
        int delta = 0;
         for(Account a : acounts) {
             delta += a.getBalance();
         }
         return  delta;
    }

    public List<Account> getAcounts() {
        return acounts;
    }
    
    public void transfer(Account from, Account to, int amount) throws InterruptedException {

        // different time to awoid life-lock
       if (from.getLock().tryLock(10, TimeUnit.MILLISECONDS)) {
            if (to.getLock().tryLock(13, TimeUnit.MILLISECONDS)) {
                from.withdraw(amount);
                to.deposit(amount);
                to.getLock().unlock();
                from.getLock().unlock();       
           }
      }
    }
}

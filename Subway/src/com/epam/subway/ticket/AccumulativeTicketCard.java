/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.subway.ticket;

import java.util.Calendar;

/**
 * Class for accumulative ticket card
 * @author Dmytro_Svynarenko
 */
public class AccumulativeTicketCard extends Ticket{

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void increaseBalance(double balance) {
          this.balance += balance;
    }

    public AccumulativeTicketCard(double balance) {
        this.balance = balance;
        type = TicketType.DEFAULT;
    }
    
    @Override
    public boolean check(Calendar currentDate, double price) {
        if (balance - price >= 0) {
            balance-=price;
            return true;
        } else {
            return false;
        }
    }
    
}

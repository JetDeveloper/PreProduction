/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.subway.ticket.builder;

import com.epam.subway.ticket.AccumulativeTicketCard;
import com.epam.subway.ticket.Ticket;

/**
 * Builder for accumutative tickets
 * @author Dmytro_Svynarenko
 */
public class AccumulativeTicketBuilder extends TicketBuilder {

    private double balance;

    public AccumulativeTicketBuilder setBalance(double balance) {
        this.balance = balance;
        return this;
    }

    @Override
    public Ticket build() {
        AccumulativeTicketCard t = new AccumulativeTicketCard(balance);
        return t;
    }
}

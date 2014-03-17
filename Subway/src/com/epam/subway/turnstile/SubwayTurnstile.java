/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.subway.turnstile;

import com.epam.subway.ticket.Ticket;
import java.util.Calendar;

/**
 * Class for subway turnstile
 *
 * @author Dmytro_Svynarenko
 */
public class SubwayTurnstile implements Turnstile {

    final private double PRICE = 2.5;

    @Override
    public boolean checkTicket(Ticket ticket) {
        return ticket.check(Calendar.getInstance(), PRICE);
    }

    @Override
    public double getPrice() {
        return PRICE;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.subway.turnstile;

import com.epam.subway.ticket.Ticket;

/**
 * Interface for all possible turnstile
 * @author Dmytro_Svynarenko
 */
public interface Turnstile {
    boolean checkTicket(Ticket ticket);
    public double getPrice();
}

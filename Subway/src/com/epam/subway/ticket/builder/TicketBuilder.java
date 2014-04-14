/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.subway.ticket.builder;

import com.epam.subway.ticket.Ticket;

/**
 * Abstract builder for ticket
 * @author Dmytro_Svynarenko
 */
public abstract class TicketBuilder {
    protected Ticket ticket;
    abstract public Ticket build(); 
}

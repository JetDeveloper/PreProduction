/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.subway.ticket;

import java.util.Calendar;
/**
 * Abstract class for tickets
 * @author Dmytro_Svynarenko
 */
public abstract class Ticket {
    protected final long MILLISECONDS_IN_DAY = 86400000;
    protected long id;
    protected TicketType type;

    public long getId() {
        return id;
    }

    public TicketType getType() {
        return type;
    }

    abstract public boolean check(Calendar currentDate, double price);

}

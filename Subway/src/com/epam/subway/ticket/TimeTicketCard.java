/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.subway.ticket;

import java.util.Calendar;

/**
 * Ticket with time
 * @author Dmytro_Svynarenko
 */
public class TimeTicketCard extends Ticket {

    private TicketTime time;
    private Calendar startDate;

    public TimeTicketCard(TicketTime time, Calendar startDate) {
        this.time = time;
        this.startDate = startDate;
    }

    public TicketTime getTime() {
        return time;
    }

    @Override
    public boolean check(Calendar currentDate, double price) {
        long current = currentDate.getTimeInMillis();
        long start = startDate.getTimeInMillis();
        long diff = current - start;
        long daysMill = time.getDays() * MILLISECONDS_IN_DAY;
        return diff <= daysMill;

    }
}

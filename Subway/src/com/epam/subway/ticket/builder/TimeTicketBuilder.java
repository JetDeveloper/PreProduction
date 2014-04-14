/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.subway.ticket.builder;

import com.epam.subway.ticket.Ticket;
import com.epam.subway.ticket.TicketTime;
import com.epam.subway.ticket.TicketType;
import com.epam.subway.ticket.TimeTicketCard;
import java.util.Calendar;

/**
 * Builder for time ticket
 * @author Dmytro_Svynarenko
 */
public class TimeTicketBuilder extends TicketBuilder {

    private TicketTime time;
    private Calendar startDate;
    private TicketType type;
    
     public TimeTicketBuilder setTime(TicketTime time) {
        this.time = time;
        return this;
    }

    public TimeTicketBuilder setStartDate(Calendar startDate) {
        this.startDate = startDate;
        return this;
    }

    public TimeTicketBuilder setType(TicketType type) {
        this.type = type;
        return this;
    }

    
    @Override
    public Ticket build() {
        if(time!=null && startDate != null && type!=null) {
            TimeTicketCard t = new TimeTicketCard(time, startDate);
            t.setType(type);
            return t;
        } else {
            return null;
        }
    }
}

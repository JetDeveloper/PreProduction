/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.subway.ticket.builder;

import com.epam.subway.ticket.Ticket;
import com.epam.subway.ticket.TicketNumberOfTrips;
import com.epam.subway.ticket.TicketType;
import com.epam.subway.ticket.TripsTicketCard;

/**
 * Builder for trips ticket
 * @author Dmytro_Svynarenko
 */
public class TripsTicketBuilder extends TicketBuilder{
    private TicketNumberOfTrips trips;
    private TicketType type;

    public TripsTicketBuilder setTrips(TicketNumberOfTrips trips) {
        this.trips = trips;
        return this;
    }

    public TripsTicketBuilder setType(TicketType type) {
        this.type = type;
        return this;
    }
   
    @Override
    public Ticket build() {
        if(trips!=null && type != null) {
            TripsTicketCard t = new TripsTicketCard(trips);
            t.setType(type);
            return t;
        } else {
            return null;
        }
    }
    
    
}

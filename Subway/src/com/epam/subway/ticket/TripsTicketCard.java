/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.subway.ticket;

import java.util.Calendar;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class TripsTicketCard extends Ticket {

    private int numberOfTrips;

    public TripsTicketCard(TicketNumberOfTrips trips) {
        numberOfTrips = trips.getNumberOfTrips();
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    
    @Override
    public boolean check(Calendar currentDate, double price) {
        if (numberOfTrips > 0) {
            numberOfTrips--;
            return true;
        } else {
            return false;
        }
    }
}

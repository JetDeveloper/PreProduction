/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.subway.ticket;

/**
 *
 * @author Dmytro_Svynarenko
 */
public enum TicketNumberOfTrips {
    FIVE_TRIPS(5), TEN_TRIPS(10); 
    
    private int numberOfTrips;

    private TicketNumberOfTrips(int numberOfTrips) {
        this.numberOfTrips = numberOfTrips;
    }

    public int getNumberOfTrips() {
        return numberOfTrips;
    }
    
    
     
}

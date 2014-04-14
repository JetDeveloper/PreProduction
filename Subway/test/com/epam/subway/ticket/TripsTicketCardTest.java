/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.subway.ticket;

import com.epam.subway.ticket.builder.TripsTicketBuilder;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Matchers.anyDouble;
/**
 *
 * @author Dmytro_Svynarenko
 */
public class TripsTicketCardTest {
    
    @Test
    public void CheckCorrectFiveTrips() {
        Ticket test = new TripsTicketCard(TicketNumberOfTrips.FIVE_TRIPS);
        boolean expected = true;
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        boolean actual = test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        
        assertEquals(expected, actual);
    }
    @Test
    public void CheckIncorrectFiveTrips() {
        Ticket test = new TripsTicketCard(TicketNumberOfTrips.FIVE_TRIPS);
        boolean expected = false;
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        boolean actual = test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        
        assertEquals(expected, actual);
    }
    @Test
    public void CheckCorrectTenTrips() {
        Ticket test = new TripsTicketCard(TicketNumberOfTrips.TEN_TRIPS);
        boolean expected = true;
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        boolean actual = test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        
        assertEquals(expected, actual);
    }
    @Test
    public void CheckInorrectTenTrips() {
        Ticket test = new TripsTicketCard(TicketNumberOfTrips.TEN_TRIPS);
        boolean expected = false;
        
        for(int i=0;i<15;i++) {
            test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        }        
        boolean actual = test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        
        assertEquals(expected, actual);
    }
    @Test
    public void CheckCorrectFiveTripsCreatedWithBuilder() {
        TripsTicketBuilder ticketBuilder = new TripsTicketBuilder();
        Ticket test = ticketBuilder.setTrips(TicketNumberOfTrips.FIVE_TRIPS)
                .setType(TicketType.SCHOOL)
                .build();
        
        boolean expected = true;
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        boolean actual = test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        
        assertEquals(expected, actual);
    }
    @Test
    public void CheckIncorrectFiveTripsCreatedWithBuilder() {
        TripsTicketBuilder ticketBuilder = new TripsTicketBuilder();
        Ticket test = ticketBuilder.setTrips(TicketNumberOfTrips.FIVE_TRIPS)
                .setType(TicketType.SCHOOL)
                .build();
        
        boolean expected = false;
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        boolean actual = test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        
        assertEquals(expected, actual);
    }
    @Test
    public void CheckCorrectTenTripsCreatedWithBuilder() {
        TripsTicketBuilder ticketBuilder = new TripsTicketBuilder();
        Ticket test = ticketBuilder.setTrips(TicketNumberOfTrips.TEN_TRIPS)
                .setType(TicketType.SCHOOL)
                .build();
        
        boolean expected = true;
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        boolean actual = test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        
        assertEquals(expected, actual);
    }
    @Test
    public void CheckInorrectTenTripsCreatedWithBuilder() {
        TripsTicketBuilder ticketBuilder = new TripsTicketBuilder();
        Ticket test = ticketBuilder.setTrips(TicketNumberOfTrips.TEN_TRIPS)
                .setType(TicketType.SCHOOL)
                .build();
        
        boolean expected = false;
        
        for(int i=0;i<15;i++) {
            test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        }        
        boolean actual = test.check(new GregorianCalendar(2014, 3, 10), anyDouble());
        
        assertEquals(expected, actual);
    }
}

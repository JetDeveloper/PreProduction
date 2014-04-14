/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.subway.ticket;

import com.epam.subway.ticket.builder.TimeTicketBuilder;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Matchers.anyDouble;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class TimeTicketCardTest {

    @Test
    public void CheckCorrectMounthCard() {
        Ticket ticket = new TimeTicketCard(TicketTime.MOUNTH,
                new GregorianCalendar(2014, 3, 1));
        boolean expected = true;

        boolean actual = ticket.check(new GregorianCalendar(2014, 3, 10), anyDouble());

        assertEquals(expected, actual);
    }

    @Test
    public void CheckIncorrectMounthCard() {
        Ticket ticket = new TimeTicketCard(TicketTime.MOUNTH,
                new GregorianCalendar(2014, 3, 1));
        boolean expected = false;

        boolean actual = ticket.check(new GregorianCalendar(2014, 4, 10), anyDouble());

        assertEquals(expected, actual);
    }

    @Test
    public void CheckCorrect10DaysCard() {
        Ticket ticket = new TimeTicketCard(TicketTime.TEN_DAYS,
                new GregorianCalendar(2014, 3, 1));
        boolean expected = true;

        boolean actual = ticket.check(new GregorianCalendar(2014, 3, 10), anyDouble());

        assertEquals(expected, actual);
    }

    @Test
    public void CheckIncorrect10DaysCard() {
        Ticket ticket = new TimeTicketCard(TicketTime.TEN_DAYS,
                new GregorianCalendar(2014, 3, 1));
        boolean expected = false;

        boolean actual = ticket.check(new GregorianCalendar(2014, 3, 21), anyDouble());

        assertEquals(expected, actual);
    }

    @Test
    public void CheckCorrectMounthCardCreatedWithBuilder() {
        TimeTicketBuilder timeTicketBuilder = new TimeTicketBuilder();
        Ticket ticket = timeTicketBuilder.setStartDate(new GregorianCalendar(2014, 3, 1))
                .setTime(TicketTime.MOUNTH)
                .setType(TicketType.SCHOOL)
                .build();

        boolean expected = true;

        boolean actual = ticket.check(new GregorianCalendar(2014, 3, 10), anyDouble());

        assertEquals(expected, actual);
    }

    @Test
    public void CheckIncorrectMounthCardCreatedWithBuilder() {
        TimeTicketBuilder timeTicketBuilder = new TimeTicketBuilder();
        Ticket ticket = timeTicketBuilder.setStartDate(new GregorianCalendar(2014, 3, 1))
                .setTime(TicketTime.MOUNTH)
                .setType(TicketType.SCHOOL)
                .build();
        boolean expected = false;

        boolean actual = ticket.check(new GregorianCalendar(2014, 4, 10), anyDouble());

        assertEquals(expected, actual);
    }

    @Test
    public void CheckCorrect10DaysCardCreatedWithBuilder() {
        TimeTicketBuilder timeTicketBuilder = new TimeTicketBuilder();
        Ticket ticket = timeTicketBuilder.setStartDate(new GregorianCalendar(2014, 3, 1))
                .setTime(TicketTime.TEN_DAYS)
                .setType(TicketType.SCHOOL)
                .build();
        boolean expected = true;

        boolean actual = ticket.check(new GregorianCalendar(2014, 3, 10), anyDouble());

        assertEquals(expected, actual);
    }

    @Test
    public void CheckIncorrect10DaysCardCreatedWithBuilder() {
        TimeTicketBuilder timeTicketBuilder = new TimeTicketBuilder();
        Ticket ticket = timeTicketBuilder.setStartDate(new GregorianCalendar(2014, 3, 1))
                .setTime(TicketTime.TEN_DAYS)
                .setType(TicketType.SCHOOL)
                .build();
        boolean expected = false;

        boolean actual = ticket.check(new GregorianCalendar(2014, 3, 21), anyDouble());

        assertEquals(expected, actual);
    }
}

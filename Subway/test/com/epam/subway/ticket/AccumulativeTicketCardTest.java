/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.subway.ticket;

import com.epam.subway.turnstile.Turnstile;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class AccumulativeTicketCardTest {
    
    

    @Test
    public void IncreaseBalanceFor10() {
        AccumulativeTicketCard test = new AccumulativeTicketCard(100);
        double expected = 110;
        
        test.increaseBalance(10);
        double actual = test.getBalance();
        
        assertEquals(expected, actual, 0.01);
    }
    @Test
    public void CheckForIncorrectBalance() {
        Ticket test = new AccumulativeTicketCard(2);
        Turnstile subway = mock(Turnstile.class);
        when(subway.getPrice()).thenReturn(2.5);
        boolean expected = false;
        boolean actual = test.check(new GregorianCalendar(), subway.getPrice());

        
        assertEquals(expected, actual);
    }
    @Test
    public void CheckForCorrectBalance() {
        Ticket test = new AccumulativeTicketCard(20);
        Turnstile subway = mock(Turnstile.class);
        when(subway.getPrice()).thenReturn(2.5);
        boolean expected = true;
        boolean actual = test.check(new GregorianCalendar(), subway.getPrice());

        
        assertEquals(expected, actual);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.subway.turnstile;

import com.epam.subway.ticket.Ticket;
import java.util.Calendar;
import org.junit.Test;
import static org.mockito.Mockito.*;
/**
 * 
 * @author Dmytro_Svynarenko
 */
public class SubwayTurnstileTest {
    
    @Test
    public void SubwayTurnstileCheckCorrectTicket() {
        Ticket ticket = mock(Ticket.class);
        when(ticket.check(Calendar.getInstance(), 2.5)).thenReturn(Boolean.TRUE);
        Turnstile subwayTurnstile = new SubwayTurnstile();
        
        subwayTurnstile.checkTicket(ticket);
    }
    
    @Test
    public void SubwayTurnstileCheckIncorrectTicket() {
        Ticket ticket = mock(Ticket.class);
        when(ticket.check(Calendar.getInstance(), 2.5)).thenReturn(Boolean.FALSE);
        Turnstile subwayTurnstile = new SubwayTurnstile();
        
        subwayTurnstile.checkTicket(ticket);
    }
}

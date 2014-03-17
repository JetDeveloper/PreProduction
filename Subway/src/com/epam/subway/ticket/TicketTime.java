/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.subway.ticket;

/**
 *
 * @author Dmytro_Svynarenko
 */
public enum TicketTime {
    MOUNTH(30), TEN_DAYS(10);
    
    private int days;

    private TicketTime(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    } 
    
}

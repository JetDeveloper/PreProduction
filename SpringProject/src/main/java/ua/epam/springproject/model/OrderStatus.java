/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.epam.springproject.model;

/**
 * Class describes order status
 * @author Dima
 */
public class OrderStatus {
    private int id;
    private String statusName;

    public OrderStatus(int id, String statusName) {
        this.id = id;
        this.statusName = statusName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
        
    @Override
    public String toString() {
        return "OrderStatus{" + "id=" + id + ", statusName=" + statusName + '}';
    }
    
}

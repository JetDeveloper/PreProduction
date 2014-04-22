/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.springproject.model;

/**
 * Class describes driver's truck
 *
 * @author Dima
 */
public class Auto {

    private final double MAX_WEIGHT;

    private int id;
    private User owner;
    private String name;
    private boolean ok;
    public Auto(int id, String name, User owner, double MAX_WEIGHT, boolean ok) {
        this.MAX_WEIGHT = MAX_WEIGHT;
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.ok = ok;
    }

    public double getMAX_WEIGHT() {
        return MAX_WEIGHT;
    }

    
    public int getId() {
        return id;
    } 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    @Override
    public String toString() {
        return "Auto{" + "MAX_WEIGHT=" + MAX_WEIGHT + ", id=" + id + ", owner=" 
                + owner + ", ok=" + ok + '}';
    }

}

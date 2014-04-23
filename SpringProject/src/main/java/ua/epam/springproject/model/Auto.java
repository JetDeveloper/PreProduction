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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.MAX_WEIGHT) ^ (Double.doubleToLongBits(this.MAX_WEIGHT) >>> 32));
        hash = 97 * hash + this.id;
        hash = 97 * hash + (this.owner != null ? this.owner.hashCode() : 0);
        hash = 97 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 97 * hash + (this.ok ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Auto other = (Auto) obj;
        if (Double.doubleToLongBits(this.MAX_WEIGHT) != Double.doubleToLongBits(other.MAX_WEIGHT)) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (this.owner != other.owner && (this.owner == null || !this.owner.equals(other.owner))) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (this.ok != other.ok) {
            return false;
        }
        return true;
    }

}

package ua.epam.rentproject.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Dmytro_Svynarenko
 * @version 1.0
 * @created 05-���-2014 15:25:55
 */
@Entity
@Table(name = "Penalty")
@NamedQueries({
    @NamedQuery(name = "Penalty.getAllPenalties", query = "SELECT p from Penalty p"),
    @NamedQuery(name = "Penalty.getPenaltyById", query = "SELECT p from Penalty p WHERE p.penaltyId = :id")
})
public class Penalty implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int penaltyId;
    @Column(name = "penaltyName")
    private String penaltyName;
    @Column(name = "penaltyPrice")
    private float penaltyPrice;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "DEAL_PENALTIES",
    joinColumns = {
        @JoinColumn(name = "penaltyId")},
    inverseJoinColumns = {
        @JoinColumn(name = "dealId")})
    private Set<Deal> deals = new HashSet<>();

    public Penalty(int id, String name, float price) {
        this.penaltyId = id;
        this.penaltyName = name;
        this.penaltyPrice = price;
    }

    public Penalty() {
    }

    public int getPenaltyId() {
        return penaltyId;
    }

    public String getPenaltyName() {
        return penaltyName;
    }

    public float getPenaltyPrice() {
        return penaltyPrice;
    }

    public void setPenaltyId(int newVal) {
        penaltyId = newVal;
    }

    public void setPenaltyName(String newVal) {
        penaltyName = newVal;
    }

    public void setPenaltyPrice(float newVal) {
        penaltyPrice = newVal;
    }

    public Set<Deal> getDeals() {
        return deals;
    }

    public void setDeals(Set<Deal> deals) {
        this.deals = deals;
    }

    @Override
    public String toString() {
        return "Penalty{" + "penaltyId=" + penaltyId + ", penaltyName=" + penaltyName + ", penaltyPrice=" + penaltyPrice + '}';
    }
    
}
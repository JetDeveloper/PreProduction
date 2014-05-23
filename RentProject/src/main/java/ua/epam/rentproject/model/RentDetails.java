package ua.epam.rentproject.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
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
 * @created 05-май-2014 15:25:58
 */
@Entity
@Table(name = "RentDetails")
@NamedQueries({
    @NamedQuery(name = "RentDetails.getAllRentDetails", query = "SELECT r from RentDetails r"),
    @NamedQuery(name = "RentDetails.getRentDetailById", query = "SELECT r from RentDetails r WHERE r.rentDetailId = :id")
})
public class RentDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rentDetailId;
    @Column(name = "isBonus")
    private boolean bonus;
    @Column(name = "rentDetailName")
    private String rentDetailName;
    @Column(name = "rentDetailPrice")
    private float rentDetailPrice;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "DEAL_RENTDETAILS",
    joinColumns = {
        @JoinColumn(name = "rentDetailsId")},
    inverseJoinColumns = {
        @JoinColumn(name = "dealId")})
    private Set<Deal> deals = new HashSet<>();

    public RentDetails(String name, float price, boolean bonus) {
        this.rentDetailName = name;
        this.rentDetailPrice = price;
        this.bonus = bonus;
    }

    public RentDetails() {
    }

    public int getRentDetailId() {
        return rentDetailId;
    }

    public void setRentDetailId(int rentDetailId) {
        this.rentDetailId = rentDetailId;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public String getRentDetailName() {
        return rentDetailName;
    }

    public void setRentDetailName(String rentDetailName) {
        this.rentDetailName = rentDetailName;
    }

    public float getRentDetailPrice() {
        return rentDetailPrice;
    }

    public void setRentDetailPrice(float rentDetailPrice) {
        this.rentDetailPrice = rentDetailPrice;
    }

    public Set<Deal> getDeals() {
        return deals;
    }

    public void setDeals(Set<Deal> deals) {
        this.deals = deals;
    }

    @Override
    public String toString() {
        return "RentDetails{" + "rentDetailId=" + rentDetailId + ", bonus=" + bonus + ", rentDetailName=" + rentDetailName + ", rentDetailPrice=" + rentDetailPrice + '}';
    }
}
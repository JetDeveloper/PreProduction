package ua.epam.rentproject.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Dmytro_Svynarenko
 * @version 1.0
 * @created 05-���-2014 15:25:49
 */
@Entity
@Table(name = "Deal")
@NamedQueries({
    @NamedQuery(name = "Deal.getAllDeals", query = "SELECT d from Deal d"),
    @NamedQuery(name = "Deal.getDealById", query = "SELECT d from Deal d WHERE d.dealId = :id")
})
public class Deal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dealId;
    @OneToMany(fetch= FetchType.EAGER)
    @JoinColumn(name = "carId")
    private List<Car> car;
    
    @Column(name = "fullPrice")
    private float fullPrice;
    
    @OneToOne
    @JoinColumn(name = "managerId")
    private User manager;
    
    @ManyToMany (fetch = FetchType.EAGER,  mappedBy = "deals")
    private Set<Penalty> penalties;
    
    @ManyToMany (fetch= FetchType.EAGER, mappedBy = "deals")
    private Set<RentDetails> rentDetails = new HashSet<>();
    
    @Column(name = "hours")
    private int time;
    
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Deal() {
    }

    public List<Car> getCar() {
        return car;
    }

    public int getDealId() {
        return dealId;
    }

    public float getFullPrice() {
        return fullPrice;
    }

    public User getManager() {
        return manager;
    }

    public Set<Penalty> getPenalties() {
        return penalties;
    }

    public Set<RentDetails> getRentDetails() {
        return rentDetails;
    }

    public int getTime() {
        return time;
    }

    public User getUser() {
        return user;
    }

    public void setCar(List<Car> newVal) {
        car = newVal;
    }

    public void setDealId(int newVal) {
        dealId = newVal;
    }

    public void setFullPrice(float newVal) {
        fullPrice = newVal;
    }

    public void setManager(User newVal) {
        manager = newVal;
    }

    public void setPenalties(Set<Penalty> newVal) {
        penalties = newVal;
    }

    public void setRentDetails(Set<RentDetails> newVal) {
        rentDetails = newVal;
    }


    public void setTime(int newVal) {
        time = newVal;
    }

    public void setUser(User newVal) {
        user = newVal;
    }

    @Override
    public String toString() {
        return "Deal{" + "dealId=" + dealId + ", car=" + car + ", fullPrice=" + fullPrice + ", manager=" + manager + ", penalties=" + penalties + ", rentDetails=" + rentDetails + ", time=" + time + ", user=" + user + '}';
    }
    
}
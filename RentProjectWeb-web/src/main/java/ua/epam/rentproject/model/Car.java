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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Dmytro_Svynarenko
 * @version 1.0
 * @created 05-���-2014 15:25:46
 */
@Entity
@Table(name = "Car")
@NamedQueries({
    @NamedQuery(name = "Car.getAll", query = "SELECT c from Car c"),
    @NamedQuery(name = "Car.getAllOK", query = "SELECT c from Car c WHERE c.ok = true"),
    @NamedQuery(name = "Car.getCarById", query = "SELECT c from Car c WHERE c.carId = :id"),
    @NamedQuery(name = "Car.getAllCarByType", query = "SELECT c from Car c WHERE c.type = :type")
})
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int carId;
    @Column(name = "carDescription")
    private String carDescription;
    @Column(name = "carModel")
    private String carModel;
    @Column(name = "carPrice")
    private float carPrice;
    @Column(name = "isOk")
    private Boolean ok;
    @OneToMany(mappedBy = "car")
    private Set<Deal> deals = new HashSet<>();
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type")
    private CarType type;
    
    public Car(String model, float price) {
        this.carModel = model;
        this.carPrice = price;
        this.ok = Boolean.TRUE;
    }

    public Car() {
    }

    public String getCarDescription() {
        return carDescription;
    }

    public int getCarId() {
        return carId;
    }

    public String getCarModel() {
        return carModel;
    }

    public float getCarPrice() {
        return carPrice;
    }

    public boolean isOk() {
        return ok;
    }

    public void setCarDescription(String newVal) {
        carDescription = newVal;
    }

    public void setCarId(int newVal) {
        carId = newVal;
    }

    public void setCarModel(String newVal) {
        carModel = newVal;
    }

    public void setCarPrice(float newVal) {
        carPrice = newVal;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public Set<Deal> getDeals() {
        return deals;
    }

    public void setDeals(Set<Deal> deals) {
        this.deals = deals;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" + "carId=" + carId + ", carDescription=" + carDescription + ", carModel=" + carModel + ", carPrice=" + carPrice + ", ok=" + ok + '}';
    }

    
}
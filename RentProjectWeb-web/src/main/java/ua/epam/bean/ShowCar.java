/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.bean;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.primefaces.event.TabChangeEvent;
import ua.epam.rentproject.dao.car.CarDAO;
import ua.epam.rentproject.dao.car.CarDAOImpl;
import ua.epam.rentproject.model.Car;
import ua.epam.rentproject.model.CarType;

/**
 *
 * @author Dmytro_Svynarenko
 */
@ManagedBean(name = "showCar")
@SessionScoped
public class ShowCar implements Serializable{

    /**
     * Creates a new instance of ShowCar
     */
    private CarDAO carDAO;
    private List<Car> cars;
    private List<CarType> carTypes;
    
    @PersistenceContext(unitName="Rent")
    private EntityManager em;
    public ShowCar() {   
          carDAO = new CarDAOImpl(em);
    }

    @PostConstruct
    public void fooBar() {
        carDAO = new CarDAOImpl(em);
        cars = carDAO.getAllCars();
    }
    public void onTabChange(TabChangeEvent event) {
        String s = event.getTab().getTitle();
        List<CarType> temp = carDAO.getCarTypes();
        for(CarType ct : temp) {
            if(ct.getType().equals(s)) {
                cars = carDAO.getAllCarsByType(ct);
            }
        }
    }
    public CarDAO getCarDAO() {
        return carDAO;
    }

    public void setCarDAO(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public List<Car> getCars() {
        //cars = carDAO.getAllCars();
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<CarType> getCarTypes() {
        carTypes = carDAO.getCarTypes();
        return carTypes;
    }

    public void setCarTypes(List<CarType> carTypes) {
        this.carTypes = carTypes;
    }
    
    
}

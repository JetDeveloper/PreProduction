/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.rentproject.dao.car;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import ua.epam.rentproject.model.Car;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class CarDAOImpl implements CarDAO {

    private EntityManager entityManager;

    public CarDAOImpl() {
    }

    public CarDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Car> getAllCars() {
        TypedQuery<Car> carQuery = entityManager.createNamedQuery("Car.getAll", Car.class);
        return carQuery.getResultList();
    }

    @Override
    public Car getCarById(int id) {
        TypedQuery<Car> carQuery = entityManager.createNamedQuery("Car.getCarById", Car.class);
        carQuery.setParameter("id", id);
        return carQuery.getSingleResult();
    }

    @Override
    public Integer insertCar(Car car) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(car);
            entityManager.getTransaction().commit();
            return car.getCarId();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
                return null;
            }
        }
    }

    @Override
    public void updateCar(Car car) {
        Car temp = entityManager.find(Car.class, car.getCarId());
        if (temp == null) {
            insertCar(car);
        } else {
            try {
                entityManager.getTransaction().begin();
                temp.setCarDescription(car.getCarDescription());
                temp.setCarModel(car.getCarModel());
                temp.setCarPrice(car.getCarPrice());
                temp.setDeals(car.getDeals());
                temp.setOk(car.isOk());
                entityManager.getTransaction().commit();
            } finally {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            }
        }
    }

    @Override
    public void deleteCar(Car car) {
        Car temp = entityManager.find(Car.class, car.getCarId());
        if (temp != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(temp);
                entityManager.getTransaction().commit();
            } finally {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            }
        }
    }

    @Override
    public List<Car> getAllOKCars() {
        TypedQuery<Car> carQuery = entityManager.createNamedQuery("Car.getAllOK", Car.class);
        return carQuery.getResultList();
    }
}

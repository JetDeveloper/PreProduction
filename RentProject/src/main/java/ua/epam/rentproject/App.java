package ua.epam.rentproject;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import ua.epam.rentproject.dao.car.CarDAO;
import ua.epam.rentproject.dao.car.CarDAOImpl;
import ua.epam.rentproject.dao.deal.service.DealService;
import ua.epam.rentproject.dao.deal.service.DealServiceImpl;
import ua.epam.rentproject.dao.user.UserDAO;
import ua.epam.rentproject.dao.user.UserDAOImpl;
import ua.epam.rentproject.model.Car;
import ua.epam.rentproject.model.Role;
import ua.epam.rentproject.model.User;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Rent");
        EntityManager em = emf.createEntityManager();
    
        TypedQuery<Car> query =
                em.createNamedQuery("Car.getAll", Car.class);
        List<Car> results = query.getResultList();
        System.out.println("All cars");
        System.out.println(results);
        
        query = em.createNamedQuery("Car.getAllOK", Car.class);
        results = query.getResultList();
        System.out.println("All OK  cars");
        System.out.println(results);

        //test some userDAO
        UserDAO userDAO = new UserDAOImpl(em);
       /* System.out.println("All users");
        System.out.println(userDAO.getAllUsers());
        System.out.println("User with id 1");
        System.out.println(userDAO.getUserById(1));
        int id = userDAO.insertUser(new User("userIns", "pass", new GregorianCalendar(2014, 5, 25), null));
        System.out.println("Added new user with id " + id);
        User temp = userDAO.getUserById(id);
        System.out.println(temp);
        temp.setFullName("Update user");
        userDAO.udpateUser(temp);
        System.out.println("Update user with id " + id);
        System.out.println(userDAO.getUserById(id));
        System.out.println("Deleted user with id " + id);
        userDAO.deleteUser(temp);
        System.out.println(userDAO.getAllUsers());
        */
        //test some userDAO
        CarDAO carDAO = new CarDAOImpl(em);
       /* System.out.println("All cars");
        System.out.println(carDAO.getAllCars());
        System.out.println("All OK cars");
        System.out.println(carDAO.getAllOKCars());
        System.out.println("Car with id 1");
        System.out.println(carDAO.getCarById(1));
        id = carDAO.insertCar(new Car("Insert Car", 50000));
        System.out.println("Added new car with id " + id);
        Car tempCar = carDAO.getCarById(id);
        System.out.println(tempCar);
        tempCar.setCarDescription("Some desc");
        tempCar.setOk(Boolean.FALSE);
        carDAO.updateCar(tempCar);
        System.out.println("Update car with id " + id);
        System.out.println(carDAO.getCarById(id));
        System.out.println("Deleted car with id " + id);
        carDAO.deleteCar(tempCar);
        System.out.println(carDAO.getAllCars());
        */
        DealService dealService = new DealServiceImpl(em, carDAO, userDAO);
        System.out.println(dealService.getAllDeals());
        em.close();

    }
}

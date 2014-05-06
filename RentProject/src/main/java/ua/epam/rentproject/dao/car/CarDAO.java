package ua.epam.rentproject.dao.car;

import java.util.List;
import ua.epam.rentproject.model.Car;

/**
 * @author Dmytro_Svynarenko
 * @version 1.0
 * @created 05-май-2014 15:35:18
 */
public interface CarDAO {

    public List<Car> getAllCars();

    public Car getCarById(int id);

    public int insertCar(Car car);

    public void updateCar(Car car);

    public void deleteCar(Car car);
}
package ua.epam.rentproject.dao.car;

import java.util.List;
import ua.epam.rentproject.model.Car;
import ua.epam.rentproject.model.CarType;

/**
 * @author Dmytro_Svynarenko
 * @version 1.0
 * @created 05-май-2014 15:35:18
 */
public interface CarDAO {

    public List<Car> getAllCars();

    public Car getCarById(int id);
    
    public List<Car> getAllOKCars();

    public Integer insertCar(Car car);

    public void updateCar(Car car);

    public void deleteCar(Car car);
    
    public List<CarType> getCarTypes();
    
    public List<Car> getAllCarsByType(CarType carType);
}
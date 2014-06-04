package ua.epam.rentproject.controller;

import java.util.List;
import ua.epam.rentproject.model.Car;
import ua.epam.rentproject.model.Deal;
import ua.epam.rentproject.model.RentDetails;

/**
 * @author Dmytro_Svynarenko
 * @version 1.0
 * @created 05-май-2014 15:35:39
 */
public abstract class ClientController {

	protected Deal deal;

	public ClientController(){

	}


	/**
	 * 
	 * @param car
	 */
	public void chooseCar(Car car){

	}

	/**
	 * 
	 * @param details
	 */
	public void chooseDetails(List<RentDetails> details){

	}

	public abstract void formOrder();

	public Deal getdeal(){
		return deal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdeal(Deal newVal){
		deal = newVal;
	}

	public Car viewCar(){
		return null;
	}

}
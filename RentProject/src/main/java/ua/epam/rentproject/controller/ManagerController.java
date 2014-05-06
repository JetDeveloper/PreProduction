package ua.epam.rentproject.controller;

import java.util.List;
import ua.epam.rentproject.model.Deal;
import ua.epam.rentproject.model.User;

/**
 * @author Dmytro_Svynarenko
 * @version 1.0
 * @created 05-май-2014 15:35:45
 */
public class ManagerController {

	private List<Deal> unprocessedDeals;

	public ManagerController(){

	}



	public List<Deal> getunprocessedDeals(){
		return unprocessedDeals;
	}

	/**
	 * 
	 * @param deal
	 */
	public void processDeal(Deal deal){

	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUnprocessedDeals(List<Deal> newVal){
		unprocessedDeals = newVal;
	}

	public void viewAllUnprocessedDeals(){

	}

	public void viewCars(){

	}

	/**
	 * 
	 * @param client
	 */
	public void viewClient(User client){

	}

	/**
	 * 
	 * @param client
	 */
	public void viewClientHistory(User client){

	}

	public void viewPenalties(){

	}

}
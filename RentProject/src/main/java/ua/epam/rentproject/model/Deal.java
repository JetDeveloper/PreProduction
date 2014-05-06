package ua.epam.rentproject.model;

import java.util.List;

/**
 * @author Dmytro_Svynarenko
 * @version 1.0
 * @created 05-���-2014 15:25:49
 */
public class Deal {

        private int dealId;
	private Car car;
	private float fullPrice;
	private User manager;
	private List<Penalty> penalties;
	private List<RentDetails> rentDetails;
	private int time;
	private User user;

	public Deal(){

	}

	public Car getCar(){
		return car;
	}

	public int getDealId(){
		return dealId;
	}

	public float getFullPrice(){
		return fullPrice;
	}

	public User getManager(){
		return manager;
	}

	public List<Penalty> getPenalties(){
		return penalties;
	}

	public List<RentDetails> getRentDetails(){
		return rentDetails;
	}

	public int getTime(){
		return time;
	}

	public User getUser(){
		return user;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCar(Car newVal){
		car = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDealId(int newVal){
		dealId = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFullPrice(float newVal){
		fullPrice = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setManager(User newVal){
		manager = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPenalties(List<Penalty> newVal){
		penalties = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRentDetails(List<RentDetails> newVal){
		rentDetails = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTime(int newVal){
		time = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUser(User newVal){
		user = newVal;
	}

}
package ua.epam.rentproject.model;

/**
 * @author Dmytro_Svynarenko
 * @version 1.0
 * @created 05-���-2014 15:25:55
 */
public class Penalty {

	private int penaltyId;
	private String penaltyName;
	private float penaltyPrice;

         /**
	 * 
	 * @param id
	 * @param name
	 * @param price
	 */
	public Penalty(int id, String name, float price){
            this.penaltyId = id;
            this.penaltyName = name;
            this.penaltyPrice = price;
	}

	public Penalty(){

	}

	public int getPenaltyId(){
		return penaltyId;
	}

	public String getPenaltyName(){
		return penaltyName;
	}

	public float getPenaltyPrice(){
		return penaltyPrice;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPenaltyId(int newVal){
		penaltyId = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPenaltyName(String newVal){
		penaltyName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPenaltyPrice(float newVal){
		penaltyPrice = newVal;
	}

}
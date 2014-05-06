package ua.epam.rentproject.model;

/**
 * @author Dmytro_Svynarenko
 * @version 1.0
 * @created 05-���-2014 15:25:46
 */
public class Car {

	private String carDescription;
	private int carId;
	private String carModel;
	private float carPrice;
	private boolean ok;

	/**
	 * 
	 * @param model
	 * @param price
	 */
	public Car(String model, float price){
            this.carModel = model;
            this.carPrice = price;
        }

	public Car(){

	}

	public String getcarDescription(){
		return carDescription;
	}

	public int getcarId(){
		return carId;
	}

	public String getcarModel(){
		return carModel;
	}

	public float getcarPrice(){
		return carPrice;
	}

	public boolean isOK(){
		return ok;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcarDescription(String newVal){
		carDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcarId(int newVal){
		carId = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcarModel(String newVal){
		carModel = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcarPrice(float newVal){
		carPrice = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOK(boolean newVal){
		ok = newVal;
	}

}
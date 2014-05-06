package ua.epam.rentproject.model;

/**
 * @author Dmytro_Svynarenko
 * @version 1.0
 * @created 05-май-2014 15:25:58
 */
public class RentDetails {

    private boolean bonus;
    private int rentDetailId;
    private String rentDetailName;
    private float rentDetailPrice;

    /**
     *
     * @param name
     * @param price
     * @param bonus
     */
    public RentDetails(String name, float price, boolean bonus) {
        this.rentDetailName = name;
        this.rentDetailPrice = price;
        this.bonus = bonus;
    }

    public RentDetails() {
    }

    public int getRentDetailId() {
        return rentDetailId;
    }

    public String getRentDetailName() {
        return rentDetailName;
    }

    public float getRentDetailPrice() {
        return rentDetailPrice;
    }

    public boolean isBonus() {
        return bonus;
    }

    /**
     *
     * @param newVal
     */
    public void setBonus(boolean newVal) {
        bonus = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setRentDetailId(int newVal) {
        rentDetailId = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setRentDetailName(String newVal) {
        rentDetailName = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setRentDetailPrice(float newVal) {
        rentDetailPrice = newVal;
    }
}
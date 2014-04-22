/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.springproject.model;

/**
 * Class describes client's order
 *
 * @author Dima
 */
public class Order {

    private int id;
    private String clientFullname;
    private String clientContact;
    private User dispatcher;
    private double distance;
    private String startPoint;
    private String endPoint;
    private double weight;
    private User trucker;
    private Auto truck;
    private OrderStatus status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientFullname() {
        return clientFullname;
    }

    public void setClientFullname(String clientFullname) {
        this.clientFullname = clientFullname;
    }

    public String getClientContact() {
        return clientContact;
    }

    public void setClientContact(String clientContact) {
        this.clientContact = clientContact;
    }

    

    public User getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(User dispatcher) {
        this.dispatcher = dispatcher;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public User getTrucker() {
        return trucker;
    }

    public void setTrucker(User trucker) {
        this.trucker = trucker;
    }

    public Auto getTruck() {
        return truck;
    }

    public void setTruck(Auto truck) {
        this.truck = truck;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", clientFullname=" + clientFullname 
                + ", clientContact=" + clientContact + ", dispatcher=" 
                + dispatcher + ", distance=" + distance + ", startPoint="
                + startPoint + ", endPoint=" + endPoint + ", weight=" + weight 
                + ", trucker=" + trucker + ", truck=" + truck + ", status=" 
                + status + '}';
    }

}

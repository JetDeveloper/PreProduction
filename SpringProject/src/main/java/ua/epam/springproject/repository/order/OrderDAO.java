/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.springproject.repository.order;

import java.util.List;
import ua.epam.springproject.model.Order;
import ua.epam.springproject.model.OrderStatus;

/**
 * Interface describes all methods which are need for working with DB
 *
 * @author Dima
 */
public interface OrderDAO {

    List<Order> getAllOrders(OrderStatus orderStatus);

    List<Order> getAllOrders(OrderStatus orderStatus, int userId);

    List<OrderStatus> getAllOrderStatus();

    Order getOrder(int id);

    OrderStatus getOrderStatus(int id);

    int insertOrder(Order order);

    void updateOrder(Order order);
}

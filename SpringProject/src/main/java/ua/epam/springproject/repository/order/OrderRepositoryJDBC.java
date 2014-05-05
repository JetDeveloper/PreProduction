/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.springproject.repository.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.epam.springproject.model.Auto;
import ua.epam.springproject.model.Order;
import ua.epam.springproject.model.OrderStatus;
import ua.epam.springproject.repository.user.UserDAO;
import static ua.epam.springproject.repository.util.DAOJDBCUtil.*;

/**
 *
 * @author Dmytro_Svynarenko
 */
@Repository("orderRepository")
public class OrderRepositoryJDBC implements OrderDAO {

    public static final String GET_ALL_ORDERS = "SELECT order_id,"
            + "  order_client_fullname,"
            + "  order_client_contact,"
            + "  order_dispatcher_id,"
            + "  order_distance,"
            + "  order_start_point,"
            + "  order_end_point,"
            + "  order_weight,"
            + "  order_trucker_id,"
            + "  order_car_id,"
            + "  order_status_id FROM Orders";
    public static final String GET_ALL_ORDERS_WITH = "SELECT order_id,"
            + "  order_client_fullname,"
            + "  order_client_contact,"
            + "  order_dispatcher_id,"
            + "  order_distance,"
            + "  order_start_point,"
            + "  order_end_point,"
            + "  order_weight,"
            + "  order_trucker_id,"
            + "  order_car_id,"
            + "  order_status_id FROM Orders WHERE ";
    public static final String GET_ALL_ORDER_STATUSES = " SELECT order_status_id,"
            + "  order_status_name FROM order_status";
    public static final String GET_ORDER_STATUS_BY_ID = " SELECT order_status_id,"
            + "  order_status_name FROM order_status WHERE  order_status_id = ";
   
    @Autowired
    private DataSource ds;
    
    @Autowired
    private UserDAO userRepository;

    @Override
    public List<Order> getAllOrders(OrderStatus orderStatus) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Order> orders = new ArrayList<>();

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_ORDERS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(mapOrder(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return orders;
    }

    @Override
    public List<Order> getAllOrders(OrderStatus orderStatus, int userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<OrderStatus> getAllOrderStatus() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<OrderStatus> orderStatuses = new ArrayList<>();

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_ORDER_STATUSES);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orderStatuses.add(mapOrderStatus(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return orderStatuses;
    }

    @Override
    public Order getOrder(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OrderStatus getOrderStatus(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        OrderStatus orderStatus = null;

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(GET_ORDER_STATUS_BY_ID + id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orderStatus = mapOrderStatus(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return orderStatus;
    }

    @Override
    public int insertOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private Order mapOrder(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt("order_id"));
        order.setClientFullname(resultSet.getString("order_client_fullname"));
        order.setClientContact(resultSet.getString("order_client_contact"));
        order.setDispatcher(userRepository.getUser(resultSet.getInt("order_dispatcher_id")));
        order.setDistance(resultSet.getDouble("order_distance"));
        order.setStartPoint(resultSet.getString("order_start_point"));
        order.setEndPoint(resultSet.getString("order_end_point"));
        order.setWeight(resultSet.getDouble("order_weight"));
        order.setTrucker(userRepository.getUser(resultSet.getInt("order_trucker_id")));
        for (Auto auto : order.getTrucker().getAuto()) {
            if (auto.getId() == resultSet.getInt("order_car_id")) {
                order.setTruck(auto);
            }
        }
        order.setStatus(null);

        return order;
    }

    private OrderStatus mapOrderStatus(ResultSet resultSet) throws SQLException {
        OrderStatus status = new OrderStatus();
        status.setId(resultSet.getInt("order_status_id"));
        status.setStatusName(resultSet.getString("order_status_name"));
        return status;
    }
}

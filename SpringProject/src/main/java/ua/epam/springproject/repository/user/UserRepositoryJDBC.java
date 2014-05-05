/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.springproject.repository.user;

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
import ua.epam.springproject.model.Role;
import ua.epam.springproject.model.User;
import static ua.epam.springproject.repository.util.DAOJDBCUtil.*;

/**
 *
 * @author Dmytro_Svynarenko
 */
@Repository("userRepository")
public class UserRepositoryJDBC implements UserDAO {

    public static final String GET_ALL_USERS = "select * from users";
    public static final String GET_ALL_USERS_WITH_ROLE = "select * from users where user_role_id=";
    public static final String GET_ROLE_BY_ID = "select * from role where role_id = ";
    public static final String GET_USER_BY_ID = "select * from users where user_id=";
    public static final String GET_ALL_USER_AUTOS = "select car_id,car_name, max_weight, isOK from car where trucker_id = ";
    
    public static final String AUTO_MAX_WEIGHT = "max_weight";
    public static final String AUTO_CAR_ID = "car_id";
    public static final String AUTO_CAR_NAME = "car_name";
    public static final String AUTO_TRUCKER_ID = "trucker_id";
    public static final String AUTO_IS_OK = "isOK";
    public static final String ROLE_ID = "role_id";
    public static final String ROLE_NAME = "role_name";
    
    @Autowired
    private DataSource ds;

    public UserRepositoryJDBC() {
    }

    public UserRepositoryJDBC(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public List<User> getAllUsers() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_USERS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return users;
    }

    @Override
    public List<User> getAllUsers(Role role) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_USERS_WITH_ROLE
                    + role.getId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return users;
    }

    @Override
    public List<Auto> getAllUserAutos(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Auto> autos = new ArrayList<>();
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_USER_AUTOS + user.getId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                autos.add(mapAuto(resultSet, user));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return autos;
    }

    @Override
    public List<Role> getAllUserRoles() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Role getRole(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Role role = new Role();

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(GET_ROLE_BY_ID + id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                role.setId(resultSet.getInt(ROLE_ID));
                role.setName(resultSet.getString(ROLE_NAME));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return role;
    }

    @Override
    public User getUser(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(GET_USER_BY_ID + id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = map(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return user;
    }

    @Override
    public void updateAuto(Auto auto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public User auth(String login, String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private User map(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt(USER_ID_FIELD));
        user.setPassword(resultSet.getString(USER_PASSWORD_FIELD));
        user.setLogin(resultSet.getString(USER_LOGIN_FIELD));
        user.setRole(getRole(resultSet.getInt(USER_ROLE_ID_FIELD)));
        user.setContactNumber(resultSet.getString(USER_CONTACT_NUMBER));
        user.setFullName(resultSet.getString(USER_FULLNAME_FIELD));

        return user;
    }

    private Auto mapAuto(ResultSet resultSet, User owner) throws SQLException {
        Auto auto = new Auto(resultSet.getDouble(AUTO_MAX_WEIGHT));
        auto.setId(resultSet.getInt(AUTO_CAR_ID));
        auto.setName(resultSet.getString(AUTO_CAR_NAME));
        auto.setOwner(owner);
        auto.setOk(resultSet.getBoolean(AUTO_IS_OK));
        return auto;
    }
}

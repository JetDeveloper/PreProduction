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
public class UserRepositoryJDBC implements UserDAO{

    @Autowired
    private DataSource ds;

    public UserRepositoryJDBC() {
    }

    public UserRepositoryJDBC(DataSource ds) {
        this.ds = ds;
    }
    
    
    public List<User> getAllUsers() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<User>();
        
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement("select * from users");
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

    public List<User> getAllUsers(Role role) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Auto> getAllUserAutos(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Role> getAllUserRoles() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Role getRole(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Role role = new Role();
        
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement("select * from role where role_id = " + id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                role.setId(resultSet.getInt("role_id"));
                role.setName(resultSet.getString("role_name"));
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

    public User getUser(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement("select * from users where user_id=" + id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user =  map(resultSet);
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

    public void updateAuto(Auto auto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

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
    
}

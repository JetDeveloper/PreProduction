/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.springproject.repository.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import ua.epam.springproject.model.Role;
import ua.epam.springproject.model.User;
import ua.epam.springproject.repository.DAOTestsTemplate;
import static ua.epam.springproject.repository.user.UserDAO.*;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class UserRepositoryJDBCTest extends DAOTestsTemplate {

    @Autowired
    private UserRepositoryJDBC userRepository;

    @Test
    public void testGetAllUsers_COUNT_EQUALS() {
        List<User> users = userRepository.getAllUsers();

        int count = this.jdbcTemplate.queryForObject(
                "select count(*) from users", Integer.class);
        Assert.assertEquals(users.size(), count);
    }

    @Test
    public void testGetUsers_CHECK_FIRST_USER() {
        User user = userRepository.getUser(1);
        User dbUser = this.jdbcTemplate.queryForObject(
                "select * from users where user_id = ?",
                new Object[]{1},
                new RowMapper<User>() {
                    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                        User user = new User();
                        user.setId(resultSet.getInt(USER_ID_FIELD));
                        user.setPassword(resultSet.getString(USER_PASSWORD_FIELD));
                        user.setLogin(resultSet.getString(USER_LOGIN_FIELD));
                        user.setRole(new Role(1, "trucker"));
                        user.setContactNumber(resultSet.getString(USER_CONTACT_NUMBER));
                        user.setFullName(resultSet.getString(USER_FULLNAME_FIELD));
                        return user;
                    } 
                });
        Assert.assertEquals(user.equals(dbUser), true);
    }
}

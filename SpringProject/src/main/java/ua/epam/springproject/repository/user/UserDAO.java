/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.springproject.repository.user;

import java.util.List;
import ua.epam.springproject.model.Auto;
import ua.epam.springproject.model.Role;
import ua.epam.springproject.model.User;

/**
 *
 * @author Dmytro_Svynarenko
 */
public interface UserDAO {

    final String USER_ID_FIELD = "user_id";
    final String USER_LOGIN_FIELD = "user_login";
    final String USER_PASSWORD_FIELD = "user_password";
    final String USER_ROLE_ID_FIELD = "user_role_id";
    final String USER_FULLNAME_FIELD = "user_fullname";
    final String USER_CONTACT_NUMBER = "user_contact_number";

    List<User> getAllUsers();

    List<User> getAllUsers(Role role);

    List<Auto> getAllUserAutos(User user);

    List<Role> getAllUserRoles();

    Role getRole(int id);

    User getUser(int id);

    void updateAuto(Auto auto);

    User auth(String login, String password);
}

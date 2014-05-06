package ua.epam.rentproject.dao.user;

import java.util.List;
import ua.epam.rentproject.model.User;

/**
 * @author Dmytro_Svynarenko
 * @version 1.0
 * @created 05-май-2014 15:35:20
 */
public interface UserDAO {

    public List<User> getAllUsers();

    public User getUserById(int id);

    public int insertUser(User user);

    public void udpateUser(User user);

    public void deleteUser(User user);
}
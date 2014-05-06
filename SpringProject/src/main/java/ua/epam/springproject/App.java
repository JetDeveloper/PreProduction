package ua.epam.springproject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.epam.springproject.model.Role;
import ua.epam.springproject.model.User;
import ua.epam.springproject.repository.user.UserDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    
    protected static JdbcTemplate jdbcTemplate;
    
    public static void main( String[] args )
    {
        ApplicationContext appCtx = 
                new ClassPathXmlApplicationContext("persistenceContext.xml");
        
        UserDAO repository = appCtx.getBean("userRepository", UserDAO.class);
        jdbcTemplate = appCtx.getBean("jdbcTemplate", JdbcTemplate.class);
        List<User> users = repository.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        Role role = repository.getRole(1);
        Role dbRole = jdbcTemplate.queryForObject(
                "select role_id, role_name from role where role_id=?",new Object[]{1},
                 new RowMapper<Role>() {
                    @Override
                    public Role mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                        Role r = new Role();
                        r.setId(resultSet.getInt("role_id"));
                        r.setName(resultSet.getString("role_name"));
                        return r;
                    } 
                });
        System.out.println(role);
    }
}

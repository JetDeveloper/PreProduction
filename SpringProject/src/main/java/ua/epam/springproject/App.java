package ua.epam.springproject;


import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.epam.springproject.model.User;
import ua.epam.springproject.repository.user.UserDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    
    public static void main( String[] args )
    {
        ApplicationContext appCtx = 
                new ClassPathXmlApplicationContext("persistenceContext.xml");
        
        UserDAO repository = appCtx.getBean("userRepository", UserDAO.class);
        List<User> users = repository.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        User user = repository.getUser(1);
        System.out.println(user);
   
    }
}

package md.kniga.backendOnlineShop.test;


import md.kniga.backendOnlineShop.dao.UserDAO;
import md.kniga.backendOnlineShop.daoImpl.UserDAOImpl;
import md.kniga.backendOnlineShop.dto.User;
import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTestCase {

    private static AnnotationConfigApplicationContext context;

    private static UserDAO userDAO;

    private static User user;

    @BeforeClass
    public static void init(){

        context = new AnnotationConfigApplicationContext();
        context.scan("md.kniga.backendOnlineShop");
        userDAO = new UserDAOImpl();



    }
}

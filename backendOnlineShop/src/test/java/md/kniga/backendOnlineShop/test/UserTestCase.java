package md.kniga.backendOnlineShop.test;


import md.kniga.backendOnlineShop.dao.UserDAO;
import md.kniga.backendOnlineShop.dto.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class UserTestCase {

    private static AnnotationConfigApplicationContext context;

    private static UserDAO userDAO;

    private static User user;

    @BeforeClass
    public static void init(){

        context = new AnnotationConfigApplicationContext();
        context.scan("md.kniga.backendOnlineShop");
        context.refresh();
        userDAO = (UserDAO)context.getBean("userDAO");
    }

    @Test
    public void testAdd(){

        user = new User();
        user.setFirst_name("Michael");
        user.setLast_name("Vasiliev");
        user.setEmail("Michael@mail.com");
        user.setActive(true);
        user.setContact_number("56236599");
        user.setPassword("pass");
        user.setRole("user");

        assertEquals("Successfully added a category inside the database", true, userDAO.add(user));
    }

    @Test
    public void testGet(){

        user = userDAO.get(1);
        assertEquals("Successfully fetched a single category inside the database", "Mike", user.getFirst_name());
    }

    @Test
    public void testGetByEmail(){

        user = userDAO.getByEmail("Mike@email.com");
        assertEquals("Successfully fetched a single category inside the database", "Mike", user.getFirst_name());
    }

      @Test
      public void testUpdate(){

          user = userDAO.get(1);
          user.setActive(false);
         assertEquals("Successfully fetched a single category inside the database", true, userDAO.update(user));
    }

    @Test
    public void testDeactivate(){

        user = userDAO.get(1);
        assertEquals("Successfully deleted a single category", true, userDAO.deactivate(user));
    }

    @Test
    public void testDelete(){

        assertEquals("Successfully deleted a single category", true, userDAO.delete(3));
    }

    @Test
    public void testListAll(){

        assertEquals("Successfully fetched the listAll of users from database", 3, userDAO.listAll().size());
    }

    @Test
    public void testListActive(){

        assertEquals("Successfully fetched the listAll of users from database", 2, userDAO.listActive().size());
    }

}

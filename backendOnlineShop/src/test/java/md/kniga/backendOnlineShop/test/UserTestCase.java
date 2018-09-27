package md.kniga.backendOnlineShop.test;


import md.kniga.backendOnlineShop.dao.UserDAO;
import md.kniga.backendOnlineShop.dto.Address;
import md.kniga.backendOnlineShop.dto.Cart;
import md.kniga.backendOnlineShop.dto.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class UserTestCase {

    private static AnnotationConfigApplicationContext context;

    private static UserDAO userDAO;

    private User user = null;

    private Cart cart = null;

    private Address address = null;

    @BeforeClass
    public static void init(){

        context = new AnnotationConfigApplicationContext();
        context.scan("md.kniga.backendOnlineShop");
        context.refresh();
        userDAO = (UserDAO)context.getBean("userDAO");
    }

    @Test
    public void testAddUser(){

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
    public void testAddAddress(){

        user = new User();
        user.setFirst_name("Mich");
        user.setLast_name("Siliev");
        user.setEmail("Mmmmmmichael@gggggggmail.com");
        user.setActive(true);
        user.setContact_number("56236599");
        user.setPassword("pass");
        user.setRole("admin");

        address = new Address();
        address.setAdressLineOne("12 Karl");
        address.setAdressLineTwo("apt 13");
        address.setCountry("Moldova");
        address.setPostalCode("MD-3300");
        address.setShippingAdress(true);
        address.setSity("Tiraspol");
        address.setState("Tiraspol");
        address.setUserId(user.getId());

        assertEquals("Successfully added an address inside the database", true, userDAO.addAddress(address));
    }

    @Test
    public void testAddCart(){

        user = new User();
        user.setFirst_name("Ichael");
        user.setLast_name("Valiev");
        user.setEmail("ichael@gggggggmail.com");
        user.setActive(true);
        user.setContact_number("56236599");
        user.setPassword("pass");
        user.setRole("user");

        userDAO.add(user);

        cart = new Cart();
        cart.setCartLines(0);
        cart.setGrandTotal(0);
        cart.setUser(user);

        assertEquals("Successfully added a cart inside the database", true, userDAO.updateCart(cart));
    }

    @Test
    public void testGet(){

        user = userDAO.get(1);
        assertEquals("Successfully fetched a single category inside the database", "Mike", user.getFirst_name());
    }

    @Test
    public void testGetByEmail(){

        user = userDAO.getByEmail("ichael@gggggggmail.com");

        cart = new Cart();
        cart.setGrandTotal(526);
        cart.setCartLines(2);
        user.setCart(cart);


        //assertEquals("Successfully fetched a single category inside the database", 526, userDAO.);
        //userDAO.updateCart(cart);
        assertEquals("Successfully fetched a single category inside the database", true, userDAO.updateCart(cart));
//        user = new User();
//        user.setFirst_name("Mike");
//        user.setLast_name("Valiev");
//        user.setEmail("ichael@gggggggmail.com");
//        user.setActive(true);
//        user.setContact_number("56236599");
//        user.setPassword("pass");
//        user.setRole("user");
//
//        userDAO.add(user);
//
//
//        cart = new Cart();
//        cart.setCartLines(0);
//        cart.setGrandTotal(0);
//        cart.setUser(user);
//
//        userDAO.updateCart(cart);
//
//        //user = userDAO.getByEmail("ichael@gggggggmail.com");
//        assertEquals("Successfully fetched a single category inside the database", "Mike", user.getFirst_name());
//       // assertEquals("Successfully fetched a single category inside the database", "ichael@gggggggmail.com", user.getCart().getUser().getEmail());
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

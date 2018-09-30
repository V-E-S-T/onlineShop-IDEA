package md.kniga.backendOnlineShop.test;


import md.kniga.backendOnlineShop.dao.UserDAO;
import md.kniga.backendOnlineShop.dto.Address;
import md.kniga.backendOnlineShop.dto.Cart;
import md.kniga.backendOnlineShop.dto.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

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
        user.setFirst_name("Mich");
        user.setLast_name("Siliev");
        user.setEmail("Mmmmmmichael@gggggggmail.com");
        user.setActive(true);
        user.setContact_number("56236599");
        user.setPassword("pass");
        user.setRole("admin");

        cart = new Cart();
        cart.setUser(user);

        user.setCart(cart);

        assertEquals("Successfully added an address inside the database", true, userDAO.add(user));
    }

    @Test
    public void testUpdateCart(){

        user = userDAO.getByEmail("Mmmmmmichael@gggggggmail.com");

        cart = user.getCart();

        cart.setGrandTotal(555);
        cart.setCartLines(2);

        assertEquals("Successfully added a cart inside the database", true, userDAO.updateCart(cart));
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

        assertEquals("Successfully added an address inside the database", true, userDAO.add(user));

        address = new Address();
        address.setAddressLineOne("12 Karl");
        address.setAddressLineTwo("apt 13");
        address.setCountry("Moldova");
        address.setPostalCode("MD-3300");
        address.setBillingAddress(true);
        address.setCity("Tiraspol");
        address.setState("Tiraspol");

        address.setUserId(user.getId());
        assertEquals("Successfully added an address inside the database", true, userDAO.addAddress(address));

        address = new Address();
        address.setAddressLineOne("22 Karl");
        address.setAddressLineTwo("apt 23");
        address.setCountry("Moldova");
        address.setPostalCode("MD-3300");
        address.setBillingAddress(false);
        address.setCity("Tiraspol");

        address.setUserId(user.getId());
        assertEquals("Successfully added an address inside the database", true, userDAO.addAddress(address));

        address = new Address();
        address.setAddressLineOne("32 Karl");
        address.setAddressLineTwo("apt 33");
        address.setCountry("Moldova");
        address.setPostalCode("MD-3300");
        address.setBillingAddress(false);
        address.setCity("Tiraspol");
        address.setState("Tiraspol");

        address.setUserId(user.getId());
        assertEquals("Successfully added an address inside the database", true, userDAO.addAddress(address));

        //HibernateConfig properties.put("hibernate.hbm2ddl.auto", "create");

    }

    @Test
    public void testGetShippingAddresses(){

        user = userDAO.getByEmail("Mmmmmmichael@gggggggmail.com");

        List<Address> listAddresses = userDAO.listShippingAddresses(user);

        assertEquals("Successfully fetched a single category inside the database", 2, listAddresses.size());

        //HibernateConfig properties.put("hibernate.hbm2ddl.auto", "update");
    }

    @Test
    public void testGetBillingAddress(){

        user = userDAO.getByEmail("Mmmmmmichael@gggggggmail.com");

        address = userDAO.getBillingAddress(user);

        assertEquals("Successfully fetched a single category inside the database", "12 Karl", address.getAddressLineOne());

        //HibernateConfig properties.put("hibernate.hbm2ddl.auto", "update");
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

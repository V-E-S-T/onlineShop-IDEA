package md.kniga.backendOnlineShop.test;

import md.kniga.backendOnlineShop.dao.CartLineDAO;
import md.kniga.backendOnlineShop.dao.ProductDAO;
import md.kniga.backendOnlineShop.dao.UserDAO;
import md.kniga.backendOnlineShop.dto.Cart;
import md.kniga.backendOnlineShop.dto.CartLine;
import md.kniga.backendOnlineShop.dto.Product;
import md.kniga.backendOnlineShop.dto.User;
import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CartLineTestCase {

    private static AnnotationConfigApplicationContext context;

    private static CartLineDAO cartLineDAO = null;
    private static UserDAO userDAO = null;
    private static ProductDAO productDAO = null;

    private Product product;
    private User user;
    private Cart cart;
    private CartLine cartLine;

    @BeforeClass
    public static void init(){

        context = new AnnotationConfigApplicationContext();
        context.scan("md.kniga.backendOnlineShop");
        context.refresh();
        cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
        productDAO = (ProductDAO)context.getBean("productDAO");
        userDAO = (UserDAO)context.getBean("userDAO");
    }


}

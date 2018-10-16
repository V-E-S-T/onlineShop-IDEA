package md.kniga.backendOnlineShop.test;

import md.kniga.backendOnlineShop.dao.CartLineDAO;
import md.kniga.backendOnlineShop.dao.ProductDAO;
import md.kniga.backendOnlineShop.dao.UserDAO;
import md.kniga.backendOnlineShop.dto.Cart;
import md.kniga.backendOnlineShop.dto.CartLine;
import md.kniga.backendOnlineShop.dto.Product;
import md.kniga.backendOnlineShop.dto.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void testAddNewCartLine(){

        user = userDAO.getByEmail("sgolon@ro.ru");
        cart = user.getCart();
        product = productDAO.get(2);
        cartLine = new CartLine();
        cartLine.setCartId(cart.getId());
        cartLine.setProduct(product);
        cartLine.setProductCount(1);

        double oldTotal = cartLine.getTotal();

        cartLine.setTotal(product.getUnitPrice() * cartLine.getProductCount());

        cart.setCartLines(cart.getCartLines() + 1);
        cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));


        assertEquals("CartLine Successfully added", true, cartLineDAO.add(cartLine));

        //update the cart

//        cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
//        cart.setCartLines(cart.getCartLines() + 1);

        assertEquals("CartLine Successfully updated", true, cartLineDAO.update(cartLine));
    }




}

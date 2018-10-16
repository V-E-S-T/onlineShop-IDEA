package md.kniga.onlineShop.services;

import md.kniga.backendOnlineShop.dao.CartLineDAO;
import md.kniga.backendOnlineShop.dao.ProductDAO;
import md.kniga.backendOnlineShop.dto.Cart;
import md.kniga.backendOnlineShop.dto.CartLine;
import md.kniga.backendOnlineShop.dto.User;
import md.kniga.onlineShop.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("cartService")
public class CartService{

    @Autowired
    private CartLineDAO cartLineDAO;

    @Autowired
    private HttpSession session;

    @Autowired
    private ProductDAO productDAO;

    private Cart getCart(){

        UserModel userModel = (UserModel)session.getAttribute("userModel");
        Cart cart = userModel.getCart();

        return cart;
    }

    public List<CartLine> getCartLines(){

        Cart cart = this.getCart();

        return cartLineDAO.list(cart.getId());
    }

}

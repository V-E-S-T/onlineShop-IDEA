package md.kniga.onlineShop.services;

import md.kniga.backendOnlineShop.dao.CartLineDAO;
import md.kniga.backendOnlineShop.dao.ProductDAO;
import md.kniga.backendOnlineShop.daoImpl.CartLineDAOImpl;
import md.kniga.backendOnlineShop.dto.Cart;
import md.kniga.backendOnlineShop.dto.CartLine;
import md.kniga.onlineShop.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("cartService")
public class CartService {

    @Autowired
    private CartLineDAO cartLineDAO;

    @Autowired
    private HttpSession session;

    @Autowired
    private ProductDAO productDAO;

    private Cart getCart(){

        return ((UserModel)session.getAttribute("userModel")).getCart();
    }

    public List<CartLine> getCartLines(){

        Cart cart = this.getCart();

        return cartLineDAO.list(cart.getId());
    }




}

package md.kniga.onlineShop.services;

import md.kniga.backendOnlineShop.dao.CartLineDAO;
import md.kniga.backendOnlineShop.dao.ProductDAO;
import md.kniga.backendOnlineShop.dto.Cart;
import md.kniga.backendOnlineShop.dto.CartLine;
import md.kniga.backendOnlineShop.dto.Product;
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

    //TODO this method should be in the DAO layer
    private Cart getCart(){

        UserModel userModel = (UserModel)session.getAttribute("userModel");
        Cart cart = userModel.getCart();

        return cart;
    }

    public List<CartLine> getCartLines(){

        Cart cart = this.getCart();

        return cartLineDAO.list(cart.getId());
    }

    public String updateCartLine(int cartLineId, int count){

        CartLine cartLine = cartLineDAO.get(cartLineId);
        double oldTotal = cartLine.getTotal();

        if(cartLine == null)
            return "result=error";

        cartLine.setProductCount(count);
        cartLine.setTotal(cartLine.getBuyingPrice() * count);
        cartLineDAO.update(cartLine);
        Cart cart = getCart();
        cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
        cartLineDAO.updateCart(cart);

        return "result=updated";
    }

    public String deleteCartLine(int cartLineId){

        CartLine cartLine = cartLineDAO.get(cartLineId);

        if(cartLine == null)
            return "result=error";
        else {
            Cart cart = this.getCart();
            cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
            cart.setCartLines(cart.getCartLines() - 1);
            cartLineDAO.updateCart(cart);
            cartLineDAO.delete(cartLine);
            return "result=deleted";
        }
    }

    public String addCartLine(int productId){

        String result = "";

        Cart cart = this.getCart();
        CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);
        Product product = productDAO.get(productId);

        if(cartLine == null){
            cartLine = new CartLine();
            cartLine.setCartId(cart.getId());
            cartLine.setProduct(product);
            cartLine.setTotal(product.getUnitPrice());
            cartLine.setProductCount(1);
            cartLine.setAvailable(product.isActive());
            cart.setCartLines(cart.getCartLines() + 1);
            cartLineDAO.add(cartLine);
        }
        else{
            if(cartLine.getProductCount() >= 3){
                return "result=maximum";
            }
            cartLine.setProductCount(cartLine.getProductCount() + 1);
            cartLine.setTotal(cartLine.getTotal() + product.getUnitPrice());
        }

        cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
        cartLineDAO.updateCart(cart);
        result = "result=added";

        return result;
    }

}

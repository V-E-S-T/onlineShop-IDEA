package md.kniga.backendOnlineShop.dao;

import md.kniga.backendOnlineShop.dto.Cart;
import md.kniga.backendOnlineShop.dto.CartLine;

import java.util.List;

public interface CartLineDAO {

    List<CartLine> list(int cartId);

    CartLine get(int id);

    boolean add(CartLine cartLine);

    boolean delete(CartLine cartLine);

    boolean update(CartLine cartLine);

    CartLine getByCartAndProduct(int cartId, int productId);

    List<CartLine> listAvailable(int cartId);

    boolean updateCart(Cart cart);

}

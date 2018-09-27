package md.kniga.backendOnlineShop.dao;
import md.kniga.backendOnlineShop.dto.Address;
import md.kniga.backendOnlineShop.dto.Cart;
import md.kniga.backendOnlineShop.dto.User;

import java.util.List;

public interface UserDAO {

    List<User> listAll();

    List<User> listActive();

    boolean update(User user);

    boolean deactivate(User user);

    boolean delete(int userId);

    User getByEmail(String email);

    User get(int id);

    boolean add(User user);

    boolean addAddress(Address address);

    boolean addCart(Cart cart);
}

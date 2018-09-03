package md.kniga.backendOnlineShop.dao;
import md.kniga.backendOnlineShop.dto.User;

import java.util.List;

public interface UserDAO {

    List<User> list();

    boolean update(User user);

    boolean deactivate(User user);

    boolean delete(int userId);

    User getByEmail(String email);

    User get(int id);

    boolean add(User user);
}

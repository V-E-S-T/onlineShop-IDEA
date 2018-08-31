package md.kniga.backendOnlineShop.dao;

import md.kniga.backendOnlineShop.dto.Category;

import java.util.List;

public interface CategoryDAO {

    boolean add(Category category);

    List list();

    Category get(int id);

    boolean update(Category category);

    boolean deactivate(Category category);

    boolean delete(int categoryId);
}

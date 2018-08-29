package md.kniga.backendOnlineShop.dao;

import md.kniga.backendOnlineShop.dto.Category;

import java.util.List;

public interface CategoryDAO {

    boolean add(Category category);

    List<Category> list();

    Category get(int id);

    boolean update(Category category);

    boolean delete(Category category);
}

package md.kniga.backendOnlineShop.dao;

import md.kniga.backendOnlineShop.dto.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> list();

    boolean update(Product product);

    boolean deactivate(Product product);

    boolean delete(int productId);

    Product get(int id);

    boolean add(Product product);

    List<Product> listActiveProducts();

    List<Product> listActiveProductsByCategory(int categoryId);

    List<Product> getLatestActiveProducts(int count);
}

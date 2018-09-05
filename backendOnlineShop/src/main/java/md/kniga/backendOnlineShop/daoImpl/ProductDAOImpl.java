package md.kniga.backendOnlineShop.daoImpl;

import md.kniga.backendOnlineShop.dao.ProductDAO;
import md.kniga.backendOnlineShop.dto.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> list() {
        return null;
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

    @Override
    public boolean deactivate(Product product) {
        return false;
    }

    @Override
    public boolean delete(int productId) {
        return false;
    }

    @Override
    public Product get(int id) {
        return null;
    }

    @Override
    public boolean add(Product product) {
        return false;
    }

    //business methods

    @Override
    public List<Product> listActiveProducts() {
        return null;
    }

    @Override
    public List<Product> listActiveProductsByCategory(int categoryId) {
        return null;
    }

    @Override
    public List<Product> getLatestActiveProducts(int count) {
        return null;
    }
}

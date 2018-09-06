package md.kniga.backendOnlineShop.daoImpl;

import md.kniga.backendOnlineShop.dao.ProductDAO;
import md.kniga.backendOnlineShop.dto.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    public List<Product> listAll() {

        Query<Product> query = sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class);

        return query.getResultList();
    }

    @Override
    public boolean update(Product product) {

        try{
            sessionFactory.getCurrentSession().update(product);
            return true;
        }
        catch (Exception e){

            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deactivate(Product product) {

        product.setActive(false);
        return update(product);
    }

    @Override
    public boolean delete(int productId) {

        Query query = sessionFactory.getCurrentSession().createQuery("DELETE FROM Product WHERE id=:productId");
        return query.setParameter("productId", productId).executeUpdate() != 0;
    }

    @Override
    public Product get(int id) {

        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Override
    public boolean add(Product product) {

        try{
            sessionFactory.getCurrentSession().persist(product);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    //business methods

    @Override
    public List<Product> listActiveProducts() {

        Query< Product> query = sessionFactory.getCurrentSession().createQuery("FROM Product WHERE active=:active", Product.class);
        query.setParameter("active", true);

        return query.getResultList();
    }

    @Override
    public List<Product> listActiveProductsByCategory(int categoryId) {

        Query< Product> query = sessionFactory.getCurrentSession().createQuery("FROM Product WHERE active=:active AND category_id=:categoryId", Product.class);
        query.setParameter("active", true);
        query.setParameter("categoryId", categoryId);

        return query.getResultList();
    }

    @Override
    public List<Product> getLatestActiveProducts(int count) {

        Query< Product> query = sessionFactory.getCurrentSession().createQuery("FROM Product WHERE active=:active", Product.class);
        query.setParameter("active", true);

        //TODO business logic is not true!!!

        return query.getResultList();
    }
}

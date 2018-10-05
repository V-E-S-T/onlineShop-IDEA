package md.kniga.backendOnlineShop.daoImpl;

import md.kniga.backendOnlineShop.dao.CartLineDAO;
import md.kniga.backendOnlineShop.dto.Cart;
import md.kniga.backendOnlineShop.dto.CartLine;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartLineDAOImpl implements CartLineDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<CartLine> list(int cartId) {

        Query<CartLine> query = sessionFactory.getCurrentSession().createQuery("FROM Cartline WHERE cartId=:cartId", CartLine.class);
        query.setParameter("cartId", cartId);
        return query.getResultList();
    }

    @Override
    public CartLine get(int id) {

        Query<CartLine> query = sessionFactory.getCurrentSession().createQuery("FROM Cartline WHERE id=:id", CartLine.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public boolean add(CartLine cartLine) {

        try{
            sessionFactory.getCurrentSession().persist(cartLine);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(CartLine cartLine) {

        try{
            sessionFactory.getCurrentSession().delete(cartLine);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(CartLine cartLine) {

        try{
            sessionFactory.getCurrentSession().update(cartLine);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public CartLine getByCartAndProduct(int cartId, int productId) {

        try{

            Query<CartLine> query = sessionFactory.getCurrentSession().createQuery("FROM Cartline WHERE cartId=:cartId AND product.id=:productId", CartLine.class);
            query.setParameter("cartId", cartId);
            query.setParameter("productId", productId);
            return query.getSingleResult();
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public List<CartLine> listAvailable(int cartId) {

        Query<CartLine> query = sessionFactory.getCurrentSession().createQuery("FROM Cartline WHERE cartId=:cartId AND available=:available", CartLine.class);
        query.setParameter("cartId", cartId);
        query.setParameter("available", true);
        return query.getResultList();
    }

    @Override
    public boolean updateCart(Cart cart) {

        try{
            sessionFactory.getCurrentSession().update(cart);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}

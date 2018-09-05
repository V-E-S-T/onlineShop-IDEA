package md.kniga.backendOnlineShop.daoImpl;

import md.kniga.backendOnlineShop.dao.UserDAO;
import md.kniga.backendOnlineShop.dto.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> list() {

        Query<User> query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE active=:active", User.class);
        query.setParameter("active", true);

        return query.getResultList();
    }

    @Override
    public boolean update(User user) {

        try{
            sessionFactory.getCurrentSession().update(user);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deactivate(User user) {
        user.setActive(false);
        return update(user);
    }

    @Override
    public boolean delete(int userId) {

        Query query = sessionFactory.getCurrentSession().createQuery("DELETE FROM User WHERE id=:userId");
        return query.setParameter("userId", userId).executeUpdate() != 0;
    }

    @Override
    public User getByEmail(String email) {

        Query<User> query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE email=:email", User.class);
        query.setParameter("email", email).executeUpdate();
        return query.getSingleResult();
    }

    @Override
    public User get(int id) {

        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public boolean add(User user) {

        try{
            //add the category to the database
            sessionFactory.getCurrentSession().persist(user);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

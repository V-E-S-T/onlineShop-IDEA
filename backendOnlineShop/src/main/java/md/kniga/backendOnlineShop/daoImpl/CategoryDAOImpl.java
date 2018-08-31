package md.kniga.backendOnlineShop.daoImpl;

import md.kniga.backendOnlineShop.dao.CategoryDAO;
import md.kniga.backendOnlineShop.dto.Category;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private static List<Category> categories = new ArrayList<>();

    @Override
    public boolean add(Category category) {

        try{
            //add the category to the database
            sessionFactory.getCurrentSession().persist(category);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Category> list() {

        Query<Category> query = sessionFactory.getCurrentSession().createQuery("FROM Category WHERE active=:active", Category.class);
        query.setParameter("active", true);

        //TODO make method implementation
        return query.getResultList();
    }

    //getting single category
    @Override
    public Category get(int id) {

//        Optional<Category> optional = categories.stream().filter(category -> category.getId() == id).findFirst();
//        if (optional.isPresent())
//            return optional.get();
//        else
            //TODO make null handling
            return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
    }

    //updating a single category
    @Override
    public boolean update(Category category) {

        try{
            //update the category to the database
            sessionFactory.getCurrentSession().update(category);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //deactivate the category to the database
    @Override
    public boolean deactivate(Category category) {
        category.setActive(false);
        return update(category);
    }

    @Override
    public boolean delete(int categoryId) {

        Query query = sessionFactory.getCurrentSession().createQuery("DELETE FROM Category WHERE id=:categoryId");
        return query.setParameter("categoryId", categoryId).executeUpdate() != 0;
    }
}

package md.kniga.backendOnlineShop.daoImpl;

import md.kniga.backendOnlineShop.dao.CategoryDAO;
import md.kniga.backendOnlineShop.dto.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        //TODO make method implementation
        return null;
    }

    //getting single category
    @Override
    public Category get(int id) {

//        Optional<Category> optional = categories.stream().filter(category -> category.getId() == id).findFirst();
//        if (optional.isPresent())
//            return optional.get();
//        else
            //TODO make method implementation
            return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
    }

    //updating a single category
    @Override
    public boolean update(Category category) {

        try{
            //add the category to the database
            sessionFactory.getCurrentSession().update(category);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Category category) {
        return false;
    }
}

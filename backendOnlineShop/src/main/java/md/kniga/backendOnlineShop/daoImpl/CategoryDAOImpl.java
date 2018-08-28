package md.kniga.backendOnlineShop.daoImpl;

import md.kniga.backendOnlineShop.dao.CategoryDAO;
import md.kniga.backendOnlineShop.dto.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{

    private static List<Category> categories = new ArrayList<>();

    static {

        //first category
        Category category = new Category();
        category.setId(1);
        category.setName("Television");
        category.setDescription("Television some category");
        category.setImageURL("CAT_1.png");

        categories.add(category);

        //second category
        category = new Category();
        category.setId(2);
        category.setName("Mobile");
        category.setDescription("Mobile some category");
        category.setImageURL("CAT_2.png");

        categories.add(category);

        //third category
        category = new Category();
        category.setId(3);
        category.setName("Laptop");
        category.setDescription("Laptop some category");
        category.setImageURL("CAT_3.png");

        categories.add(category);

    }

    @Override
    public List<Category> list() {
        return null;
    }
}

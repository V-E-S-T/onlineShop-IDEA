package md.kniga.backendOnlineShop.daoImpl;

import md.kniga.backendOnlineShop.dao.CategoryDAO;
import md.kniga.backendOnlineShop.dto.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

    private static List<Category> categories = new ArrayList<>();

    static{
        Category category = new Category();
        category.setId(1);
        category.setName("Television");
        category.setActive(true);
        category.setDescription("Television category");
        category.setImgeUrl("CAT_1");

        categories.add(category);

        category = new Category();
        category.setId(2);
        category.setName("Mobile");
        category.setActive(true);
        category.setDescription("Mobile category");
        category.setImgeUrl("CAT_2");

        categories.add(category);

        category = new Category();
        category.setId(3);
        category.setName("Laptop");
        category.setActive(true);
        category.setDescription("Laptop category");
        category.setImgeUrl("CAT_3");

        categories.add(category);
    }

    @Override
    public List<Category> list() {

        return categories;
    }

    @Override
    public Category get(int id) {

        Optional<Category> optional = categories.stream().filter(category -> category.getId() == id).findFirst();
        if (optional.isPresent())
            return optional.get();
        else
            //TODO make handling for null case
            return null;
    }
}

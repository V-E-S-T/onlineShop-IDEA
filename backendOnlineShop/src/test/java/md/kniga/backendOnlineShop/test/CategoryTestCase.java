package md.kniga.backendOnlineShop.test;

import md.kniga.backendOnlineShop.dao.CategoryDAO;
import md.kniga.backendOnlineShop.dto.Category;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class CategoryTestCase {

    private static AnnotationConfigApplicationContext context;

    private static CategoryDAO categoryDAO;

    private static Category category;

    @BeforeClass
    public static void init(){

        context = new AnnotationConfigApplicationContext();

        context.scan("md.kniga.backendOnlineShop");
        context.refresh();
        categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
    }

//    @Test
//    public void testAddCategory(){
//
//        category = new Category();
//        category.setName("Television");
//        category.setDescription("Television description");
//        category.setImgeUrl("CAT_1.png");
//
//        assertEquals("Successfully added a category inside the database", true, categoryDAO.add(category));
//    }

//    @Test
//    public void testGetCategory(){
//        category = categoryDAO.get(3);
//
//        assertEquals("Successfully fetched a single category inside the database", "Television", category.getName());
//    }

      @Test
      public void testUpdateCategory(){
         category = categoryDAO.get(3);
          category.setName("Tv");

         assertEquals("Successfully fetched a single category inside the database", "Tv", category.getName());
    }
}

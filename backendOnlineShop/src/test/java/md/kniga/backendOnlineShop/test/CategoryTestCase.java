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

//      @Test
//      public void testUpdateCategory(){
//         category = categoryDAO.get(4);
//          category.setName("Tv");
//
//         assertEquals("Successfully fetched a single category inside the database", true, categoryDAO.update(category));
//    }

//    @Test
//    public void testDeactivateCategory(){
//        category = categoryDAO.get(1);
//        //category.setActive(false);
//
//        assertEquals("Successfully deleted a single category", true, categoryDAO.deactivate(category));
//    }

//    @Test
//    public void testDeleteCategory(){
//        category = categoryDAO.get(1);
//        //category.setActive(false);
//
//        assertEquals("Successfully deleted a single category", true, categoryDAO.delete(8));
//    }

//    @Test
//    public void testListCategory(){
//        //category = categoryDAO.get(1);
//        //category.setActive(false);
//
//        assertEquals("Successfully fetched the list of categories from database", 4, categoryDAO.list());
//    }

    @Test
    public void testCRUDCategory(){

        //add test
        category = new Category();
        category.setName("Book");
        category.setDescription("Book description");
        category.setImgeUrl("CAT_1.png");
        assertEquals("Successfully added a category inside the database", true, categoryDAO.add(category));

        //get test
        category = categoryDAO.get(3);//
        assertEquals("Successfully fetched a single category inside the database", "Television", category.getName());

        //update test
         category = categoryDAO.get(1);
         category.setName("Mobile");
         assertEquals("Successfully fetched a single category inside the database", true, categoryDAO.update(category));

        //deactivate test
        category = categoryDAO.get(1);
        assertEquals("Successfully deleted a single category", true, categoryDAO.deactivate(category));

        //delete test
        assertEquals("Successfully deleted a single category", true, categoryDAO.delete(1));

        //list test
        assertEquals("Successfully fetched the list of categories from database", 6, categoryDAO.list().size());

    }



}

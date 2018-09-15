package md.kniga.backendOnlineShop.daoImpl;

import md.kniga.backendOnlineShop.dao.ProductDAO;
import md.kniga.backendOnlineShop.dto.Product;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class ProductDAOImplTest {

    private static AnnotationConfigApplicationContext context;

    private static Product product;

    private static ProductDAO productDAO;


    @Before
    public void init() throws Exception {

        context = new AnnotationConfigApplicationContext();
        context.scan("md.kniga.backendOnlineShop");
        context.refresh();

        productDAO = (ProductDAO)context.getBean("productDAO");
    }

    @Test
    public void listAll() throws Exception {

        assertEquals("Successfully fetched the listAll of categories from database", 4, productDAO.listAll().size());

    }

    @Test
    public void update() throws Exception {

        product = productDAO.get(3);
        product.setDescription("Some interesting Book");
        assertEquals("Successfully fetched the listAll of categories from database", true, productDAO.update(product));
    }

    @Test
    public void deactivate() throws Exception {

        product = productDAO.get(3);

        assertEquals("Successfully fetched the listAll of categories from database", true, productDAO.deactivate(product));
    }

    @Test
    public void delete() throws Exception {

        assertEquals("Successfully fetched the listAll of categories from database", true, productDAO.delete(1));
    }

    @Test
    public void get() throws Exception {

        assertEquals("Successfully fetched the listAll of categories from database", "Some interesting Book", productDAO.get(3).getDescription());
    }

    @Test
    public void add() throws Exception {

        product = new Product();
        product.setDescription("Some Book");
        product.setBrand("Piter");
        product.setImageUrl("IMAGE_URL_1.png");
        product.setName("Book about anything");
        product.setSize("25x25x4mm");
        product.setUnitPrice("600");
        product.setWeight("300g");
        product.setActive(true);
        product.setActive(true);

        assertEquals("Successfully fetched the listAll of categories from database", true, productDAO.add(product));

    }

    @Test
    public void listActiveProducts() throws Exception {

        assertEquals("Successfully fetched the listActiveProducts of categories from database", 4, productDAO.listActiveProducts().size());
    }

    @Test
    public void listActiveProductsByCategory() throws Exception {

        assertEquals("Successfully fetched the listActiveProductsByCategory of categories from database", 2, productDAO.listActiveProductsByCategory(3).size());
    }

    @Test
    public void getLatestActiveProducts() throws Exception {

        assertEquals("Successfully fetched the listLatestActiveProducts of categories from database", 3, productDAO.getLatestActiveProducts(3).size());
    }

}
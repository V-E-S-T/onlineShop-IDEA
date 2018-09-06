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
        context.scan("md.kniga.backendOnlineShop.dto");
        context.refresh();

        productDAO = (ProductDAO)context.getBean("productDAO");
    }

    @Test
    public void listAll() throws Exception {


    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void deactivate() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void listActiveProducts() throws Exception {
    }

    @Test
    public void listActiveProductsByCategory() throws Exception {
    }

    @Test
    public void getLatestActiveProducts() throws Exception {
    }

}
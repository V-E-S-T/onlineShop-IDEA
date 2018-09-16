package md.kniga.onlineShop.controller;

import md.kniga.backendOnlineShop.dao.ProductDAO;
import md.kniga.backendOnlineShop.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/json/data")
public class JsonDataController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping("/all/products")
    public List<Product> getAllProduct(){

        return productDAO.listActiveProducts();
    }

    @RequestMapping("/category/{id}/products")
    public List<Product> getAllProductsByCategory(@PathVariable int id){

        return productDAO.listActiveProductsByCategory(id);
    }

}

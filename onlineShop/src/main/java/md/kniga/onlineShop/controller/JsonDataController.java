package md.kniga.onlineShop.controller;

import md.kniga.backendOnlineShop.dao.ProductDAO;
import md.kniga.backendOnlineShop.dao.UserDAO;
import md.kniga.backendOnlineShop.dto.Address;
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

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/all/products")
    public List<Product> getAllProduct(){

        return productDAO.listActiveProducts();
    }

    @RequestMapping("/admin/all/products")
    public List<Product> getAdminAllProduct(){

        return productDAO.listAll();
    }

    @RequestMapping("/category/{id}/products")
    public List<Product> getAllProductsByCategory(@PathVariable int id){

        return productDAO.listActiveProductsByCategory(id);
    }

    @RequestMapping("/user/details")
    public List<Address> getAllUserAddress(@PathVariable int id){

        return userDAO.listAddresses(userDAO.get(id));
    }

}

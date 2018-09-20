package md.kniga.onlineShop.controller;

import md.kniga.backendOnlineShop.dao.CategoryDAO;
import md.kniga.backendOnlineShop.dto.Category;
import md.kniga.backendOnlineShop.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    private CategoryDAO categoryDAO;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView showManageProducts(){

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickManageProduct", true);
        mv.addObject("title", "Manage Products");
        Product newProduct = new Product();
        newProduct.setActive(true);
        mv.addObject("newProduct", newProduct);
        return mv;
    }

    @ModelAttribute("categories")
    public List<Category> getCategories(){

        return categoryDAO.listActive();
    }

}

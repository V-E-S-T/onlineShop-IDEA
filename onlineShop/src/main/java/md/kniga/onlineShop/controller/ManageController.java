package md.kniga.onlineShop.controller;

import md.kniga.backendOnlineShop.dao.CategoryDAO;
import md.kniga.backendOnlineShop.dao.ProductDAO;
import md.kniga.backendOnlineShop.dto.Category;
import md.kniga.backendOnlineShop.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;



//TODO add @Valid annotation for making validation

@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private ProductDAO productDAO;

    private static final Logger logger = LoggerFactory.getLogger(ManageController.class);

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView showManageProducts(@RequestParam(name="operation", required = false) String operation){

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickManageProduct", true);
        mv.addObject("title", "Manage Products");
        Product newProduct = new Product();
        newProduct.setActive(true);
        mv.addObject("newProduct", newProduct);

        if (operation!=null){
            if(operation.equals("product")){
                mv.addObject("message", "Product Submitted successfully!");
            }
        }

        return mv;
    }

    //handling product submission
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String handleProductSubmission(@ModelAttribute("product") Product modifiedProduct){

        logger.info(modifiedProduct.toString());

        productDAO.add(modifiedProduct);

        return "redirect:/manage/products?operation=product";
    }

    @ModelAttribute("categories")
    public List<Category> getCategories(){

        return categoryDAO.listActive();
    }

}

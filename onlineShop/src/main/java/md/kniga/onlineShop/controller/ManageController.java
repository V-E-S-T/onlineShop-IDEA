package md.kniga.onlineShop.controller;

import md.kniga.backendOnlineShop.dao.CategoryDAO;
import md.kniga.backendOnlineShop.dao.ProductDAO;
import md.kniga.backendOnlineShop.dto.Category;
import md.kniga.backendOnlineShop.dto.Product;
import md.kniga.onlineShop.util.FileUploadUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import validator.ProductValidator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

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
                mv.addObject("successMessage", "Product Submitted successfully!");
            }
        }

        return mv;
    }

    //handling product submission
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String handleProductSubmission(@Valid @ModelAttribute("newProduct") Product modifiedProduct, BindingResult bindingResult, Model model,
                                          HttpServletRequest request){

        if(modifiedProduct.getId() == 0){
            new ProductValidator().validate(modifiedProduct, bindingResult);
        }
        else {
            if(modifiedProduct.getFile().getOriginalFilename().equals("")){
                new ProductValidator().validate(modifiedProduct, bindingResult);
            }
        }


        //check if there are any errors

        if(bindingResult.hasErrors()){
            model.addAttribute("userClickManageProduct",true);
            model.addAttribute("title", "Manage Products");
            model.addAttribute("failedMessage", "Validation failed for product Submission!");

            return "page";
        }

        logger.info(modifiedProduct.toString());

        if(modifiedProduct.getId() == 0){
            productDAO.add(modifiedProduct);
        }
        else{
            productDAO.update(modifiedProduct);
        }


        if(!modifiedProduct.getFile().getOriginalFilename().equals("")){
            FileUploadUtility.uploadFile(request, modifiedProduct.getFile(), modifiedProduct.getCode());
        }

        return "redirect:/manage/products?operation=product";
    }

    //handling product submission
    @RequestMapping(value = "/products/{id}/activation", method = RequestMethod.GET)
    public String handleProductActivation(@PathVariable int id){

        //fetching the product from the database
        Product product = productDAO.get(id);

        boolean activityStatus = product.isActive();

        product.setActive(!activityStatus);

        productDAO.update(product);

        return activityStatus ? "You have successfully deactivate product with id: " + id :
                                "You have successfully activate product with id: " + id;
    }

    //handling product updating form
    @RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
    public ModelAndView showEditProduct(@PathVariable int id){

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickManageProduct", true);
        mv.addObject("title", "Manage Products");
        Product updateProduct = productDAO.get(id);
        mv.addObject("newProduct", updateProduct);
        return mv;
    }

    @ModelAttribute("categories")
    public List<Category> getCategories(){

        return categoryDAO.listActive();
    }

}

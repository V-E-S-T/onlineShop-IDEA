package md.kniga.onlineShop.controller;

import md.kniga.backendOnlineShop.dto.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManageController {

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

}

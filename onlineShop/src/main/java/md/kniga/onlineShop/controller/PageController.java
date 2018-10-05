package md.kniga.onlineShop.controller;

import md.kniga.backendOnlineShop.dao.CategoryDAO;
import md.kniga.backendOnlineShop.dao.ProductDAO;
import md.kniga.backendOnlineShop.dto.Category;
import md.kniga.backendOnlineShop.dto.Product;
import md.kniga.onlineShop.exception.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PageController {

    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = {"/", "home", "index"})
    public ModelAndView index()
    {
        ModelAndView mv = new ModelAndView("page");    // "page" is a logical name, so to resolve a physical page name we need to use
                                                                 // viewResolver (bean viewResolver in dispatcher-servlet.xml)
        logger.info("Inside PageController method index() - INFO");
        logger.debug("Inside PageController method index() - DEBUG");

        mv.addObject("title", "Home");
        mv.addObject("categories", categoryDAO.listAll());
        mv.addObject("userClickHome", true);

        return mv;
    }

    @RequestMapping(value = "/about")
    public ModelAndView about()
    {
        ModelAndView mv = new ModelAndView("page");    // "page" is a logical name, so to resolve a physical page name we need to use
        // viewResolver (bean viewResolver in dispatcher-servlet.xml)
        mv.addObject("title", "About us");
        mv.addObject("userClickAbout", true);
        return mv;
    }

    @RequestMapping(value = "/listProducts")
    public ModelAndView listProducts()
    {
        ModelAndView mv = new ModelAndView("page");    // "page" is a logical name, so to resolve a physical page name we need to use
        // viewResolver (bean viewResolver in dispatcher-servlet.xml)
        mv.addObject("title", "All products");
        mv.addObject("userClickListProducts", true);
        return mv;
    }

    @RequestMapping(value = "/contact")
    public ModelAndView contact()
    {
        ModelAndView mv = new ModelAndView("page");    // "page" is a logical name, so to resolve a physical page name we need to use
        // viewResolver (bean viewResolver in dispatcher-servlet.xml)
        mv.addObject("title", "Contact Us");
        mv.addObject("userClickContact", true);
        return mv;
    }

    //Method to load all products and based on category

    @RequestMapping(value = {"/show/all/products"})
    public ModelAndView showAllProducts()
    {
        ModelAndView mv = new ModelAndView("page");    // "page" is a logical name, so to resolve a physical page name we need to use
        // viewResolver (bean viewResolver in dispatcher-servlet.xml)
        mv.addObject("title", "Home");
        mv.addObject("categories", categoryDAO.listAll());
        mv.addObject("userClickAllProducts", true);

        return mv;
    }

    @RequestMapping(value = {"/show/category/{id}/products"})
    public ModelAndView showCategoryProducts(@PathVariable("id") int id)
    {
        ModelAndView mv = new ModelAndView("page");    // "page" is a logical name, so to resolve a physical page name we need to use
        // viewResolver (bean viewResolver in dispatcher-servlet.xml)

        //categoryDAO to fetch a single category
        Category category = null;
        category = categoryDAO.get(id);
        mv.addObject("title", category.getName());
        //passing the list of categories into the jsp
        mv.addObject("categories", categoryDAO.listAll());
        //passing the single category object into the jsp
        mv.addObject("category", category);
        mv.addObject("userClickCategoryProducts", true);

        return mv;
    }

    @RequestMapping(value = {"/show/{id}/product"})
    public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException
    {
        ModelAndView mv = new ModelAndView("page");    // "page" is a logical name, so to resolve a physical page name we need to use
        // viewResolver (bean viewResolver in dispatcher-servlet.xml)

        //productDAO to fetch a single product
        Product product = productDAO.get(id);

        //if product is not found, new ProductNotFoundException will be thrown
        if (product == null){throw new ProductNotFoundException();}

        Category category = categoryDAO.get(product.getCategoryID());
        product.setViews(product.getViews() + 1);
        productDAO.update(product);
        mv.addObject("title", product.getName());
        mv.addObject("product", product);
        mv.addObject("category", category);
        mv.addObject("userClickShowProduct", true);

        return mv;
    }

    @RequestMapping(value = "/register")
    public ModelAndView register(){
        ModelAndView mv = new ModelAndView("page");    // "page" is a logical name, so to resolve a physical page name we need to use
        // viewResolver (bean viewResolver in dispatcher-servlet.xml)
        mv.addObject("title", "About us");
        mv.addObject("userClickAbout", true);
        return mv;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam(name = "error", required = false) String error,
                              @RequestParam(name = "logout", required = false) String logout)
            //String logout - it is request parameter (/login?logout) from return "redirect:/login?logout"; in the @RequestMapping(value = "/perform-logout")
    {
        ModelAndView mv = new ModelAndView("login");

        if(error != null){
            mv.addObject("message", "Invalid UserName and Password");
        }

        if(logout != null){
            mv.addObject("message", "User successfully logged out");
        }

        mv.addObject("title", "Login Page");

        return mv;
    }

    @RequestMapping(value = "/access-denied")
    public ModelAndView accessDeniedHandler(){
        ModelAndView mv = new ModelAndView("error");    // "page" is a logical name, so to resolve a physical page name we need to use
        // viewResolver (bean viewResolver in dispatcher-servlet.xml)
        mv.addObject("title", "403 ERROR - Access Denied");
        mv.addObject("errorTitle", "Access Denied");
        mv.addObject("errorDescription", "Access Denied");
        return mv;
    }

    @RequestMapping(value = "/perform-logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null){

            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}

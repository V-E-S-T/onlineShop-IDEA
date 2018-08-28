package md.kniga.onlineShop.Controller;

import md.kniga.backendOnlineShop.dao.CategoryDAO;
import md.kniga.backendOnlineShop.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @Autowired
    private CategoryDAO categoryDAO;

    @RequestMapping(value = {"/", "home", "index"})
    public ModelAndView index()
    {
        ModelAndView mv = new ModelAndView("page");    // "page" is a logical name, so to resolve a physical page name we need to use
                                                                 // viewResolver (bean viewResolver in dispatcher-servlet.xml)
        mv.addObject("title", "Home");
        mv.addObject("categories", categoryDAO.list());
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
        mv.addObject("title", "List products");
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
        mv.addObject("categories", categoryDAO.list());
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
        mv.addObject("categories", categoryDAO.list());
        //passing the single category object into the jsp
        mv.addObject("category", category);
        mv.addObject("userClickCategoryProducts", true);

        return mv;
    }

}

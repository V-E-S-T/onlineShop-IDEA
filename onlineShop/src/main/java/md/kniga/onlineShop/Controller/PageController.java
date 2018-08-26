package md.kniga.onlineShop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @RequestMapping(value = {"/", "home", "index"})
    public ModelAndView index()
    {
        ModelAndView mv = new ModelAndView("page");    // "page" is a logical name, so to resolve a physical page name we need to use
                                                                 // viewResolver (bean viewResolver in dispatcher-servlet.xml)
        mv.addObject("title", "Home");
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

}

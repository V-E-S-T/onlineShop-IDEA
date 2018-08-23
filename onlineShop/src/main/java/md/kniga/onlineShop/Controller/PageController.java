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
        mv.addObject("greeting", "Welcome to MVC");

        return mv;
    }

//    @RequestMapping(value = "/test")
//    public ModelAndView test(@RequestParam(value = "greeting", required = false) String greeting)
//    {
//        if (greeting == null)
//        {
//            greeting = "Hello World";
//        }
//        ModelAndView mv = new ModelAndView("page");    // "page" is a logical name, so to resolve a physical page name we need to use
//                                                                 // viewResolver (bean viewResolver in dispatcher-servlet.xml)
//        mv.addObject("greeting", greeting);
//
//        return mv;
//    }

    @RequestMapping(value = "/test/{greeting}")
    public ModelAndView test(@PathVariable(value = "greeting", required = false) String greeting)
    {
        if (greeting == null)
        {
            greeting = "Hello World";
        }
        ModelAndView mv = new ModelAndView("page");    // "page" is a logical name, so to resolve a physical page name we need to use
        // viewResolver (bean viewResolver in dispatcher-servlet.xml)
        mv.addObject("greeting", greeting);

        return mv;
    }

}

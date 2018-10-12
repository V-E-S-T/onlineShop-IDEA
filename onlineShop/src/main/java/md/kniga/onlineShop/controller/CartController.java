package md.kniga.onlineShop.controller;

import md.kniga.onlineShop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/show")
    public ModelAndView updateCart(){

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "User Cart");
        mv.addObject("userClickShowCart", true);
        mv.addObject("cartLines", cartService.getCartLines());

        return mv;
    }




}

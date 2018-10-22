package md.kniga.onlineShop.controller;

import md.kniga.backendOnlineShop.dto.Cart;
import md.kniga.backendOnlineShop.dto.CartLine;
import md.kniga.onlineShop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/show")
    public ModelAndView showCart(@RequestParam(name = "result", required = false) String result){

        ModelAndView mv = new ModelAndView("page");

        if(result != null){
            switch (result){
                case "updated": mv.addObject("message", "Cart Line has been updated successfully");
                case "error": mv.addObject("message", "Something went wrong");
                case "deleted": mv.addObject("message", "Cart Line has been deleted successfully");
                case "added": mv.addObject("message", "Cart Line has been added successfully");
                case "maximum": mv.addObject("message", "You can add maximum 3 items of this product");
            }

        }


        mv.addObject("title", "User Cart");
        mv.addObject("userClickShowCart", true);
        List<CartLine> cartLines = cartService.getCartLines();
        mv.addObject("cartLines", cartLines);

        return mv;
    }

    @RequestMapping("{id}/update")
    public String updateCart(@PathVariable("id") int cartLineId,
                                   @RequestParam(name = "count") int count){

        String result = cartService.updateCartLine(cartLineId, count);
        ModelAndView mv = new ModelAndView("Page");
        mv.addObject("result", result);

        return "redirect:/cart/show?" + result;
    }

    @RequestMapping("{cartLineId}/delete")
    public String updateCart(@PathVariable("cartLineId") int cartLineId){

        String result = cartService.deleteCartLine(cartLineId);
        ModelAndView mv = new ModelAndView("Page");
        mv.addObject("result", result);

        return "redirect:/cart/show?" + result;
    }

    @RequestMapping("/add/{productId}/product")
    public String addProduct(@PathVariable("productId") int productId){

        String result = cartService.addCartLine(productId);
        ModelAndView mv = new ModelAndView("Page");
        mv.addObject("result", result);

        return "redirect:/cart/show?" + result;
    }




}

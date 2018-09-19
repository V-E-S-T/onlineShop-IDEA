package md.kniga.onlineShop.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    //for exception  - for example if link /sfdsf  is no handler
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handlerNoHandlerFoundException(){

        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorTitle", "The Page is not found");
        mv.addObject("errorDescription", "The Page you are looking for is not found");
        mv.addObject("title", "404 Error Page");

        return mv;
    }

    //for exception  - for example if product id /{100}  is not exist
    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handlerProductNotFoundException(){

        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorTitle", "Product is not available");
        mv.addObject("errorDescription", "The product is looking for is not available");
        mv.addObject("title", "The product unavailable");

        return mv;
    }

    //for all another exception  - for example in product id /{5} will be put /{5AVD}
    @ExceptionHandler(Exception.class)
    public ModelAndView handlerException(){

        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorTitle", "The Page is not found");
        mv.addObject("errorDescription", "The Page you are looking for is not found");
        mv.addObject("title", "404 Error Page");

        return mv;
    }
}

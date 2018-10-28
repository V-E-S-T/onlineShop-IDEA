package md.kniga.onlineShop.controller;

import md.kniga.backendOnlineShop.dao.UserDAO;
import md.kniga.backendOnlineShop.dto.Address;
import md.kniga.backendOnlineShop.dto.User;
import md.kniga.onlineShop.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserSettingsController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(UserSettingsController.class);

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public ModelAndView showUser(@ModelAttribute("userModel") UserModel userModel, @RequestParam(name="operation", required = false) String operation){
        ModelAndView mv = new ModelAndView("page");    // "page" is a logical name, so to resolve a physical page name we need to use
        // viewResolver (bean viewResolver in dispatcher-servlet.xml)
        User user = userDAO.get(userModel.getId());
        List<Address> addresses = userDAO.listAddresses(user);
        mv.addObject("title", "User Setting");
        mv.addObject("user", user);
        mv.addObject("addresses", addresses);
        mv.addObject("userClickSettings", true);

        if (operation!=null){
            if(operation.equals("updateUserDetail")){
                mv.addObject("successMessage", "Success!");
            }

        }

        return mv;
    }

    @RequestMapping(value = "/details", method = RequestMethod.POST)
    public String changeUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("userClickSettings",true);
            model.addAttribute("title", "User Setting");
            model.addAttribute("failedMessage", "Форма ввода заполнена неверно!");
            return "page";
        }

        userDAO.update(user);

        return "redirect:/user/details?operation=updateUserDetail";
    }

    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public String changePassword(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("userClickSettings",true);
            model.addAttribute("title", "User Setting");
            model.addAttribute("failedMessage", "Пароль должен содержать не менее 6 символов!");
            return "page";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userDAO.update(user);

        return "redirect:/user/details?operation=updateUserDetail";
    }

}

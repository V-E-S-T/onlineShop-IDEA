package md.kniga.onlineShop.controller;

import md.kniga.backendOnlineShop.dao.UserDAO;
import md.kniga.backendOnlineShop.dto.User;
import md.kniga.onlineShop.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalController {

    @Autowired
    private HttpSession session;

    @Autowired
    private UserDAO userDAO;

    private UserModel userModel = null;
    private User user = null;


    @ModelAttribute("userModel")
    public UserModel getUserModel(){

        if (session.getAttribute("userModel") == null){

            //add the user model
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            user = userDAO.getByEmail(authentication.getName());

            //TODO what if user==null ???
            if (user != null){

                userModel = new UserModel();
                userModel.setId(user.getId());
                userModel.setEmail(user.getEmail());
                userModel.setRole(user.getRole());
                userModel.setFullName(user.getFirst_name() + " " + user.getLast_name());

                //only if it's user is a buyer
                if(userModel.getRole().equals("USER")){

                    userModel.setCart(user.getCart());
                }

                session.setAttribute("userModel", userModel);

                return userModel;
            }
        }
        return (UserModel) session.getAttribute("userModel");
    }
}

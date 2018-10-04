package md.kniga.onlineShop.handler;

import md.kniga.backendOnlineShop.dao.UserDAO;
import md.kniga.backendOnlineShop.dto.Address;
import md.kniga.backendOnlineShop.dto.Cart;
import md.kniga.backendOnlineShop.dto.User;
import md.kniga.onlineShop.model.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public RegisterModel init(){
        return new RegisterModel();
    }

    public void addUser(RegisterModel registerModel, User user){

        registerModel.setUser(user);
    }

    public void addBilling(RegisterModel registerModel, Address billing){

        registerModel.setBilling(billing);
    }

    public String saveAll(RegisterModel registerModel){

        String transitionValue = "success";

        User user = registerModel.getUser();

        if(user.getRole().equals("USER")){
            Cart cart = new Cart();
            cart.setUser(user);
            user.setCart(cart);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userDAO.add(user);

        Address billing = registerModel.getBilling();
        billing.setUserId(user.getId());
        billing.setBillingAddress(true);

        userDAO.addAddress(billing);

        return transitionValue;
    }

    public String validateUser(User user, MessageContext error){

        String transitionValue = "success";

        if (!user.getPassword().equals(user.getConfirmPassword())){

            error.addMessage(new MessageBuilder()
                    .error()
                    .source("confirmPassword")
                    .defaultText("Password doesn't match the confirm password")
                    .build());
            transitionValue = "failure";
        }

        //check the uniqueness of the email id

        if(userDAO.getByEmail(user.getEmail()) != null){

            error.addMessage(new MessageBuilder()
                    .error()
                    .source("email")
                    .defaultText("Email is already used!")
                    .build());

            transitionValue = "failure";
        }
        return transitionValue;
    }
}

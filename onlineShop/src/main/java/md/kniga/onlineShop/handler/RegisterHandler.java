package md.kniga.onlineShop.handler;

import md.kniga.backendOnlineShop.dao.UserDAO;
import md.kniga.backendOnlineShop.dto.Address;
import md.kniga.backendOnlineShop.dto.Cart;
import md.kniga.backendOnlineShop.dto.User;
import md.kniga.onlineShop.model.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler {

    @Autowired
    private UserDAO userDAO;

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

        userDAO.add(user);

        Address billing = registerModel.getBilling();
        billing.setUserId(user.getId());
        billing.setBillingAddress(true);

        userDAO.addAddress(billing);

        return transitionValue;
    }
}

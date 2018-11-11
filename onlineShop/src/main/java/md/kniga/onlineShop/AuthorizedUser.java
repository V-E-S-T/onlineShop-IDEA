package md.kniga.onlineShop;

import md.kniga.backendOnlineShop.dao.UserDAO;
import md.kniga.backendOnlineShop.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthorizedUser {

    @Autowired
    private UserDAO userDAO;


    private static final Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    public int getCurrentUserId()
    {
        auth.getPrincipal();
        User currentUser = userDAO.getByEmail(auth.getPrincipal().toString());

        return currentUser.getId();
    }
}

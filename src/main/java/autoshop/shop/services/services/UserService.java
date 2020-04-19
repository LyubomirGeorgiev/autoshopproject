package autoshop.shop.services.services;

import autoshop.shop.data.entities.User;
import autoshop.shop.services.models.UserServiceRegisterModel;
import autoshop.shop.services.models.UserTypeInfoServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserServiceRegisterModel register(UserServiceRegisterModel userServiceModel);

    boolean usernameExist(String username);

    boolean emailExist(String email);

//    boolean phoneExist(String phoneNumber);
}

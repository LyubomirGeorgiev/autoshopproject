package autoshop.shop.services.validators;

import autoshop.shop.services.services.UserService;
import autoshop.shop.web.api.models.UserRegisterModel;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailDoesntExistValidator implements ConstraintValidator<EmailDoesntExist, Object> {

    private final UserService userService;

    @Autowired
    public EmailDoesntExistValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(EmailDoesntExist constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {

        UserRegisterModel user = (UserRegisterModel) obj;

        return !userService.emailExist(user.getEmail());
    }
}

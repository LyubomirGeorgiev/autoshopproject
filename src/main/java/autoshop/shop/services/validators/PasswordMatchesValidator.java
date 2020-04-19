package autoshop.shop.services.validators;

import autoshop.shop.web.api.models.UserRegisterModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext context) {

        UserRegisterModel user = (UserRegisterModel) o;
        return user.getPassword().equals(user.getConfirmPassword());
    }
}

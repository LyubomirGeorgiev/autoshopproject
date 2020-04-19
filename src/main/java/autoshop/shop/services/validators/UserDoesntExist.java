package autoshop.shop.services.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserDoesntExistValidator.class)
@Documented
public @interface UserDoesntExist {
    String message() default "This username is already used.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

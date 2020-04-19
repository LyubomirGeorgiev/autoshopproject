package autoshop.shop.services.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailDoesntExistValidator.class)
@Documented
public @interface EmailDoesntExist {
    String message() default "This email is already used";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

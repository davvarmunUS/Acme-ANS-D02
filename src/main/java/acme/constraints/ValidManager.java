
package acme.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ManagerValidator.class)

public @interface ValidManager {

	//Standard validation properties ---------------------------------------------------------------------------

	String message() default "pattern \"^[A-Z]{2-3}\\d{6}$\", where the first two or three letters correspond to their initials";

	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}

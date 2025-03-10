
package acme.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})

@Positive
@Min(0)

public @interface ValidYears {

	//Standard validation properties ---------------------------------------------------------------------------

	String message() default "{acme.validation.type.message}"; //crear el archivo message en fragments

	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}

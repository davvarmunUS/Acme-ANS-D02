
package acme.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.hibernate.validator.constraints.Length;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})

@Length(max = 255)

public @interface ValidLink {

	//Standard validation properties ---------------------------------------------------------------------------

	String message() default "{acme.validation.link.message}"; //crear el archivo message en fragments

	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}

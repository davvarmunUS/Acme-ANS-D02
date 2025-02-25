
package acme.realms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.components.basis.AbstractRole;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Manager extends AbstractRole {

	// Serialisation version ---------------------------------------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes --------------------------------------------------------------------------------------------------

	@Mandatory
	@Pattern(regexp = "^[A-Z]{2,3}\\d{6}$")
	@Column(unique = true)
	private String				identifierNumber;

	@Mandatory
	@Positive
	@Min(0)
	@Automapped
	private int					yearsOfExperience;

	// Así es como debe ser, perfecto, los tres niveles de etiquetas
	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				birth;

	// Esta también está bien
	@Optional
	@URL
	@Length(max = 255)
	@Automapped
	private String				link;

	// Derived attributes -----------------------------------------------------------------------------------------

	// Relationships ----------------------------------------------------------------------------------------------
}

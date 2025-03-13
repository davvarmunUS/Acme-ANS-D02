
package acme.realms;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import acme.client.components.basis.AbstractRole;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidString;
import acme.constraints.ValidCustomerIdentifier;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer extends AbstractRole {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@ValidString
	@Automapped
	@ValidCustomerIdentifier
	private String				identifier;

	@Mandatory
	@Automapped
	@Pattern(regexp = "^\\+?\\d{6,15}$")
	private String				phoneNumber;

	@Mandatory
	@Length(min = 1, max = 255)
	@ValidString
	@Automapped
	private String				physicalAddress;

	@Mandatory
	@Length(min = 1, max = 50)
	@ValidString
	@Automapped
	private String				city;

	@Mandatory
	@Length(min = 1, max = 50)
	@ValidString
	@Automapped
	private String				country;

	@Optional
	@Range(min = 0, max = 500000)
	@Automapped
	private Integer				earnedPoints;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}

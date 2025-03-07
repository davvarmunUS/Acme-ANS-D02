
package acme.entities.customers;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import acme.client.components.basis.AbstractRole;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidString;
import acme.constraints.ValidCustomerIdentifier;
import acme.datatypes.Phone;
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
	private Phone				phoneNumber;

	@Mandatory
	@Length(min = 1, max = 75)
	@ValidString
	@Automapped
	private String				physicalAddress;

	@Mandatory
	@ValidString
	@Automapped
	private String				city;

	@Mandatory
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

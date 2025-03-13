
package acme.entities.aircraft;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import org.checkerframework.common.aliasing.qual.Unique;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidEmail;
import acme.client.components.validation.ValidString;
import acme.entities.airports.Airline;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Aircraft extends AbstractEntity {

	// Serialisation version ---------------------------------------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes --------------------------------------------------------------------------------------------------

	@Mandatory
	@ValidString(max = 50)
	@Automapped
	private String				model;

	@Mandatory
	@Unique
	@ValidString(max = 50)
	@Automapped
	private String				registrationNumber;

	@Mandatory
	@Automapped
	private Integer				capacity;

	@Mandatory
	@Valid
	@Automapped
	private Integer				cargoWeight;

	@Mandatory
	private Status				status;

	@Optional
	@ValidEmail
	@Automapped
	@ValidString(max = 255)
	private String				details;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------------------------------------------

	@Mandatory
	@Valid
	@ManyToOne
	private Airline				airline;
}

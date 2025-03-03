
package acme.entities.flights;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Leg extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@Pattern(regexp = "^[A-Z]{2,3}\\d{4}$")
	@ValidString
	@Column(unique = true)
	private String				flightNumber;

	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				scheduledDeparture;

	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				scheduledArrival;

	@Mandatory
	@Automapped
	private int					duration;

	@Mandatory
	@Valid
	@Automapped
	private Status				status;

	@Mandatory
	@Valid
	@Automapped
	private String				departureAirport;

	@Mandatory
	@Valid
	@Automapped
	private String				arrivalAirport;

	@Mandatory
	@Valid
	@Automapped
	private String				aircraft;

	// Derived attributes -----------------------------------------------------------------------------------------

	// Relationships ----------------------------------------------------------------------------------------------
	@Mandatory
	@Valid
	@OneToMany
	private Flight				flight;
}

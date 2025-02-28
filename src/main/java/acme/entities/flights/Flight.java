
package acme.entities.flights;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Flight extends AbstractEntity {

	// Serialisation version ---------------------------------------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes --------------------------------------------------------------------------------------------------

	@Mandatory
	@ValidString(max = 50)
	@Automapped
	private String				tag;

	@Mandatory
	@Automapped
	private boolean				indication;

	@Mandatory
	@ValidMoney
	@Automapped
	private Money				cost;

	@Optional
	@ValidString(max = 255)
	@Automapped
	private String				description;

	// Derived attributes -----------------------------------------------------

	private Date				scheduledDeparture;

	private Date				scheduledArrival;

	private String				originCity;

	private String				destinationCity;

	private int					numberOfLayovers;

	// Relationships ----------------------------------------------------------------------------------------------

	@Mandatory
	@OneToMany
	private Leg					leg;

}

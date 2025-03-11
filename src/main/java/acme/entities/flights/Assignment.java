
package acme.entities.flights;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Assignment extends AbstractEntity {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	//Attributes..........................................

	@Mandatory
	@Enumerated(EnumType.STRING)
	@Automapped
	private Duty				duty;

	@Mandatory
	@ValidMoment
	@Temporal(TemporalType.DATE)
	private Date				lastUpdate;

	@Mandatory
	@Enumerated(EnumType.STRING)
	@Automapped
	private Status				currentStatus;

	@Optional
	@ValidString(max = 255)
	@Automapped
	private String				remarks;
}


package acme.entities.services;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Positive;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUrl;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Service extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@ValidString(min = 1, max = 50)
	@Automapped
	private String				name;

	@Mandatory
	@ValidUrl
	@Automapped
	private String				pictureLink;

	@Mandatory
	@Positive
	private Double				avgDwellTime;

	@Optional
	@Column(unique = true)
	@ValidString(pattern = "^[A-Z]{4}-[0-9]{2}$")
	@Automapped
	private String				promotionCode;

	@Optional
	@ValidMoney
	@Automapped
	private Money				money;

}

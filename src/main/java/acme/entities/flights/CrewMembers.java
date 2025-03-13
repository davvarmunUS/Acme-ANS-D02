
package acme.entities.flights;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CrewMembers extends AbstractEntity {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	//Attributes..........................................

	@Mandatory
	@ValidString(pattern = "^[A-Z]{2,3}\\d{6}$")
	@Column(unique = true)
	private String				code;

	@Mandatory
	@ValidString(pattern = "^\\+?\\d{6,15}$") //Al tener en pattern d{6,15} hay que usar min?
	@Automapped
	private String				phone;

	@Mandatory
	@ValidString(max = 255)
	@Automapped
	private String				languageSkill;

	@Mandatory
	@Enumerated(EnumType.STRING)
	@Automapped
	private AvailabilityStatus	availabilityStatus;

	@Mandatory
	@Valid //
	@Automapped
	private String				airline;

	@Mandatory
	@ValidMoney
	@Automapped
	private Money				salary;

	@Optional
	@ValidNumber(min = 0, max = 80)
	@Automapped
	private int					yearsOfExperience;

	// Relationships -------------------------------------------------------------

	@OneToMany(mappedBy = "crewMember", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Assignment>	assignments; // Un CrewMember tiene varias asignaciones
}

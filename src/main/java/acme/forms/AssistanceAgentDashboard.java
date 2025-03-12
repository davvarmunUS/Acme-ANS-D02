
package acme.forms;

import java.util.Collection;
import java.util.Date;

import acme.client.components.basis.AbstractForm;
import acme.client.components.validation.ValidScore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssistanceAgentDashboard extends AbstractForm {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@ValidScore
	private double				resolvedClaimsRatio;

	@ValidScore
	private double				rejectedClaimsRatio;

	private Collection<Date>	topThreeMonthsClaims;

	private double				avgTotalClaims;
	private int					minTotalClaims;
	private int					maxTotalClaims;
	private double				stdevTotalClaims;

	private double				avgLastMonthAssistedClaims;
	private int					minLastMonthAssistedClaims;
	private int					maxLastMonthAssistedClaims;
	private double				stdevLastMonthAssistedClaims;

}

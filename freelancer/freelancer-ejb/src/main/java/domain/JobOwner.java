package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: JobOwner
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class JobOwner extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Evaluation evaluation;

	public JobOwner() {
		super();
	}

	@OneToOne
	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

}

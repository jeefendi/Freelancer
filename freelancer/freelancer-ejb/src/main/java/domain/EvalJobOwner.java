package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Entity implementation class for Entity: EvalJobOwner
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class EvalJobOwner extends Evaluation implements Serializable {

	private static final long serialVersionUID = 1L;

	public EvalJobOwner() {
		super();
	}

}

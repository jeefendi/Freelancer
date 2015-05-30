package domain;

import domain.Evaluation;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EvalFreelancer
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class EvalFreelancer extends Evaluation implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public EvalFreelancer() {
		super();
	}
   
}

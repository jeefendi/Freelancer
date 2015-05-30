package domain;

import domain.User;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Admin extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}
   
}

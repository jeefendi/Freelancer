package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Freelancer
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Freelancer extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cvFilePath;

	private Evaluation evaluation;
	private List<Application> applications;
	private List<Qualification> qualifications;

	public Freelancer() {
		super();
	}

	public Freelancer(String cvFilePath, String lastName, String firstName,
			String email, String login, String password) {
		super(lastName, firstName, email, login, password);
		this.cvFilePath = cvFilePath;
	}

	public String getCvFilePath() {
		return cvFilePath;
	}

	public void setCvFilePath(String cvFilePath) {
		this.cvFilePath = cvFilePath;
	}

	@OneToOne
	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	@OneToMany(mappedBy = "freelancer")
	public List<Application> getApplications() {
		if (this.applications == null)
			applications = new ArrayList<Application>();
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	@OneToMany(mappedBy = "freelancer")
	public List<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

	@Override
	public String toString() {
		return "Freelancer [cvFilePath=" + cvFilePath + "]" + super.toString();
	}

}

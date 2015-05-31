package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: JobOwner
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class JobOwner extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String companyName;
	private String address;

	private List<Project> projects;
	private List<Evaluation> evaluations;

	public JobOwner() {
		super();
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToMany(mappedBy = "jobOwner")
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@OneToMany(mappedBy = "jobOwner")
	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

}

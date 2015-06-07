package domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Application
 *
 */
@Entity
public class Application implements Serializable {

	private static final long serialVersionUID = 1L;

	private ApplicationId applicationId;
	private Boolean isActive;

	private Freelancer freelancer;
	private Job job;
	private Assignment assignment;

	public Application() {
		super();
		this.isActive = true;
	}

	@EmbeddedId
	public ApplicationId getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(ApplicationId applicationId) {
		this.applicationId = applicationId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@ManyToOne
	@JoinColumn(name = "freelancerId", referencedColumnName = "id", insertable = false, updatable = false)
	public Freelancer getFreelancer() {
		return freelancer;
	}

	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}

	@ManyToOne
	@JoinColumn(name = "jobId", referencedColumnName = "id", insertable = false, updatable = false)
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@OneToOne
	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

}

package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Job
 *
 */
@Entity
public class Job implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String title;
	private String description;
	private Boolean isOpenForAppliance;
	private Boolean isCompleted;
	private Date dateOfSubmission;
	private Date dateOfClosure;
	private Date estimatedCompletionDate;

	private List<Application> applications;

	public Job() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsOpenForAppliance() {
		return this.isOpenForAppliance;
	}

	public void setIsOpenForAppliance(Boolean isOpenForAppliance) {
		this.isOpenForAppliance = isOpenForAppliance;
	}

	public Boolean getIsCompleted() {
		return this.isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Date getDateOfSubmission() {
		return this.dateOfSubmission;
	}

	public void setDateOfSubmission(Date dateOfSubmission) {
		this.dateOfSubmission = dateOfSubmission;
	}

	public Date getDateOfClosure() {
		return this.dateOfClosure;
	}

	public void setDateOfClosure(Date dateOfClosure) {
		this.dateOfClosure = dateOfClosure;
	}

	public Date getEstimatedCompletionDate() {
		return this.estimatedCompletionDate;
	}

	public void setEstimatedCompletionDate(Date estimatedCompletionDate) {
		this.estimatedCompletionDate = estimatedCompletionDate;
	}

	@OneToMany(mappedBy = "job")
	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

}

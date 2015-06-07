package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	private Boolean isOpen;
	private Date dateOfSubmission;
	private Date closureDate;

	private List<Application> applications;
	private JobOwner jobOwner;
	private List<RequiredLevel> requiredLevels;

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

	public Boolean getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateOfSubmission() {
		return this.dateOfSubmission;
	}

	public void setDateOfSubmission(Date dateOfSubmission) {
		this.dateOfSubmission = dateOfSubmission;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getClosureDate() {
		return closureDate;
	}

	public void setClosureDate(Date closureDate) {
		this.closureDate = closureDate;
	}

	@OneToMany(mappedBy = "job")
	public List<Application> getApplications() {
		if (this.applications == null)
			applications = new ArrayList<Application>();
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	@ManyToOne
	public JobOwner getJobOwner() {
		return jobOwner;
	}

	public void setJobOwner(JobOwner jobOwner) {
		this.jobOwner = jobOwner;
	}

	@OneToMany(mappedBy = "job", fetch = FetchType.EAGER)
	public List<RequiredLevel> getRequiredLevels() {
		return requiredLevels;
	}

	public void setRequiredLevels(List<RequiredLevel> requiredLevels) {
		this.requiredLevels = requiredLevels;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", description="
				+ description + ", isOpen=" + isOpen + ", dateOfSubmission="
				+ dateOfSubmission + "]";
	}

}

package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private Boolean isOpen;
	private Date dateOfSubmission;

	private List<Application> applications;
	private Project project;
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

	public Date getDateOfSubmission() {
		return this.dateOfSubmission;
	}

	public void setDateOfSubmission(Date dateOfSubmission) {
		this.dateOfSubmission = dateOfSubmission;
	}

	@OneToMany(mappedBy = "job")
	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	@ManyToOne
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@OneToMany(mappedBy = "job")
	public List<RequiredLevel> getRequiredLevels() {
		return requiredLevels;
	}

	public void setRequiredLevels(List<RequiredLevel> requiredLevels) {
		this.requiredLevels = requiredLevels;
	}

}

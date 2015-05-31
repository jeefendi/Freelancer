package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String title;
	private String description;
	private Boolean isOpen;
	private Date introductionDate;
	private Date closureDate;

	private JobOwner jobOwner;
	private List<Job> jobs;

	public Project() {
		super();
	}

	@Id
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
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

	public Date getIntroductionDate() {
		return this.introductionDate;
	}

	public void setIntroductionDate(Date introductionDate) {
		this.introductionDate = introductionDate;
	}

	public Date getClosureDate() {
		return this.closureDate;
	}

	public void setClosureDate(Date closureDate) {
		this.closureDate = closureDate;
	}

	@ManyToOne
	public JobOwner getJobOwner() {
		return jobOwner;
	}

	public void setJobOwner(JobOwner jobOwner) {
		this.jobOwner = jobOwner;
	}

	@OneToMany(mappedBy = "project")
	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

}

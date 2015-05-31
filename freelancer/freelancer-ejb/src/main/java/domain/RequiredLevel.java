package domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: RequiredLevel
 *
 */
@Entity
public class RequiredLevel implements Serializable {

	private static final long serialVersionUID = 1L;

	private RequiredLevelId requiredLevelId;
	private Integer level;

	private Job job;
	private Skill skill;

	public RequiredLevel() {
		super();
	}

	@EmbeddedId
	public RequiredLevelId getRequiredLevelId() {
		return requiredLevelId;
	}

	public void setRequiredLevelId(RequiredLevelId requiredLevelId) {
		this.requiredLevelId = requiredLevelId;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@ManyToOne
	@JoinColumn(name = "jobId", referencedColumnName = "id", insertable = false, updatable = false)
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@ManyToOne
	@JoinColumn(name = "skillId", referencedColumnName = "id", insertable = false, updatable = false)
	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}

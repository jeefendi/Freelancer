package domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Qualification
 *
 */
@Entity
public class Qualification implements Serializable {

	private static final long serialVersionUID = 1L;

	private QualificationId qualificationId;

	private Integer level;

	private Freelancer freelancer;
	private Skill skill;

	public Qualification() {
		super();
	}

	@EmbeddedId
	public QualificationId getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(QualificationId qualificationId) {
		this.qualificationId = qualificationId;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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
	@JoinColumn(name = "skillId", referencedColumnName = "id", insertable = false, updatable = false)
	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}

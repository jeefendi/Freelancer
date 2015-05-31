package domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class QualificationId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer freelancerId;
	private Integer skillId;

	public QualificationId() {
	}

	public QualificationId(Integer freelancerId, Integer skillId) {
		this.freelancerId = freelancerId;
		this.skillId = skillId;
	}

	public Integer getFreelancerId() {
		return freelancerId;
	}

	public void setFreelancerId(Integer freelancerId) {
		this.freelancerId = freelancerId;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((freelancerId == null) ? 0 : freelancerId.hashCode());
		result = prime * result + ((skillId == null) ? 0 : skillId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof QualificationId))
			return false;
		QualificationId other = (QualificationId) obj;
		if (freelancerId == null) {
			if (other.freelancerId != null)
				return false;
		} else if (!freelancerId.equals(other.freelancerId))
			return false;
		if (skillId == null) {
			if (other.skillId != null)
				return false;
		} else if (!skillId.equals(other.skillId))
			return false;
		return true;
	}

}

package domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RequiredLevelId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer skillId;
	private Integer jobId;

	public RequiredLevelId() {
	}

	public RequiredLevelId(Integer skillId, Integer jobId) {
		this.skillId = skillId;
		this.jobId = jobId;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
		result = prime * result + ((skillId == null) ? 0 : skillId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RequiredLevelId))
			return false;
		RequiredLevelId other = (RequiredLevelId) obj;
		if (jobId == null) {
			if (other.jobId != null)
				return false;
		} else if (!jobId.equals(other.jobId))
			return false;
		if (skillId == null) {
			if (other.skillId != null)
				return false;
		} else if (!skillId.equals(other.skillId))
			return false;
		return true;
	}

}

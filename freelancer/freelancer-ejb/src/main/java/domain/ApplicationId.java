package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class ApplicationId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer freelancerId;
	private Integer jobId;
	private Date date;

	public ApplicationId() {
	}

	public ApplicationId(Integer freelancerId, Integer jobId, Date date) {
		this.freelancerId = freelancerId;
		this.jobId = jobId;
		this.date = date;
	}

	public Integer getFreelancerId() {
		return freelancerId;
	}

	public void setFreelancerId(Integer freelancerId) {
		this.freelancerId = freelancerId;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((freelancerId == null) ? 0 : freelancerId.hashCode());
		result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicationId other = (ApplicationId) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (freelancerId == null) {
			if (other.freelancerId != null)
				return false;
		} else if (!freelancerId.equals(other.freelancerId))
			return false;
		if (jobId == null) {
			if (other.jobId != null)
				return false;
		} else if (!jobId.equals(other.jobId))
			return false;
		return true;
	}

}

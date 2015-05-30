package domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EvaluationId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idFreelancer;
	private Integer idJobOwner;

	public EvaluationId() {
	}

	public EvaluationId(Integer idFreelancer, Integer idJobOwner) {
		this.idFreelancer = idFreelancer;
		this.idJobOwner = idJobOwner;
	}

	public Integer getIdFreelancer() {
		return idFreelancer;
	}

	public void setIdFreelancer(Integer idFreelancer) {
		this.idFreelancer = idFreelancer;
	}

	public Integer getIdJobOwner() {
		return idJobOwner;
	}

	public void setIdJobOwner(Integer idJobOwner) {
		this.idJobOwner = idJobOwner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idFreelancer == null) ? 0 : idFreelancer.hashCode());
		result = prime * result
				+ ((idJobOwner == null) ? 0 : idJobOwner.hashCode());
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
		EvaluationId other = (EvaluationId) obj;
		if (idFreelancer == null) {
			if (other.idFreelancer != null)
				return false;
		} else if (!idFreelancer.equals(other.idFreelancer))
			return false;
		if (idJobOwner == null) {
			if (other.idJobOwner != null)
				return false;
		} else if (!idJobOwner.equals(other.idJobOwner))
			return false;
		return true;
	}

}

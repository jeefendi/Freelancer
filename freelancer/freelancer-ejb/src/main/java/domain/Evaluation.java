package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Evaluation
 *
 */
@Entity
public class Evaluation implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer score;
	private String comment;
	private Date dateOfEval;

	private EvaluationId evaluationId;

	private Freelancer freelancer;
	private JobOwner jobOwner;

	public Evaluation() {
		super();
	}

	@EmbeddedId
	public EvaluationId getEvaluationId() {
		return evaluationId;
	}

	public void setEvaluationId(EvaluationId evaluationId) {
		this.evaluationId = evaluationId;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDateOfEval() {
		return this.dateOfEval;
	}

	public void setDateOfEval(Date dateOfEval) {
		this.dateOfEval = dateOfEval;
	}

	@OneToOne(mappedBy = "evaluation")
	public Freelancer getFreelancer() {
		return freelancer;
	}

	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}

	@OneToOne(mappedBy = "evaluation")
	public JobOwner getJobOwner() {
		return jobOwner;
	}

	public void setJobOwner(JobOwner jobOwner) {
		this.jobOwner = jobOwner;
	}

}

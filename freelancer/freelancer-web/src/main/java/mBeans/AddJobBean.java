package mBeans;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import services.impl.JobsMgtSvc;
import domain.Job;

@ViewScoped
@ManagedBean(name = "AddJobB")
public class AddJobBean {
	@EJB
	JobsMgtSvc svc;

	private Job job = new Job();

	public AddJobBean() {
		// TODO Auto-generated constructor stub
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String addJob() {
		job.setDateOfSubmission(new Date());
		job.setIsOpen(true);
		job = svc.addJob(job);
		return "/pages/jobowner/jobslist";
	}
}

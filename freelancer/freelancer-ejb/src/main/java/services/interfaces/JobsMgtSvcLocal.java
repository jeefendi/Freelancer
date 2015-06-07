package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.Job;

@Local
public interface JobsMgtSvcLocal {
	List<Job> getAllJobs();

	List<Job> getAvailableJobs();

	Job addJob(Job job);
}

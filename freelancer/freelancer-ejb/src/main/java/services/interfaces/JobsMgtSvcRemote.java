package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import domain.Job;

@Remote
public interface JobsMgtSvcRemote {
	List<Job> getAllJobs();

	List<Job> getAvailableJobs();
}

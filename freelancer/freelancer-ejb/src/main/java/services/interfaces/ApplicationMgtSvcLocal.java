package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.Application;

@Local
public interface ApplicationMgtSvcLocal {
	List<Application> getAllOpenJobs();
}

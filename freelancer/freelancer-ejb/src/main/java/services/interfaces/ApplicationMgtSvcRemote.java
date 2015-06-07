package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import domain.Application;

@Remote
public interface ApplicationMgtSvcRemote {
	List<Application> getApplications();
}

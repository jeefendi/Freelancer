package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import domain.Freelancer;

@Remote
public interface FreelancerMgtSvcRemote {
	List<Freelancer> getAllFreelancers();

}

package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.Freelancer;

@Local
public interface FreelancerMgtSvcLocal {
	List<Freelancer> getAllFreelancers();

}

package services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import services.interfaces.FreelancerMgtSvcLocal;
import services.interfaces.FreelancerMgtSvcRemote;
import domain.Freelancer;

/**
 * Session Bean implementation class FreelancerMgtSvc
 */
@Stateless
@LocalBean
public class FreelancerMgtSvc implements FreelancerMgtSvcRemote,
		FreelancerMgtSvcLocal {
	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public FreelancerMgtSvc() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Freelancer> getAllFreelancers() {
		List<Freelancer> freelancers = new ArrayList<Freelancer>();
		try {
			String jpql = "select f from Freelancer f";
			TypedQuery<Freelancer> typedQuery = em.createQuery(jpql,
					Freelancer.class);
			freelancers = typedQuery.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		}
		return freelancers;
	}
}

package services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import services.interfaces.ApplicationMgtSvcLocal;
import domain.Application;

/**
 * Session Bean implementation class ApplicationMgtSvc
 */
@Stateless
@LocalBean
public class ApplicationMgtSvc implements ApplicationMgtSvcLocal {
	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public ApplicationMgtSvc() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Application> getAllOpenJobs() {
		List<Application> applications = new ArrayList<Application>();
		try {
			String jpql = "select j from Job j";
			TypedQuery<Application> typedQuery = em.createQuery(jpql,
					Application.class);
			applications = typedQuery.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		}
		return applications;
	}

}

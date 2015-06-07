package services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import services.interfaces.JobsMgtSvcLocal;
import domain.Job;

/**
 * Session Bean implementation class JobsMgtSvc
 */
@Stateless
@LocalBean
public class JobsMgtSvc implements JobsMgtSvcLocal {
	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public JobsMgtSvc() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Job> getAllJobs() {
		List<Job> jobs = new ArrayList<Job>();
		try {
			String jpql = "select j from Job j";
			TypedQuery<Job> typedQuery = em.createQuery(jpql, Job.class);
			jobs = typedQuery.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		}
		return jobs;
	}

	@Override
	public List<Job> getAvailableJobs() {
		List<Job> jobs = new ArrayList<Job>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		System.out.println(calendar);
		try {
			String jpql = "select j from Job j where j.closureDate > CURRENT_TIMESTAMP and j.isOpen=true";
			TypedQuery<Job> typedQuery = em.createQuery(jpql, Job.class);
			jobs = typedQuery.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		}
		return jobs;
	}

	@Override
	public Job addJob(Job job) {
		return em.merge(job);
	}

	@Override
	public List<Job> GetJobsByJobOwnerId(Integer Id) {
		List<Job> jobs = new ArrayList<Job>();
		try {
			String jpql = "select j from Job j where j.jobOwner=" + Id;
			TypedQuery<Job> typedQuery = em.createQuery(jpql, Job.class);
			jobs = typedQuery.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		}
		return jobs;
	}

}

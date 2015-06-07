package services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Application;
import domain.ApplicationId;
import domain.Freelancer;
import domain.Job;
import domain.JobOwner;
import domain.RequiredLevel;
import domain.RequiredLevelId;
import domain.Skill;

/**
 * Session Bean implementation class DbCreator
 */
@Singleton
@Startup
public class DbCreator {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public DbCreator() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initDb() {
		// Création freelancer1
		Freelancer freelancer = new Freelancer();
		freelancer.setEmail("testmail@domain.net");
		freelancer.setFirstName("MyFirstName");
		freelancer.setLastName("MyLastName");
		freelancer.setLogin("login");
		freelancer.setPassword("pass");
		entityManager.persist(freelancer);

		// Création Skill java
		Skill skillJava = new Skill();
		skillJava.setName("JAVA");
		skillJava.setDescription("Développement JAVA");
		skillJava = entityManager.merge(skillJava);

		// Création skill swing
		Skill skillSwing = new Skill();
		skillSwing.setName("Swing");
		skillSwing
				.setDescription("Développement d'applications graphiques Swing");
		skillSwing = entityManager.merge(skillSwing);

		// création job1
		Job job1 = new Job();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015, 6, 3);
		job1.setDateOfSubmission(calendar.getTime());
		job1.setDescription("Développement JAVA 7 et Swing");
		job1.setIsOpen(true);
		job1.setTitle("Développement JAVA");
		calendar.set(2015, 8, 25);
		job1.setClosureDate(calendar.getTime());
		job1 = entityManager.merge(job1);

		// création job2
		Job job2 = new Job();
		calendar.set(2015, 2, 2);
		job2.setDateOfSubmission(calendar.getTime());
		job2.setDescription("Développement PHP5 avec Symfony2");
		job2.setIsOpen(true);
		job2.setTitle("Développement Symfony2");
		calendar.set(2015, 8, 25);
		job2.setClosureDate(calendar.getTime());
		job2 = entityManager.merge(job2);

		// création RequiredLevel Job1-skillJava niv2
		RequiredLevel reqlvl1 = new RequiredLevel();
		reqlvl1.setRequiredLevelId(new RequiredLevelId(skillJava.getId(), job1
				.getId()));
		reqlvl1.setLevel(2);
		reqlvl1.setJob(job1);
		reqlvl1.setSkill(skillJava);
		reqlvl1 = entityManager.merge(reqlvl1);

		// Création RequiredLevel job1-skillSwing niv5
		RequiredLevel reqlvl2 = new RequiredLevel();
		reqlvl2.setRequiredLevelId(new RequiredLevelId(skillSwing.getId(), job1
				.getId()));
		reqlvl2.setLevel(5);
		reqlvl2.setJob(job1);
		reqlvl2.setSkill(skillSwing);
		reqlvl2 = entityManager.merge(reqlvl2);

		// création jobOwner1 pour job1
		JobOwner jobOwner1 = new JobOwner();
		jobOwner1.setAddress("22 Rue du Cherche Midi");
		jobOwner1.setCompanyName("LaOoredoo");
		jobOwner1.setEmail("contact@laooredoo.net");
		jobOwner1.setFirstName("Bechir");
		jobOwner1.setLastName("Touhami");
		jobOwner1.setLogin("Touhamib");
		jobOwner1.setPassword("pass");
		List<Job> jobs1 = new ArrayList<Job>();
		jobs1.add(job1);
		jobOwner1.setJobs(jobs1);
		job1.setJobOwner(jobOwner1);
		job1 = entityManager.merge(job1);
		jobOwner1 = entityManager.merge(jobOwner1);

		// freelancer anis
		Freelancer anisfreelancer = new Freelancer(null, "fendi", "anis",
				"anis1fendi@gmail.com", "anislogin", "pass");
		anisfreelancer = entityManager.merge(anisfreelancer);

		// freelancer anis candidat pour job2
		Application application = new Application();
		calendar.set(2015, 07, 22);
		application.setApplicationId(new ApplicationId(anisfreelancer.getId(),
				job2.getId(), (calendar.getTime())));
		application.setFreelancer(anisfreelancer);
		List<Application> anisappls = anisfreelancer.getApplications();
		anisappls.add(application);
		application.setJob(job2);
		List<Application> job2appls = job2.getApplications();
		System.out.println(job2appls);
		job2appls.add(application);
		application = entityManager.merge(application);
		anisfreelancer = entityManager.merge(anisfreelancer);
		job2 = entityManager.merge(job2);

	}
}

package services;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	}
}

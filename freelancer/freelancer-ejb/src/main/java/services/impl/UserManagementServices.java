package services.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.UserManagementServicesLocal;
import domain.User;

/**
 * Session Bean implementation class UserManagementServices
 */
@Stateless
@LocalBean
public class UserManagementServices implements UserManagementServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserManagementServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User login(String login, String password) {
		User user = null;
		String jpql = "select u from User u where u.login =:param1 and u.password =:param2 ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("user not found ");
		}
		return user;
	}

	@Override
	public User findById(int id) {
		User user = null;
		try {
			user = entityManager.find(User.class, id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return user;
	}

}

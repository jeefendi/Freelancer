package services.interfaces;

import javax.ejb.Local;

import domain.User;

@Local
public interface UserManagementServicesLocal {
	User login(String login, String password);

	User findById(int id);

}

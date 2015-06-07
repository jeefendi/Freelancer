package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.UserManagementServicesLocal;
import domain.Freelancer;
import domain.JobOwner;
import domain.User;

@ManagedBean(name = "lb")
@SessionScoped
public class LoginBean {
	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@EJB
	private UserManagementServicesLocal userManagementServicesLocal;

	public String doLogin() {
		User userfound = userManagementServicesLocal.login(user.getLogin(),
				user.getPassword());
		if (userfound != null) {
			user = userfound;
			if (userfound instanceof Freelancer)
				return "/pages/freelancer/freelancer-home";
			else if (userfound instanceof JobOwner) {
				return "/pages/jobowner/jobowner-home";
			} else
				return "/pages/admi/admin-home";
		}

		return "/pages/login";
	}
}

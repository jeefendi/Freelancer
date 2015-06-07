package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import services.impl.GwMessage;

@ManagedBean(name = "AppDetailBean")
@ViewScoped
public class ApplicationDetailBean {
	@EJB
	GwMessage message;

	public ApplicationDetailBean() {
		// TODO Auto-generated constructor stub
	}

	public void accept() {
		message.sendEmail("anis1fendi@gmail.com",
				"freelancer3cinfo2@gmail.com", "Application accepted",
				"Votre candidature a été acceptée");
	}
}

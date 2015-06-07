package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import services.impl.ApplicationMgtSvc;
import domain.Application;

@ViewScoped
@ManagedBean(name = "AppsB")
public class ApplicationsBean {
	@EJB
	ApplicationMgtSvc svc;

	public ApplicationsBean() {
		// TODO Auto-generated constructor stub
	}

	private List<Application> applications = new ArrayList<Application>();

	@PostConstruct
	public void init() {
		setApplications(svc.getApplications());
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

}

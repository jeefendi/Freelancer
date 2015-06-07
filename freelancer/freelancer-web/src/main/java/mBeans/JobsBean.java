package mBeans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import services.impl.JobsMgtSvc;
import domain.Job;
import domain.RequiredLevel;

@ManagedBean(name = "JsB")
@ViewScoped
public class JobsBean {
	@EJB
	JobsMgtSvc svc;
	@ManagedProperty(value = "#{lb}")
	private LoginBean loginbean;
	private List<Job> jobs = new ArrayList<Job>();

	public JobsBean() {
		// TODO Auto-generated constructor stub
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public LoginBean getLoginbean() {
		return loginbean;
	}

	public void setLoginbean(LoginBean loginbean) {
		this.loginbean = loginbean;
	}

	@PostConstruct
	public void init() {
		jobs = svc.GetJobsByJobOwnerId(loginbean.getUser().getId());
	}

	/*
	 * Méthode qui va retourner l'ensemble des noms des compétences requises
	 * sous forme d'une chaîne. Exemple: "JAVA" "Swing" ...
	 */
	public String getSkillsAsString(Job job) {
		String skills = "";
		List<RequiredLevel> requiredLevels = job.getRequiredLevels();
		System.out.println(requiredLevels.size());
		for (RequiredLevel requiredLevel : requiredLevels) {
			skills = skills + "\n" + requiredLevel.getSkill().getName();
		}
		System.out.println(skills);
		return skills;
	}

	/*
	 * Convertir la date pour l'afficher correctement
	 */

	public String getDate(Date date) {

		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		return df.format(date);
	}

}

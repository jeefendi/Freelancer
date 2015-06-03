package test;

import java.util.List;

import javax.naming.Context;

import services.interfaces.FreelancerMgtSvcRemote;
import domain.Freelancer;

public class TestFreelancer {

	public static void main(String[] args) {
		Context context = Utils.getContext();
		try {
			FreelancerMgtSvcRemote proxy = (FreelancerMgtSvcRemote) context
					.lookup("/freelancer-web/FreelancerMgtSvc!services.interfaces.FreelancerMgtSvcRemote");
			List<Freelancer> freelancers = proxy.getAllFreelancers();
			for (Freelancer freelancer : freelancers)
				System.out.println(freelancer);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

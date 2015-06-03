package test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

public class Utils {
	
	public static Context getContext() {
		Context context = null;
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL,
				"http-remoting://localhost:8080");
		jndiProperties.put("jboss.naming.client.ejb.context", "true");
		jndiProperties
				.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT",
						"false");
		try {
			context = new InitialContext(jndiProperties);
		} catch (Exception e) {
			System.out.println(e);
		}
		return context;

	}


}

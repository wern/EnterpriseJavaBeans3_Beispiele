/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package sicherheit.authentifizierung;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

public class ClientMitAnmeldung {

	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jboss.security.jndi.JndiLoginInitialContextFactory");
		properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");
		
		System.out.println("Anmeldung am Server als Scott.");
		properties.put(Context.SECURITY_PRINCIPAL, "Scott");
		properties.put(Context.SECURITY_CREDENTIALS, "tiger");

		Tor tor = (Tor) new InitialContext(properties).lookup("Tor/remote");
		tor.klopfen();
		System.out.println("Die Ausgabe steht im Server-Log.");
	}
}

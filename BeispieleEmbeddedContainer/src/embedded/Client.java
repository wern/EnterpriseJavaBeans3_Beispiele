/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package embedded;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.jboss.ejb3.embedded.EJB3StandaloneBootstrap;

public class Client {
	public static void main(String[] args) throws Exception{
		EJB3StandaloneBootstrap.boot(null);
		EJB3StandaloneBootstrap.scanClasspath();

		Hashtable props = new Hashtable();
		props.put("java.naming.factory.initial",
				"org.jnp.interfaces.LocalOnlyContextFactory");
		props.put("java.naming.factory.url.pkgs",
				"org.jboss.naming:org.jnp.interfaces");

		Context ctx = new InitialContext(props);
		TesteMichFassade fassade = (TesteMichFassade)ctx.lookup("Fassade/remote");
		int id = fassade.erzeugeEntity("EmbeddedTest");
		System.out.println(fassade.lieferName(id));
		System.out.println(fassade.lieferErzeugungsDatum(id));
		
		EJB3StandaloneBootstrap.shutdown();
	}
}

/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package stateless.zinsrechner.ejb2;

import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

public class Client {

	public static void main(String[] args) throws Exception {
		InitialContext ctx = new InitialContext();
		ZinsrechnerEJB2SichtRemote rechner = ((ZinsrechnerEjb2SichtHome) PortableRemoteObject
				.narrow(ctx.lookup("ZinsrechnerEjb2Sicht/remoteHome"),
						ZinsrechnerEjb2SichtHome.class)).create();
		System.out.println(rechner.berechneSparSumme(24000, 5, 0.03));
	}

}

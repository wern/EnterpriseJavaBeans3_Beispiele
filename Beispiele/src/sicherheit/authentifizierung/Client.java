/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package sicherheit.authentifizierung;

import javax.naming.InitialContext;

public class Client {

	public static void main(String[] args) throws Exception {
		Tor tor = (Tor) new InitialContext().lookup("Tor/remote");
		tor.klopfen();
		System.out.println("Die Ausgabe steht im Server-Log.");
	}

}

/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package stateless.zinsdienst;

import javax.naming.InitialContext;

public class Client {

	public static void main(String[] args) throws Exception{
	      InitialContext ctx = new InitialContext();
	      ZinsrechnerMitZinssatz rechner = (ZinsrechnerMitZinssatz) ctx.lookup("ZinsrechnerMitZinsdienst/remote");
	      System.out.println(rechner.berechneSparSumme(24000, 5));
	}

}

/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package stateful.warenkorb;

import javax.naming.InitialContext;

public class Client {

	public static void main(String[] args) throws Exception{
	      InitialContext ctx = new InitialContext();
	      Warenkorb korb = (Warenkorb) ctx.lookup("Warenkorb/remote");
	      korb.legeInWarenkorb(3, "0-24342-X", 2);
	      korb.legeInWarenkorb(1, "0-815-X", 1);
	      System.out.println("Kosten des Warenkorbs: "+korb.geheZurKasse());
	}

}

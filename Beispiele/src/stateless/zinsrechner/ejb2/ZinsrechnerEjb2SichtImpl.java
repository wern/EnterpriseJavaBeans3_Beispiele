/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package stateless.zinsrechner.ejb2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remote;
import javax.ejb.RemoteHome;
import javax.ejb.Stateless;

@Stateless(name = "ZinsrechnerEjb2Sicht")
@RemoteHome(value = ZinsrechnerEjb2SichtHome.class)
@Remote(value = ZinsrechnerEJB2SichtRemote.class)
public class ZinsrechnerEjb2SichtImpl {

	public int berechneSparSumme(int anlagebetrag, int jahre, double zinssatz) {
		return (int)(anlagebetrag * Math.pow((1 + zinssatz), jahre));
	}

	@PostConstruct
	public void erzeugt() {
		System.out.println("Ich wurde erzeugt.");
	}

	@PreDestroy
	public void beanEntfernt() {
		System.out.println("Ich werde entfernt.");
	}
}

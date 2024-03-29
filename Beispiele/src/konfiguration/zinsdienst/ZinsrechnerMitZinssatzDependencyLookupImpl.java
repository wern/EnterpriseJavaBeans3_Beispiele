/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package konfiguration.zinsdienst;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateless(name = "ZinsrechnerMitZinsdienstDependencyLookup")
@EJB(name = "ejb/Zinssatz/local", beanName = "ZinssatzDependencyLookup", beanInterface = Zinssatz.class)
public class ZinsrechnerMitZinssatzDependencyLookupImpl implements
		ZinsrechnerMitZinssatz {

	Zinssatz zinssatz;

	public int berechneSparSumme(int anlagebetrag, int jahre) {
		double zins = zinssatz.ermittleZinssatz(anlagebetrag, jahre);
		return (int) (anlagebetrag * Math.pow((1 + zins), jahre));
	}

	@PostConstruct
	public void erzeugt() {
		try {
			zinssatz = (Zinssatz) new InitialContext()
					.lookup("java:comp/env/ejb/Zinssatz/local");
			System.out.println("Ich wurde erzeugt. : " + zinssatz);
		} catch (NamingException e) {
			throw new EJBException(e);
		}
	}

	@PreDestroy
	public void beanEntfernt() {
		System.out.println("Ich werde entfernt.");
	}
}

/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package embedded;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name="Fassade")
public class TesteMichFassadeImpl implements TesteMichFassade {

	@EJB
	TesteMichArbeiter arbeiter;
	
	@PostConstruct
	public void start(){
		System.out.println("Ich werde gestartet...");
	}

	public int erzeugeEntity(String name) {
		return arbeiter.erzeugeEntity(new TesteMichEntity(name)).getId();
	}

	public String lieferName(int entitySchluessel) {
		TesteMichEntity entity = arbeiter.sucheEntity(entitySchluessel);
		if (entity != null) {
			return entity.getName();
		} else {
			return null;
		}
	}

	public Date lieferErzeugungsDatum(int entitySchluessel) {
		TesteMichEntity entity = arbeiter.sucheEntity(entitySchluessel);
		if (entity != null) {
			return entity.getErzeugungsDatum();
		} else {
			return null;
		}
	}
}

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

import javax.ejb.Remote;

@Remote
public interface TesteMichFassade {

	public abstract int erzeugeEntity(String name);

	public abstract String lieferName(int entitySchluessel);

	public abstract Date lieferErzeugungsDatum(int entitySchluessel);

}

/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package embedded;

import javax.ejb.Local;

@Local
public interface TesteMichArbeiter {

	public abstract TesteMichEntity erzeugeEntity(TesteMichEntity entity);

	public abstract TesteMichEntity sucheEntity(int id);

}

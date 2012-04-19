/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package stateless.zinsrechner.ejb3;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(value={ZinsrechnerOhneAnnotation.class})
@Stateless(name="ZinsrechnerMitAnnotation")
public class ZinsrechnerImplMitInterfaceAnnotation implements ZinsrechnerOhneAnnotation{
	public double berechneSparSumme(int anlagebetrag, int jahre, double zinssatz) {
		return anlagebetrag * Math.pow((1 + zinssatz), jahre);
	}
}

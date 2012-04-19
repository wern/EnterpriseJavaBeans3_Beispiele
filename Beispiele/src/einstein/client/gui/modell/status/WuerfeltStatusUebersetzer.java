/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package einstein.client.gui.modell.status;

import einstein.client.gui.modell.SpielbrettModell;
import einstein.server.oeffentlich.SpielStatus;

/**
 * Uebersetzt die Stati SpielStatus.A_WUERFELT und SpielStatus.B_WUERFELT.
 * 
 * @author <a href="mailto:info@jessicarubart.de">Jessica Rubart</a>
 */
public class WuerfeltStatusUebersetzer implements StatusUebersetzerInterface {
	protected final static String WUERFELT = "w�rfelt";

	public String uebersetzeStatus(SpielbrettModell modell) {
		if (modell.getStatus().equals(SpielStatus.A_WUERFELT.toString())) {
			return modell.getUserA() + " " + WUERFELT;
		} else if (modell.getStatus().equals(SpielStatus.B_WUERFELT.toString())) {
			return modell.getUserB() + " " + WUERFELT;
		}
		return null;
	}
}

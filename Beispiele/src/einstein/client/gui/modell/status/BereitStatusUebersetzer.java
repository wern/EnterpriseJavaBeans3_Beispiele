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
 * Uebersetzt die Stati SpielStatus.A_BEREIT und SpielStatus.B_BEREIT.
 * 
 * @author <a href="mailto:info@jessicarubart.de">Jessica Rubart</a>
 */
public class BereitStatusUebersetzer implements StatusUebersetzerInterface {
	protected final static String BEREIT = "ist bereit";

	public String uebersetzeStatus(SpielbrettModell modell) {
		if (modell.getStatus().equals(SpielStatus.A_BEREIT.toString())) {
			return modell.getUserA() + " " + BEREIT;
		} else if (modell.getStatus().equals(SpielStatus.B_BEREIT.toString())) {
			return modell.getUserB() + " " + BEREIT;
		}	
		return null;
	}	
}

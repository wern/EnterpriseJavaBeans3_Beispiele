/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package einstein.client.gui.modell.status;

import einstein.client.gui.modell.SpielbrettModell;

/**
 * Definiert eine Operation zum Uebersetzen des aktuellen SpielStatus,
 * so dass dieser angemessen in der GUI angezeigt werden kann.
 * 
 * @author <a href="mailto:info@jessicarubart.de">Jessica Rubart</a>
 */
public interface StatusUebersetzerInterface {

	/**
	 * Uebersetzt den aktuellen SpielStatus.
	 * 
	 * @param modell
	 * @return uebersetzten SpielStatus oder NULL (falls die Uebersetzer-Instanz
	 * den Status nicht behandeln konnte)
	 */
	public String uebersetzeStatus(SpielbrettModell modell);
}

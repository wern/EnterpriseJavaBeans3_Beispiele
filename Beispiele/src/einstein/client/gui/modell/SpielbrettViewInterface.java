/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package einstein.client.gui.modell;

import einstein.server.oeffentlich.SpielException;
import einstein.server.oeffentlich.SpielStatusException;

/**
 * Das Interface fuer eine View zu einem SpielbrettModell.
 * 
 * @author <a href="mailto:info@jessicarubart.de">Jessica Rubart</a>
 */
public interface SpielbrettViewInterface {

	/**
	 * Informiert den Benutzer darueber, dass er falsch gespielt hat.
	 * 
	 * @param e
	 */
	public void falschesSpiel(SpielException e);
	
	/**
	 * Informiert die Benutzerin darueber, dass ein falscher Status vorliegt.
	 * 
	 * @param e
	 */
	public void falscherStatus(SpielStatusException e);	

}

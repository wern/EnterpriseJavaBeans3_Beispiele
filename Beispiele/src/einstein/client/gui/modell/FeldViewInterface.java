/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package einstein.client.gui.modell;

import einstein.server.oeffentlich.SpielException;
import einstein.server.oeffentlich.SpielStatusException;

/**
 * Das Interface für eine View zu einem FeldModell.
 * 
 * @author <a href="mailto:info@jessicarubart.de">Jessica Rubart</a>
 */
public interface FeldViewInterface {
	
	/**
	 * Informiert den Benutzer darueber, dass er gemogelt hat.
	 */
	public void gemogelt();
	
	/**
	 * Informiert die Benutzerin darueber, dass sie falsch gespielt hat.
	 * 
	 * @param e
	 */
	public void falschesSpiel(SpielException e);
	
	/**
	 * Informiert den Benutzer darueber, dass ein falscher Status vorliegt.
	 * 
	 * @param e
	 */
	public void falscherStatus(SpielStatusException e);

}

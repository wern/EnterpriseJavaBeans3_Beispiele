/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package einstein.client.gui.modell.status;

import java.util.Vector;

/**
 * Factory-Klasse zur Erzeugung der StatusUebersetzerInterface-Instanzen.
 * 
 * @author <a href="mailto:info@jessicarubart.de">Jessica Rubart</a>
 */
public class StatusUebersetzerFactory {
	protected static Vector<StatusUebersetzerInterface> uebersetzer = null;

	public Vector getUebersetzer() {
		if (uebersetzer == null) {
			uebersetzer = new Vector<StatusUebersetzerInterface>();
			uebersetzer.add(new KeinSpielStatusUebersetzer());
			uebersetzer.add(new BereitStatusUebersetzer());
			uebersetzer.add(new WuerfeltStatusUebersetzer());
			uebersetzer.add(new AmZugStatusUebersetzer());
			uebersetzer.add(new AbgebrochenStatusUebersetzer());
			uebersetzer.add(new GewonnenStatusUebersetzer());
		}
		return uebersetzer;
	}
}

/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package einstein.server.intern;

import einstein.server.intern.entities.SpielerEntity;
import einstein.server.oeffentlich.SpielException;
import einstein.server.oeffentlich.SpielStand;
import einstein.server.oeffentlich.SpielStatus;
import einstein.server.oeffentlich.Zug;

/**  Enth�lt die Logik f�r die Teilnahme eines Spielers an einem Spieltisch
 * als Zuschauer. Alle Funktionen, die sich auf die aktive Teilnahme beziehen,
 * wie z.B. {@link #wuerfeln()} werfen bei Aufruf eine
 * {@link einstein.server.oeffentlich.SpielException}.
 * 
 * @author jlessner
 */
public class EinsteinZuschauerDelegate extends EinsteinDelegate {

	public EinsteinZuschauerDelegate(int pTischNr, String spielerName, EinsteinDAO dao)
		throws SpielException {
		super(pTischNr, spielerName, dao);
        SpielerEntity zuschauer = findeSpieler();
		zuschauer.setZuschauerAn(tisch);
	}

	public boolean verlassen() throws SpielException {
        SpielerEntity zuschauer = findeSpieler();
        zuschauer.setZuschauerAn(null);
        return dao.loescheLeerenTisch(tisch, spielerName);
	}

	public int wuerfeln() throws SpielException {
		throw new SpielException("Du bist nur Zuschauer");
	}

	public SpielStand ziehen(Zug pZug) throws SpielException {
		throw new SpielException("Du bist nur Zuschauer");
	}

	public SpielStatus bereit() throws SpielException {
		throw new SpielException("Du bist nur Zuschauer");
	}

}

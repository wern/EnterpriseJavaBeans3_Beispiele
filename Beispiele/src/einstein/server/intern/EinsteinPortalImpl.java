/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package einstein.server.intern;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import einstein.server.intern.entities.SpielerEntity;
import einstein.server.oeffentlich.EinsteinPortal;
import einstein.server.oeffentlich.Spieler;
import einstein.server.oeffentlich.VerwaltungsException;

/** Implementierung des Einstein-Portals als Stateless SessionBean.
 * Die Komponente st�tzt sich im Wesentlichen auf Funktionen des
 * {@link einstein.server.intern.EinsteinDAO} und wirkt als Fassade.
 * 
 * @author jlessner
 *
 */
@Stateless public class EinsteinPortalImpl implements EinsteinPortal {

	@EJB EinsteinDAO dao;
	
	public List<Spieler> anwesendeSpieler() {
        return dao.findeAnwesendeSpieler();
	}

	public List<Spieler> bestenListe() {
        return dao.findeBesteSpieler();
	}

	public void kuendigen(String name, String passwort) throws VerwaltungsException {
		if (!dao.spielerLoeschen(name, passwort))
			throw new VerwaltungsException("Spielername oder Passwort falsch");
	}

	public void registrieren(String name, String passwort)
		throws VerwaltungsException {
		SpielerEntity spieler = dao.findeSpieler(name);
		if (spieler != null)
			throw new VerwaltungsException("Spieler " + name + " gibt es schon");
		dao.spielerAnlegen(name, passwort);
	}

}

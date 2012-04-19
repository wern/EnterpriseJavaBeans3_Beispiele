/**********************************************************
 * Begleitmaterial zum Buch "Enterprise JavaBeans 3"
 * Das EJB3-Praxisbuch f�r Ein- und Umsteiger
 * Von Werner Eberling und Jan Le�ner
 * Hanser Fachbuchverlag M�nchen, 2007
 * http://www.hanser.de/buch.asp?isbn=3-446-41085-6
 * Feedback an ejb3buch@werner-eberling.de
 **********************************************************/
package einstein.server.oeffentlich;
import java.util.List;
import javax.ejb.Remote;


/** Interface der Einstein-Portal-EJB mit den Grundfunktionen zur
 * Benutzerregistration und �bersicht �ber die anwesenden Spieler.
 */
@Remote public interface EinsteinPortal {
	void registrieren(String spielerName, String passwort) throws VerwaltungsException;
	void kuendigen(String spielerName, String passwort) throws VerwaltungsException;
	
	List<Spieler> anwesendeSpieler();
	List<Spieler> bestenListe();
	
}

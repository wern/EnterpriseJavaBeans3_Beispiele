/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class KundenDAOImpl implements KundenDAO {

	private @PersistenceContext EntityManager em;
	
	public int erzeugeKunde(String vorname, String nachname) {
		Kunde kunde = new Kunde();
		kunde.setVorname(vorname);
        kunde.setNachname(nachname);
		em.persist(kunde);
		return kunde.getId();
	}
	
	public Kunde findeKunde(int id) {
		return em.find(Kunde.class, id);
	}
    
    public Kunde aktualisiereKunde(int id, String vorname, String nachname) {
        Kunde kunde = findeKunde(id);
        if (kunde != null) {
            kunde.setVorname(vorname);
            kunde.setNachname(nachname);
        }
        return kunde;
    }
}

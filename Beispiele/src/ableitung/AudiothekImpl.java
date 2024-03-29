/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package ableitung;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/** Implementierung einer Audiothek zur Anlage und Suche von
    Tontr�gern. Die Suche erfolgt vollst�ndig generisch */
@Stateless public class AudiothekImpl implements Audiothek {
    @PersistenceContext EntityManager em;
    
    public TonTraeger finde(int id) {
        return em.find(TonTraeger.class, id);
    }
    
    public TonTraeger anlegen(TonTraeger tonTraeger) {
        em.persist(tonTraeger);
        return tonTraeger;
    }
}

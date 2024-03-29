/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package beziehungen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity public class Mitarbeiter implements Serializable {
    @Id @GeneratedValue private int personalNr;
    private Bereich bereich;
    private BigDecimal einkommen;
    
    @ManyToMany private Set<Projekt> projekte;

    public static enum Bereich {
        EINKAUF, PRODUKTION, VERTRIEB, VERWALTUNG
    }
    
    public int getPersonalNr() { return personalNr; }
    public Set<Projekt> getProjekte() { return projekte; }
    public BigDecimal getEinkommen() { return einkommen; }
    public Bereich getBereich() { return bereich; }

    public void setProjekte(Set<Projekt> p) { projekte = p; }
    public void setEinkommen(BigDecimal p) { einkommen = p; }
    public void setBereich(Bereich p) { bereich = p; }
    
    public Mitarbeiter() {}
    public Mitarbeiter(Bereich bereich, int einkommen) {
        setBereich(bereich);
        setEinkommen(new BigDecimal(einkommen).setScale(2));
        setProjekte(new HashSet<Projekt>());
    }
}

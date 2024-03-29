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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity public class Bestellung implements Serializable {
    @Id @GeneratedValue private int bestellNr;
    private Date bestelltAm;
    
    @OneToMany(mappedBy="kopf", cascade={CascadeType.ALL})
    private Set<Bestellposition> positionen;

    public int getBestellNr() { return bestellNr; }
    public Date getBestelltAm() { return bestelltAm; }
    public void setBestelltAm(Date p) { bestelltAm = p; }
    public Set<Bestellposition> getPositionen() {
        return positionen;
    }
    public void setPositionen(Set<Bestellposition> positionen) {
        this.positionen = positionen;
    }
    
    public void hinzufuegen(Bestellposition p) {
        if (positionen == null)
            positionen = new HashSet<Bestellposition>();
        positionen.add(p);
        p.setKopf(this);
    }

}

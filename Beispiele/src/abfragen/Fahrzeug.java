/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package abfragen;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQuery(name="alleFahrzeuge", query="SELECT f FROM Fahrzeug f")
@NamedNativeQuery(name="alleFahrzeugeSQL",
        query="SELECT * FROM FAHRZEUG",
        resultClass=Fahrzeug.class)
@Entity public class Fahrzeug implements Serializable {
    @Id private String kennzeichen;
    private String modell;
    private int baujahr;
    @ManyToOne private Station standort;
    @OneToMany(mappedBy="mit") private Set<Fahrt> fahrten; 
    
    public Fahrzeug(String kennzeichen, String modell, int baujahr) {
        this.kennzeichen = kennzeichen;
        this.modell = modell;
        this.baujahr = baujahr;
        this.fahrten = new HashSet<Fahrt>();
    }
    public Fahrzeug() {}
    public void setStandort(Station p) { standort = p; }
    public void addFahrt(Fahrt f) { fahrten.add(f); }

    public int getBaujahr() { return baujahr; }
    public String getKennzeichen() { return kennzeichen; }
    public String getModell() { return modell; }
    public Station getStandort() { return standort; }
    
}

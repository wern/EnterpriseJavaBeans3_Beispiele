/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package transaktionen;

import java.io.Serializable;

import javax.persistence.*;

@Table(uniqueConstraints =
    @UniqueConstraint(columnNames={"adresse", "menge"})) // f�r Tests!!
@Entity public class Lieferauftrag implements Serializable {
    @Id @GeneratedValue private int nr;
    private String adresse;
    @ManyToOne private Produkt produkt;
    private int menge;

    public Lieferauftrag() {}
    public Lieferauftrag(int menge, String adresse) {
        this.menge = menge;
        this.adresse = adresse;
    }
    public String getAdresse() { return adresse; }
    public int getMenge() { return menge; }
    public int getNr() { return nr; }
    public Produkt getProdukt() { return produkt; }
    public void setProdukt(Produkt p) { produkt = p; }
}

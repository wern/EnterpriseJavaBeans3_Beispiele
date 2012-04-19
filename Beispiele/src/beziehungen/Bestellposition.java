/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package beziehungen;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

@Entity public class Bestellposition implements Serializable {
    @Id @GeneratedValue private int nr;
    private String artikel;
    private int anzahl;
    private BigDecimal preis;

    @ManyToOne(optional=false) private Bestellung kopf;

    public Bestellposition() {}
    public Bestellposition(String artikel, int anzahl, BigDecimal preis) {
        this.artikel = artikel;
        this.anzahl = anzahl;
        this.preis = preis;
    }
    
    public int getNr() { return nr; }
    public int getAnzahl() { return anzahl; }
    public String getArtikel() { return artikel; }
    public BigDecimal getPreis() { return preis; }
    public Bestellung getKopf() { return kopf; }

    public void setAnzahl(int p) { anzahl = p; }
    public void setArtikel(String p) { artikel = p; }
    public void setPreis(BigDecimal p) { preis = p; }
    public void setKopf(Bestellung p) { kopf = p; }
}

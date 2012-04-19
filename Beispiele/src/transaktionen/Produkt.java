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

@Entity public class Produkt implements Serializable {
    @Id String name;
    private int bestand;

    public Produkt() {}
    public Produkt(String name, int bestand) {
        this.name = name;
        this.bestand = bestand;
    }
    public String getName() { return name; }
    public int getBestand() { return bestand; }
    public void reduziereBestand(int p) { bestand -= p; }
}

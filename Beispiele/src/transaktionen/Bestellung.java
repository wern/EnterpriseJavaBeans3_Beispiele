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

public class Bestellung implements Serializable {
    private int menge;
    private String produktName, adresse;
    
    public Bestellung(String produktName, String mengeStr, String adresse) {
        this.produktName = produktName;
        this.menge = Integer.parseInt(mengeStr);
        this.adresse = adresse;
    }
    
    public Bestellung(String produktName, String adresse) {
        this(produktName, "1", adresse);
    }

    public String getAdresse() { return adresse; }
    public int getMenge() { return menge; }
    public String getProduktName() { return produktName; }
}

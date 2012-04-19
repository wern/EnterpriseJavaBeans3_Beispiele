/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package beziehungen;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity public class Versammlung {
    @Id @GeneratedValue private int id;
    private Date zeit;
    String anlass;
    int anzahlTeilnehmer;

    @ManyToOne private Firma veranstalter;

    public int getId() { return id; }
    public String getAnlass() { return anlass; }
    public int getAnzahlTeilnehmer() { return anzahlTeilnehmer; }
    public Firma getVeranstalter() { return veranstalter; }
    public Date getZeit() { return zeit; }

    public void setAnlass(String p) { anlass = p; }
    public void setAnzahlTeilnehmer(int p) { anzahlTeilnehmer = p; }
    public void setVeranstalter(Firma p) { veranstalter = p; }
    public void setZeit(Date p) { zeit = p; }
    
    public Versammlung() {}
    public Versammlung(String anlass, int anzahlTeilnehmer, Firma veranstalter) {
        setAnlass(anlass);
        setAnzahlTeilnehmer(anzahlTeilnehmer);
        setVeranstalter(veranstalter);
        setZeit(new Date());
    }
}

/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package ableitung;

import java.io.Serializable;

import javax.persistence.*;

/** Abstrakte Basisklasse für alle Arten von Tonträgern.
    Nur der Titel steht als Attribut fest. Gesamtspieldauer und
    Anzahl der Songs sind noch offen */
@Entity
public abstract class TonTraeger implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.TABLE)
    @Column(updatable=false)
    private int nr;
    
    @Basic(optional=false)
    private String titel;
    
    protected TonTraeger(String titel) { this.titel = titel; }
    public TonTraeger() {} /* wird vom Persistence-Provider benötigt */
    
    public int getNr() { return nr; }
    public String getTitel() { return titel; }
    
    abstract int getSpieldauer();
    abstract int getAnzahlTracks();
}

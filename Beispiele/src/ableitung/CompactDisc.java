/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package ableitung;

import javax.persistence.Entity;

/** Konkrete Klasse zur Repräsentation einer CD. Spieldauer und
    Anzahl der Songs sind Attribute. */
@Entity public class CompactDisc extends TonTraeger {
    int spieldauer;
    int anzahlTracks;
    
    public CompactDisc(String titel, int spieldauer, int anzahlTracks) {
        super(titel);
        this.spieldauer = spieldauer;
        this.anzahlTracks = anzahlTracks;
    }
    
    public CompactDisc() {} /* wird vom Persistence-Provider benötigt */
    
    public int getSpieldauer() { return spieldauer; }
    public int getAnzahlTracks() { return anzahlTracks; }
}

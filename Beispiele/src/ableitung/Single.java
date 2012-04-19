/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package ableitung;

import javax.persistence.Entity;

/** Konkrete Klasse zur Abbildung einer Single-Schallplatte. Hier wird
    angenommen, dass die Anzahl der Titel genau 2 ist, einer auf der A-
    und einer auf der B-Seite. */
@Entity public class Single extends Schallplatte {

    int getAnzahlTracks() { return 2; }

    public Single(String titel, int spieldauerA, int spieldauerB) {
        super(titel, spieldauerA, spieldauerB);
    }

    public Single() {} /* Wird vom Persistence-Provider ben�tigt */
   
}

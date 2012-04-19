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

/** Werteklasse für die Selektion der Bauhjahresspanne aller Fahrzeuge */
public class BaujahrSpanne implements Serializable {
    private int min, max;
    
    public BaujahrSpanne(int max, int min) {
        this.max = max;
        this.min = min;
    }
    public BaujahrSpanne() {}

    public int getMax() { return max; }
    public int getMin() { return min; }

    @Override
    public String toString() { return min + "..." + max; }
    
}

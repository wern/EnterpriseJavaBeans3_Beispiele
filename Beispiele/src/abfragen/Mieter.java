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

import javax.persistence.*;

@Entity public class Mieter implements Serializable {
    @Id @GeneratedValue @Column(updatable=false)
    private int kundenNr;
    private String name;
    
    public Mieter(String name) { this.name = name; }
    public Mieter() {}
    public int getKundenNr() { return kundenNr; }
    public String getName() { return name; }
    public void setName(String p) { name = p; }
}

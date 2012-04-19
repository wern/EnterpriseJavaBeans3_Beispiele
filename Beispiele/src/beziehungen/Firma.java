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
import java.util.Collection;

import javax.persistence.*;

@Entity public class Firma implements Serializable {
    @Id private String handelsregisterNr;
    private String name;

    @OneToMany(cascade={CascadeType.REMOVE})
    private Collection<Adresse> anschriften;
    
    @OneToMany(cascade={CascadeType.REMOVE})
    @JoinTable(name="FIRMA_ALTEANSCHRIFTEN")
    private Collection<Adresse> alteAnschriften;
    
    @OneToOne private Adresse hauptsitz;

    public String getHandelsregisterNr() { return handelsregisterNr; }
    public String getName() { return name; }
    public Adresse getHauptsitz() { return hauptsitz; }
    public Collection<Adresse> getAnschriften() { return anschriften; }
    public Collection<Adresse> getAlteAnschriften() {
        return alteAnschriften;
    }

    public void setHauptsitz(Adresse p) { hauptsitz = p; }
    public void setName(String p) { name = p; }
    public void setHandelsregisterNr(String p) { handelsregisterNr = p; }
    public void setAnschriften(Collection<Adresse> p) {
        anschriften = p;
    }
    public void setAlteAnschriften(Collection<Adresse> p) {
        alteAnschriften = p;
    }

}

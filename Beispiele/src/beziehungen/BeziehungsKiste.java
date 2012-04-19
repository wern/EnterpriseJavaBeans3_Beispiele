/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package beziehungen;

import javax.ejb.Remote;

@Remote public interface BeziehungsKiste {
    public int erzeugeBestellung();
    public int erzeugeRechner();
    public int erzeugePerson();
    public String erzeugeFirma();
    public int erzeugeVersammlung();
    public int erzeugeMitarbeiter();
    public String erzeugeKonferenz();
}

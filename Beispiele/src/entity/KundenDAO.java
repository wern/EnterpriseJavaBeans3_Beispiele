/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package entity;

@javax.ejb.Remote
public interface KundenDAO {
	public int erzeugeKunde(String vorname, String nachname);
	public Kunde findeKunde(int id);
    public Kunde aktualisiereKunde(int id, String vorname, String nachname);
}

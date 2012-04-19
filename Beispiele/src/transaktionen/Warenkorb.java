/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package transaktionen;

import javax.ejb.Remote;

@Remote
public interface Warenkorb {
	public void legeInWarenkorb(String produktName);
	public void entferneAusWarenkorb(String produktName);
    public int anzahlProdukte();
	public int bestellen(String adresse) throws ShopException;
}

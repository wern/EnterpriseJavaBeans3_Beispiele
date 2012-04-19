/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package transaktionen;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.EJB;
import javax.ejb.SessionSynchronization;
import javax.ejb.Stateful;

@Stateful(name="Warenkorb")
public class WarenkorbImpl implements Warenkorb, SessionSynchronization {
    
    @EJB private Shop shop; // Referenz zur Shop-EJB (�ber Dependency Injaction)
    private Map<String, Integer> waren = new HashMap<String, Integer>(); // Inhalt des Korbs
    private Map<String, Integer> backup; // F�r Wiederherstellung des Inhalts nach Rollback

    public void entferneAusWarenkorb(String produktName) {
        waren.remove(produktName);
    }
    
    public void legeInWarenkorb(String produktName) {
        Integer anzahlImKorb = waren.get(produktName);
        waren.put(produktName, (anzahlImKorb == null) ? 1 : anzahlImKorb + 1);
    }
    
    public int anzahlProdukte() { return waren.size(); }

    protected int erzeugeLieferauftraege(String adresse) throws ShopException {
        int letzterLieferauftrag = 0;
        for (Entry<String, Integer> entry: waren.entrySet())
            letzterLieferauftrag = shop.bestellen(entry.getKey(), entry.getValue(), adresse);
        backup = waren;
        waren = new HashMap<String, Integer>();
        return letzterLieferauftrag;
    }
    
    protected void produziereRechnung(String adresse) throws ShopException {
        if (adresse.length() < 2)
            throw new ShopException("Rechnungsadresse ist fehlerhaft");
    }
    
    public int bestellen(String adresse) throws ShopException {
        int ergebnis = erzeugeLieferauftraege(adresse);
        produziereRechnung(adresse);
        return ergebnis;
    }

    /********** Implementierung von SessionSynchronization **************/

    public void afterBegin() {}
    public void beforeCompletion() {}

    public void afterCompletion(boolean commit) {
        if (!commit && backup != null) {
            waren = backup;
            backup = null;
        }
    }

}

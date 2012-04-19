/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package transaktionen;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.*;

@TransactionManagement(TransactionManagementType.CONTAINER)
@Stateless public class ShopImpl implements Shop {

    @PersistenceContext EntityManager em;
    @Resource SessionContext sc;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int bestellen(String produktName, int menge, String adresse)
        throws ShopException {
        // Lieferauftrag erzeugen
        Lieferauftrag auftrag = new Lieferauftrag(menge, adresse);
        em.persist(auftrag);
        
        // Produkt suchen und im Auftrag referenzieren
        Produkt p = em.find(Produkt.class, produktName);
        if (p == null)
            throw new ShopException("Produkt " + produktName + " nicht gefunden");
        auftrag.setProdukt(p);
        
        // Bestand reduzieren
        p.reduziereBestand(auftrag.getMenge());
        if (p.getBestand() < 0)
            throw new ShopException("Bestand von " + produktName + " nicht ausreichend");

        return auftrag.getNr();
    }
    
    public void beispielDatenAnlegen() {
        em.persist(new Produkt("hemd", 50));
        em.persist(new Produkt("hose", 100));
    }
}

/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package konfiguration.warenkorb;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful(name = "WarenkorbMitMindestwert")
public class WarenkorbImpl implements Warenkorb {

	class Ware {
		int anzahl;

		int einzelpreis;

		String artikelnummer;

		public Ware(int anzahl, int einzelpreis, String artikelnummer) {
			super();
			this.anzahl = anzahl;
			this.einzelpreis = einzelpreis;
			this.artikelnummer = artikelnummer != null ? artikelnummer : "";
		}

		public int getGesamtpreis() {
			return anzahl * einzelpreis;
		}
	}

	@Resource
	private long mindestwert = 10;

	private Map<String, Ware> waren = new HashMap<String, Ware>();

	public void entferneAusWarenkorb(String artikelnummer) {
		waren.remove(artikelnummer);
	}

	public void legeInWarenkorb(int anzahl, String artikelnummer,
			int einzelpreis) {
		waren.put(artikelnummer, new Ware(anzahl, einzelpreis, artikelnummer));
	}

	@Remove
	public int geheZurKasse() throws BestellwertZuNiedrigException {
		int gesamtpreis = 0;
		for (Ware ware : waren.values()) {
			gesamtpreis += ware.getGesamtpreis();
		}
		if (gesamtpreis < mindestwert) {
			throw new BestellwertZuNiedrigException(gesamtpreis + " < "
					+ mindestwert);
		}
		return gesamtpreis;
	}

	@PostConstruct
	public void erzeugt() {
		System.out.println("Ich wurde erzeugt.");
	}

	@PreDestroy
	public void beanEntfernt() {
		System.out.println("Ich werde entfernt.");
	}

	@PrePassivate
	public void schlafenGehen() {
		System.out.println("Ich wurde passiviert.");
	}

	@PostActivate
	public void wiederErwachen() {
		System.out.println("Ich werde aktiviert.");
	}
}

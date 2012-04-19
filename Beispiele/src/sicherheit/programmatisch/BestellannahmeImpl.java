/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package sicherheit.programmatisch;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name = "Bestellannahme")
@DeclareRoles("bestandskunde")
public class BestellannahmeImpl implements Bestellannahme {

	@Resource
	SessionContext ctx;

	public String bestellungPerNachnahme() {
		return "Bestellung per Nachnahme wird akzeptiert.";
	}

	public String bestellungPerRechnung() {
		if (ctx.isCallerInRole("bestandskunde")) {
			return "Bestellung per Rechnung wird akzeptiert.";
		} else {
			return "Bestellung per Rechnung wird leider NICHT akzeptiert.";
		}
	}
}

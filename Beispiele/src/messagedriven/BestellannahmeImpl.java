/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package messagedriven;

import java.util.Enumeration;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(
		name = "Bestellannahme", 
		activationConfig = {
		@ActivationConfigProperty(
				propertyName = "destinationType", 
				propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(
				propertyName = "destination", 
				propertyValue = "queue/A") })
public class BestellannahmeImpl implements MessageListener {
	public void onMessage(Message nachricht) {
		try {
			MapMessage map = (MapMessage) nachricht;
			Enumeration<String> artikelnummern = map.getMapNames();
			while (artikelnummern.hasMoreElements()) {
				String artikelnummer = artikelnummern.nextElement();
				System.out.println(artikelnummer + ": "
						+ map.getInt(artikelnummer) + "Stück");
			}
		} catch (JMSException e) {
			throw new EJBException(e);
		}
	}
}

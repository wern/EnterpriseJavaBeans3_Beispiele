/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package messagedriven;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

public class Client {
	public static void main(String[] args) throws Exception {
		InitialContext initialContext = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) initialContext
				.lookup("QueueConnectionFactory");
		Connection connection = factory.createConnection();
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		connection.start();

		MapMessage nachricht = session.createMapMessage();
		nachricht.setStringProperty("Bestellungstyp", "Internet");
		nachricht.setInt("0-24235-X", 5);
		nachricht.setInt("0-28543-X", 1);
		nachricht.setInt("0-23425-2", 3);

		Destination ziel = (Destination) initialContext.lookup("queue/A");
		MessageProducer sender = session.createProducer(ziel);
		System.out.println("Sende Nachricht...");
		sender.send(nachricht);
		connection.stop();
		session.close();
		connection.close();
	}
}

/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class EmpfaengerAsynchron implements MessageListener{
	public static void main(String[] args) throws Exception {
		InitialContext initialContext = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) initialContext
				.lookup("QueueConnectionFactory");
		Connection connection = factory.createConnection();
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		connection.start();

		Destination postfach = (Destination) initialContext.lookup("queue/A");
		MessageConsumer empfaenger = session.createConsumer(postfach, "Bestellungstyp = 'Internet'");
		empfaenger.setMessageListener(new EmpfaengerAsynchron());
		System.out.println("Warte auf Nachrichten... (Beenden mit CTRL-C)");
	}

	public void onMessage(Message nachricht) {
		try {
			System.out.println("Nachricht empfangen!");
			System.out.println(((TextMessage) nachricht).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}	
	}
}

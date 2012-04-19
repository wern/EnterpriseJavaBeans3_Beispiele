/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package einstein.server.intern.computergegner;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import einstein.server.oeffentlich.SpielException;

/**
 * Hilfsklasse zum Senden und Emfangen von Aufforderungen an Computergegner,
 * den nächsten Zug zu machen. Die Benachrichtigungen erfolgen in Form von
 * MapMasseges, die als einziges Attribut die Nummer des Spieltischs enthalten,
 * an dem ein Computerzug ansteht.
 * 
 * @author less02
 *
 */
public class JMSHelfer {
    private static final String TISCHNR_ATTRIBUT = "tischNr";
    static final String QUEUE_NAME = "queue/A";

    public static int leseTischNr(Message nachricht) throws SpielException {
        try {
            MapMessage map = (MapMessage) nachricht;
            return map.getInt(TISCHNR_ATTRIBUT);
        }
        catch(JMSException jmsx) {
            throw new SpielException(jmsx);
        }
    }

    public static void sendeTischNr(int tischNr) throws SpielException {
        try {
            InitialContext initialContext = new InitialContext();
            ConnectionFactory factory = (ConnectionFactory) initialContext
                    .lookup("QueueConnectionFactory");
            Connection connection = factory.createConnection();
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
    
            MapMessage nachricht = session.createMapMessage();
            nachricht.setInt(TISCHNR_ATTRIBUT, tischNr);
    
            Destination ziel = (Destination) initialContext.lookup(QUEUE_NAME);
            MessageProducer sender = session.createProducer(ziel);
            sender.send(nachricht);
            session.close();
            connection.close();
        }
        catch(NamingException nx) {
            throw new SpielException(nx);
        }
        catch(JMSException jmsx) {
            throw new SpielException(jmsx);
        }
        
    }
    
}

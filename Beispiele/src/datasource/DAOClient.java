/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package datasource;
import java.util.Properties;

import javax.naming.InitialContext;

public class DAOClient {
	public static void main(String[] args) throws Exception {
		InitialContext context = new InitialContext();
		DAO dao = (DAO)context.lookup("DAOImpl/remote");
		System.out.println(dao.zaehleTimer());
	}
}

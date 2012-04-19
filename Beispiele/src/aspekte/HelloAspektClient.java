/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package aspekte;

import javax.naming.InitialContext;

public class HelloAspektClient {
	public static void main(String[] args) throws Exception {
		InitialContext context = new InitialContext();
		HelloAspekt hello = (HelloAspekt)context.lookup("HelloAspektImpl/remote");
		System.out.println(hello.hello("Aspekt"));
        System.out.println(hello.leer("Aspekt"));
        System.out.println(hello.leer(null));
	}
}

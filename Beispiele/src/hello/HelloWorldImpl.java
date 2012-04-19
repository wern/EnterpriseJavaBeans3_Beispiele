/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package hello;

@javax.ejb.Stateless
public class HelloWorldImpl implements HelloWorld {
	
    public String hello(String who) {
    	System.out.println("Say hello to " + who);
        return "Hello " + who;
    }
}


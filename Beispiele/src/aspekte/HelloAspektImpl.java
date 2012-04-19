/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package aspekte;

import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;

@Interceptors({ProtokollAspekt.class})
@Stateless public class HelloAspektImpl implements HelloAspekt {

    /* Methoden des Komponenteninterface' */
    @AufrufProtokoll(AufrufProtokollTyp.METHODE)
    public String hello(String who) { return "Hello " + who; }
    
    @AufrufProtokoll
    public boolean leer(String who) { return who.length() == 0; }
    
    /* Interceptor-Methode */
    @AroundInvoke public Object abfangen(InvocationContext ic) throws Exception {
        System.out.println(ic.getMethod().getName() + "() wird aufgerufen");
        return ic.proceed();
    }
}


/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch f�r Ein- und Umsteiger
* Von Werner Eberling und Jan Le�ner
* Hanser Fachbuchverlag M�nchen, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package stateless.zinsrechner.ejb3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.InvocationContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LifeCycleMonitor {
	Log log = LogFactory.getLog(LifeCycleMonitor.class);
	
	@PostConstruct
	public void beanErzeugt(InvocationContext ic){
		System.out.println("Es wurde eine Bean vom Typ "+ ic.getTarget().getClass().getName()+" erzeugt.");
	}
	
	@PreDestroy
	public void beanEntfernt(InvocationContext ic){
		System.out.println("Es wird eine Bean vom Typ "+ ic.getTarget().getClass().getName()+" entfernt.");
	}
}

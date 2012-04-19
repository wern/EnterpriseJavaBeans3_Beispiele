/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package stateless.zinsrechner.ejb3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless(name="Zinsrechner")
@Interceptors(value={LifeCycleMonitor.class})
public class ZinsrechnerImpl implements Zinsrechner{
	
	public int berechneSparSumme(int anlagebetrag, int jahre, double zinssatz) {
		return (int)(anlagebetrag * Math.pow((1 + zinssatz), jahre));
	}
	
	@PostConstruct
	public void erzeugt(){
		System.out.println("Ich wurde erzeugt.");
	}
	
	@PreDestroy
	public void beanEntfernt(){
		System.out.println("Ich werde entfernt.");
	}
}

/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package embedded;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "Arbeiter")
public class TesteMichArbeiterImpl implements TesteMichArbeiter {

	@PersistenceContext(name = "embedded")
	EntityManager em;

	public TesteMichEntity erzeugeEntity(TesteMichEntity entity) {
		em.persist(entity);
		return entity;
	}

	public TesteMichEntity sucheEntity(int id) {
		return em.find(TesteMichEntity.class, id);
	}
}

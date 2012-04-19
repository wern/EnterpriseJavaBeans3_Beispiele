/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package embedded;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TesteMichEntity implements Serializable {
	@Id
	@GeneratedValue
	int id;

	String name;

	@Column(updatable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	Date erzeugungsDatum;

	public TesteMichEntity() {
	}

	public TesteMichEntity(String name) {
		this.name = name;
		erzeugungsDatum = new Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getErzeugungsDatum() {
		return erzeugungsDatum;
	}

	public int getId() {
		return id;
	}

}

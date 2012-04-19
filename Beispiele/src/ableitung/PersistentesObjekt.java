/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package ableitung;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Beispiel für eine Basisklasse, die als Mapped-Superclass
 * Annotiert wird. Sie enthält eine ID-Definition, die unabhängig
 * von der fachlichen Bedeutung der abgeleiteten Entity-Klassen
 * applikationsweit einheitlich eingesetzt werden könnte.
 */
@MappedSuperclass
public abstract class PersistentesObjekt implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.TABLE)
    @Column(updatable=false) protected int nr;
}

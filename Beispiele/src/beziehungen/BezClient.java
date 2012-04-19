/**********************************************************
* Begleitmaterial zum Buch "Enterprise JavaBeans 3"
* Das EJB3-Praxisbuch für Ein- und Umsteiger
* Von Werner Eberling und Jan Leßner
* Hanser Fachbuchverlag München, 2007
* http://www.hanser.de/buch.asp?isbn=3-446-41085-6
* Feedback an ejb3buch@werner-eberling.de
**********************************************************/ 
package beziehungen;

import javax.naming.InitialContext;

public class BezClient {

    public static void main(String[] args) throws Exception {
        InitialContext context = new InitialContext();
        BeziehungsKiste kiste = (BeziehungsKiste)
            context.lookup("BeziehungsKisteImpl/remote");
        System.out.println(kiste.erzeugeRechner());
        System.out.println(kiste.erzeugePerson());
        System.out.println(kiste.erzeugeBestellung());
        System.out.println(kiste.erzeugeFirma());
        System.out.println(kiste.erzeugeVersammlung());
        System.out.println(kiste.erzeugeMitarbeiter());
        System.out.println(kiste.erzeugeKonferenz());
    }

}

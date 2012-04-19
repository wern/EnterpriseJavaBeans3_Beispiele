=======================================================
   Begleitmaterial zum Buch "Enterprise JavaBeans 3"
      Das EJB3-Praxisbuch f�r Ein- und Umsteiger
          Von Werner Eberling und Jan Le�ner
          Hanser Fachbuchverlag M�nchen, 2007
   http://www.hanser.de/buch.asp?isbn=3-446-41085-6
       Feedback an ejb3buch@werner-eberling.de
=======================================================

Das Verzeichnis src enth�lt die Quellcodes f�r die im
Buch besprochenen Beispiele. Die Packages auf oberster
Ebene (hello, jms, transaktionen etc.) bilden jeweils
ein eigenst�ndiges EJB-Modul, das auf einem EJB-3-
Application-Server deployed werden kann. Jedes Package
enth�lt ein Buildskript, um die Quellen zu �bersetzen,
das Modul zu bauen und auf einem JBoss-Server zu
deployen. Die Ausf�hrung der Buildskripte erfordert das
Build-Werkzeug Ant, mindestens in der Version 1.5. Es
werden folgende Ant-Targets unterst�tzt:

 - compile: Kompiliert die Quellen des Packages
 - jar: Baut das EJB-JAR
 - deploy: Deployed das EJB-JAR auf dem Server
 - run: F�hrt das zugeh�rige Client-Programm aus
 - undeploy: Entfernt das Modul vom Server
 - clean: Entfernt alle erzeugten Generate

Einige Clients unterst�tzen eine Reihe von Parametern.
Die in diesem Fall �ber das Buildskript wie folgt an
den Client weitergeleitet werden werden k�nnen:
   ant -Dmain.args="<Meine Parameter>" run

Zur korrekten Ausf�hrung der Buildskripte muss zun�chst
die Datei common.build.xml an die pers�nliche Arbeits-
umgebung angepasst werden. Im Normalfall reicht die
Angabe des Installationspfads des JBoss-Servers 4.0.5
in der Property jboss.home (Zeile 6). Grundvoraussetzung
ist die Installation einer Java-5-Entwicklungsumgebung.

F�r einige Beispiele sind im Buch zus�tzliche Informa-
tionen enthalten, die zum Verst�dnis notwendig sind.

=======================================================
   Begleitmaterial zum Buch "Enterprise JavaBeans 3"
      Das EJB3-Praxisbuch für Ein- und Umsteiger
          Von Werner Eberling und Jan Leßner
          Hanser Fachbuchverlag München, 2007
   http://www.hanser.de/buch.asp?isbn=3-446-41085-6
       Feedback an ejb3buch@werner-eberling.de
=======================================================

Das Verzeichnis src enthält die Quellcodes für die im
Buch besprochenen Beispiele. Die Packages auf oberster
Ebene (hello, jms, transaktionen etc.) bilden jeweils
ein eigenständiges EJB-Modul, das auf einem EJB-3-
Application-Server deployed werden kann. Jedes Package
enthält ein Buildskript, um die Quellen zu übersetzen,
das Modul zu bauen und auf einem JBoss-Server zu
deployen. Die Ausführung der Buildskripte erfordert das
Build-Werkzeug Ant, mindestens in der Version 1.5. Es
werden folgende Ant-Targets unterstützt:

 - compile: Kompiliert die Quellen des Packages
 - jar: Baut das EJB-JAR
 - deploy: Deployed das EJB-JAR auf dem Server
 - run: Führt das zugehörige Client-Programm aus
 - undeploy: Entfernt das Modul vom Server
 - clean: Entfernt alle erzeugten Generate

Einige Clients unterstützen eine Reihe von Parametern.
Die in diesem Fall über das Buildskript wie folgt an
den Client weitergeleitet werden werden können:
   ant -Dmain.args="<Meine Parameter>" run

Zur korrekten Ausführung der Buildskripte muss zunächst
die Datei common.build.xml an die persönliche Arbeits-
umgebung angepasst werden. Im Normalfall reicht die
Angabe des Installationspfads des JBoss-Servers 4.0.5
in der Property jboss.home (Zeile 6). Grundvoraussetzung
ist die Installation einer Java-5-Entwicklungsumgebung.

Für einige Beispiele sind im Buch zusätzliche Informa-
tionen enthalten, die zum Verstädnis notwendig sind.

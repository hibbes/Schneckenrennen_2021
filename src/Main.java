/**
 * Startet eine Rennsimulation mit zwei Schnecken und gibt den Sieger aus.
 *
 * <p>Demonstriert das Zusammenspiel der Klassen {@link Rennschnecke},
 * {@link Rennen} und die Verwendung von {@link Rennen#durchfuehren()} mit
 * automatischer Schleife bis zum Ziel.</p>
 *
 * @author hibbes
 */
public class Main {

    /**
     * @param args Kommandozeilenargumente (nicht verwendet)
     */
    public static void main(String[] args) {

        // Zwei Schnecken mit gleicher Höchstgeschwindigkeit → fairer Wettbewerb
        Rennschnecke Alfred  = new Rennschnecke("Alfred",  "Weinschnecke", 2.1);
        Rennschnecke Barbara = new Rennschnecke("Barbara", "Seeschnecke",  2.1);

        // Rennen "SchneckenGP" mit Streckenlänge 7 Einheiten
        Rennen SchneckenGP = new Rennen("SchneckenGP", 7);
        SchneckenGP.addRennschnecke(Alfred);
        SchneckenGP.addRennschnecke(Barbara);

        // Rennen starten: läuft automatisch bis eine Schnecke die Ziellinie erreicht
        SchneckenGP.durchfuehren();

        // Sieger ausgeben
        System.out.println("Sieger: " + SchneckenGP.ermittleGewinner());
    }
}

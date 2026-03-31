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

        // Rennen "Schillerrace" mit Streckenlänge 7 Einheiten
        Rennen Schillerrace = new Rennen("Schillerrace", 7);
        Schillerrace.addRennschnecke(Alfred);
        Schillerrace.addRennschnecke(Barbara);

        // Rennen starten: läuft automatisch bis eine Schnecke die Ziellinie erreicht
        Schillerrace.durchfuehren();

        // Sieger ausgeben
        System.out.println("Sieger: " + Schillerrace.ermittleGewinner());
    }
}

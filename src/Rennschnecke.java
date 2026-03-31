/**
 * Modelliert eine Rennschnecke mit Name, Rasse und Geschwindigkeit.
 *
 * <p>Verbesserte Version gegenüber {@code Schneckenrennen}: Die Geschwindigkeit
 * ist jetzt {@code double} (Fließkommazahl) statt {@code int}, was realistischere
 * Zufallswerte ermöglicht. {@code Math.random()} liefert direkt einen double.</p>
 *
 * @author hibbes
 * @see Rennen
 */
public class Rennschnecke {

    /** Rufname der Schnecke. */
    String name;

    /** Rassenbezeichnung. */
    String rasse;

    /** Maximale Schrittweite pro Runde (als Fließkommazahl für feinere Abstufungen). */
    double geschwindigkeit;

    /** Bisher zurückgelegte Gesamtstrecke. */
    double strecke = 0;

    /**
     * Erstellt eine neue Rennschnecke.
     *
     * @param name          Rufname
     * @param rasse         Rassezugehörigkeit
     * @param geschwindigkeit maximale Schrittweite pro Runde
     */
    public Rennschnecke(String name, String rasse, double geschwindigkeit) {
        this.name          = name;
        this.rasse         = rasse;
        this.geschwindigkeit = geschwindigkeit;
    }

    /**
     * Bewegt die Schnecke um eine zufällige Strecke vorwärts.
     *
     * <p>{@code Math.random()} liefert einen Wert in [0.0, 1.0).
     * Multipliziert mit {@code geschwindigkeit} ergibt sich ein
     * zufälliger Wert in [0.0, geschwindigkeit).</p>
     */
    public void kriechen() {
        strecke = strecke + (Math.random() * geschwindigkeit);
    }

    /**
     * @return Kurzinfo über den aktuellen Zustand der Schnecke
     */
    @Override
    public String toString() {
        return "Name: " + name
             + ", Rasse: " + rasse
             + ", Geschwindigkeit: " + geschwindigkeit
             + ", Gekrochene Strecke: " + String.format("%.2f", strecke);
    }
}

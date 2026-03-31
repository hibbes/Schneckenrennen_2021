/**
 * Repräsentiert eine einzelne Wette auf eine bestimmte Rennschnecke.
 *
 * <p>Ein Wette-Objekt speichert, wer ({@code spieler}) wie viel ({@code wettEinsatz})
 * auf welche Schnecke ({@code schnecke}) gewettet hat.</p>
 *
 * <p><b>OOP-Konzept:</b> Dieses "Daten-Objekt" (auch Value Object / DTO genannt)
 * hat keine eigene Logik – es speichert nur Zustand und gibt ihn über
 * {@link #toString()} aus.</p>
 *
 * @author hibbes
 * @see Wettbuero
 */
public class Wette {

    /** Die Schnecke, auf die gewettet wurde. */
    Rennschnecke schnecke;

    /** Der Geldbetrag, der eingesetzt wurde. */
    double wettEinsatz;

    /** Name des Wettenden. */
    String spieler;

    /**
     * Erstellt eine neue Wette.
     *
     * @param schnecke   die Schnecke, auf die gewettet wird
     * @param wettEinsatz eingesetzter Betrag (in beliebiger Währungseinheit)
     * @param spieler    Name des Wettenden
     */
    public Wette(Rennschnecke schnecke, double wettEinsatz, String spieler) {
        this.schnecke    = schnecke;
        this.wettEinsatz = wettEinsatz;
        this.spieler     = spieler;
    }

    /** @return Kurzbeschreibung der Wette */
    @Override
    public String toString() {
        return spieler + " setzt " + wettEinsatz + " auf " + schnecke.name;
    }
}

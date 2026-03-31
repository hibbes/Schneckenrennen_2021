import java.util.ArrayList;
import java.util.Iterator;

/**
 * Verwaltet ein vollständiges Schneckenrennen: Anmeldung, Renndurchführung
 * und Gewinnermittlung.
 *
 * <p>Verbesserungen gegenüber der Basisversion ({@code Schneckenrennen}):
 * <ul>
 *   <li>{@link #durchfuehren()}: Schleife bis eine Schnecke die Ziellinie überschreitet</li>
 *   <li>{@link #ermittleGewinner()}: sucht die erste Schnecke über der Ziellinie</li>
 *   <li>Duplikat-Prüfung in {@link #addRennschnecke(Rennschnecke)}</li>
 * </ul>
 * </p>
 *
 * @author hibbes
 * @see Rennschnecke
 */
public class Rennen {

    /** Name des Rennens. */
    String name;

    /** Gezählte Teilnehmerzahl (wird aktuell nicht automatisch aktualisiert). */
    int teilnehmerzahl;

    /** Angemeldete Rennschnecken. */
    ArrayList<Rennschnecke> Schnecken;

    /** Streckenlänge in beliebigen Einheiten. */
    double streckenlaenge;

    /**
     * Erstellt ein neues Rennen mit leerer Teilnehmerliste.
     *
     * @param name           Name des Rennens
     * @param streckenlaenge Zielentfernung in beliebigen Einheiten
     */
    public Rennen(String name, double streckenlaenge) {
        this.name           = name;
        this.streckenlaenge = streckenlaenge;
        this.Schnecken      = new ArrayList<Rennschnecke>();
    }

    /**
     * Meldet eine Schnecke an – Duplikate werden abgewiesen.
     *
     * <p>{@code contains()} prüft mit {@code equals()} – da hier die Standard-
     * Referenz-Gleichheit gilt, wird nur dasselbe Objekt erkannt (nicht ein
     * zweites Objekt mit gleichem Namen).</p>
     *
     * @param neueSchnecke anzumeldende Schnecke
     */
    public void addRennschnecke(Rennschnecke neueSchnecke) {
        if (this.Schnecken.contains(neueSchnecke)) {
            System.out.println("Diese Schnecke ist bereits angemeldet: " + neueSchnecke.name);
        } else {
            this.Schnecken.add(neueSchnecke);
        }
    }

    /**
     * Meldet eine Schnecke nach Namen ab.
     *
     * <p><b>Achtung:</b> Diese Implementierung kann eine
     * {@link java.util.ConcurrentModificationException} auslösen, weil die Liste
     * während der Iteration verändert wird. Korrekte Variante: Iterator verwenden
     * oder nach dem Finden des Elements mit {@code break} abbrechen.</p>
     *
     * <p>Korrekte Alternative:
     * <pre>
     *   Iterator&lt;Rennschnecke&gt; it = Schnecken.iterator();
     *   while (it.hasNext()) {
     *       if (it.next().name.equals(name)) { it.remove(); break; }
     *   }
     * </pre></p>
     *
     * @param name Rufname der abzumeldenden Schnecke
     */
    public void removeRennschnecke(String name) {
        for (Rennschnecke schnecke : Schnecken) {
            if (schnecke.name.equals(name)) {
                Schnecken.remove(schnecke);   // TODO: ConcurrentModificationException möglich!
            }
        }
    }

    /**
     * Lässt alle angemeldeten Schnecken eine Runde kriechen.
     * Wird von {@link #durchfuehren()} wiederholt aufgerufen.
     */
    public void lasseSchneckenKriechen() {
        for (Rennschnecke schnecke : Schnecken) {
            schnecke.kriechen();
        }
    }

    /**
     * Gibt den Namen und die Strecke der ersten Schnecke zurück, die die
     * Ziellinie erreicht oder überschritten hat.
     *
     * <p>Gibt {@code null} zurück, solange noch keine Schnecke angekommen ist.
     * Diese Methode wird von {@link #durchfuehren()} als Schleifenabbruchbedingung
     * verwendet.</p>
     *
     * @return Siegerbeschreibung oder {@code null}
     */
    public String ermittleGewinner() {
        for (Rennschnecke schnecke : Schnecken) {
            if (schnecke.strecke >= this.streckenlaenge) {
                return schnecke.name + ": " + String.format("%.2f", schnecke.strecke)
                     + " (Ziel: " + streckenlaenge + ")";
            }
        }
        return null;    // noch kein Gewinner
    }

    /**
     * Führt das Rennen durch: Schleife bis ein Gewinner feststeht.
     *
     * <p>Diese while-Schleife ist ein typisches Muster: Weitermachen
     * solange eine Bedingung gilt ({@code ermittleGewinner() == null}),
     * d. h. solange noch kein Gewinner gefunden wurde.</p>
     */
    public void durchfuehren() {
        while (this.ermittleGewinner() == null) {
            this.lasseSchneckenKriechen();   // alle Schnecken eine Runde weiter
        }
    }

    /** @return Beschreibung des Rennens mit allen Teilnehmern */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rennen: ").append(name)
          .append(", Strecke: ").append(streckenlaenge)
          .append("\nTeilnehmer:\n");
        for (Rennschnecke s : Schnecken) {
            sb.append("  ").append(s.toString()).append("\n");
        }
        return sb.toString();
    }
}

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
     * <p><b>Didaktik:</b> Eine frühere Version dieser Methode hat die Liste
     * per {@code for-each} durchlaufen und beim Treffer {@code Schnecken.remove(...)}
     * aufgerufen. Das führt zu einer {@link java.util.ConcurrentModificationException},
     * weil der for-each-Iterator erkennt, dass sich die Liste unter ihm
     * verändert hat. Die korrekte Lösung ist ein <b>expliziter Iterator</b>
     * mit der Methode {@link Iterator#remove()} – er weiß, dass er selbst
     * modifizieren darf.</p>
     *
     * @param name Rufname der abzumeldenden Schnecke
     * @return {@code true}, wenn eine Schnecke gefunden und entfernt wurde
     */
    public boolean removeRennschnecke(String name) {
        Iterator<Rennschnecke> it = Schnecken.iterator();
        while (it.hasNext()) {
            if (it.next().name.equals(name)) {
                it.remove();
                return true;
            }
        }
        return false;
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
     * Gibt die erste Schnecke zurück, die die Ziellinie erreicht oder
     * überschritten hat – oder {@code null}, wenn das Rennen noch läuft.
     *
     * <p>Diese Methode wird von {@link #durchfuehren()} als Schleifen­abbruch­bedingung
     * verwendet und vom {@link Wettbuero} zur Gewinn­auszahlung.</p>
     *
     * @return die Sieger-Schnecke oder {@code null}
     */
    public Rennschnecke ermittleGewinnerSchnecke() {
        for (Rennschnecke schnecke : Schnecken) {
            if (schnecke.strecke >= this.streckenlaenge) {
                return schnecke;
            }
        }
        return null;
    }

    /**
     * Formatiert die Gewinner­schnecke als String (für Konsolenausgabe).
     *
     * @return Siegerbeschreibung oder {@code null} wenn noch kein Gewinner feststeht
     */
    public String ermittleGewinner() {
        Rennschnecke sieger = ermittleGewinnerSchnecke();
        if (sieger == null) return null;
        return sieger.name + ": " + String.format("%.2f", sieger.strecke)
             + " (Ziel: " + streckenlaenge + ")";
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

import java.util.ArrayList;

/**
 * Verwaltet Wetten zu einem Rennen und führt das Rennen im Auftrag der
 * Wettenden durch.
 *
 * <p>Das Wettbüro hält eine Liste von {@link Wette}-Objekten und eine Referenz
 * auf das zugehörige {@link Rennen}. Es demonstriert <b>Assoziation</b>: Das
 * Wettbüro <em>hat ein</em> Rennen ({@code rennen}-Attribut), ist aber nicht
 * selbst ein Rennen – das Prinzip „Komposition statt Vererbung".</p>
 *
 * <h2>Ablauf einer Wett-Session</h2>
 * <ol>
 *   <li>Wettbüro erzeugen: {@code new Wettbuero(rennen)}</li>
 *   <li>Wetten annehmen: {@code Wetten.add(new Wette(...))}</li>
 *   <li>Rennen durchführen: {@link #rennenDurchfuehren()}</li>
 *   <li>Gewinne auszahlen: {@link #zahleGewinneAus()}</li>
 * </ol>
 *
 * @author hibbes
 * @see Rennen
 * @see Wette
 */
public class Wettbuero {

    /** Gewinnfaktor: Auszahlung = Einsatz × faktor. */
    double faktor = 3;

    /** Das Rennen, das dieses Wettbüro begleitet. */
    Rennen rennen;

    /** Liste aller abgegebenen Wetten. */
    ArrayList<Wette> Wetten;

    /**
     * Erstellt ein Wettbüro für ein bestimmtes Rennen.
     *
     * @param rennen das begleitete Rennen
     */
    public Wettbuero(Rennen rennen) {
        this.rennen = rennen;
        this.Wetten = new ArrayList<Wette>();
    }

    /**
     * Delegiert die Durchführung des Rennens an das Rennen-Objekt.
     *
     * <p><b>Delegation:</b> Das Wettbüro "kann" selbst kein Rennen fahren –
     * es gibt die Aufgabe an das Rennen-Objekt weiter. Das ist das Prinzip
     * der Delegation: eine Klasse nutzt die Fähigkeiten einer anderen.</p>
     */
    public void rennenDurchfuehren() {
        rennen.durchfuehren();
    }

    /**
     * Zahlt die Gewinne an alle Wettenden aus, deren Tipp auf die Sieger­schnecke
     * gesetzt war.
     *
     * <p>Zur Auszahlung wird die Sieger­schnecke via
     * {@link Rennen#ermittleGewinnerSchnecke()} ermittelt. Anschließend werden
     * alle Wetten durchlaufen und Treffer mit {@code Einsatz × faktor} ausgezahlt
     * (Fehltipps werden als Verlust protokolliert).</p>
     *
     * @return Gesamtauszahlung (Summe über alle Gewinner-Wetten)
     */
    public double zahleGewinneAus() {
        Rennschnecke sieger = rennen.ermittleGewinnerSchnecke();
        if (sieger == null) {
            System.out.println("Rennen wurde noch nicht durchgeführt – keine Auszahlung.");
            return 0.0;
        }
        System.out.println("Sieger: " + sieger.name);

        double gesamt = 0.0;
        for (Wette w : Wetten) {
            if (w.schnecke == sieger) {
                double auszahlung = w.wettEinsatz * faktor;
                gesamt += auszahlung;
                System.out.printf("  + %s gewinnt %.2f (Einsatz %.2f)%n",
                        w.spieler, auszahlung, w.wettEinsatz);
            } else {
                System.out.printf("  - %s verliert %.2f%n", w.spieler, w.wettEinsatz);
            }
        }
        System.out.printf("Gesamtauszahlung: %.2f%n", gesamt);
        return gesamt;
    }

    /** @return Übersicht über Rennen, Faktor und alle Wetten */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rennen: ").append(rennen.name)
          .append("  |  Gewinnfaktor: ").append(faktor).append("\n");
        sb.append("Wetten:\n");
        for (Wette wette : Wetten) {
            sb.append("  ").append(wette.toString()).append("\n");
        }
        return sb.toString();
    }
}

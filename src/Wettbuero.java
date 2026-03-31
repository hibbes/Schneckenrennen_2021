import java.util.ArrayList;

/**
 * Verwaltet Wetten zu einem Rennen und führt das Rennen im Auftrag der Wettenden durch.
 *
 * <p>Das Wettbüro hält eine Liste von {@link Wette}-Objekten und eine Referenz
 * auf das zugehörige {@link Rennen}. Es demonstriert Assoziation: Das Wettbüro
 * <em>hat ein</em> Rennen ({@code rennen}-Attribut), aber ist nicht selbst ein Rennen.</p>
 *
 * <p><b>TODO:</b> Die Gewinn-Ausschüttung nach dem Rennen ist noch nicht implementiert.
 * Erweiterungsidee: Prüfe für jede Wette, ob die gewettete Schnecke gewonnen hat,
 * und berechne die Auszahlung als {@code wettEinsatz × faktor}.</p>
 *
 * @author hibbes
 * @see Rennen
 * @see Wette
 */
public class Wettbuero {

    /**
     * Gewinnfaktor: Gewinnerquote = Einsatz × faktor.
     * Aktuell noch nicht in der Auszahlungslogik genutzt.
     */
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

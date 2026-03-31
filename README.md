# Schneckenrennen 2021

Erweiterte Simulation eines Schneckenrennens mit vollständiger Renndurchführung, Gewinnermittlung und Wettbüro.

## Erweiterungen gegenüber Schneckenrennen (Basisversion)

| Feature | Basisversion | 2021 |
|---------|-------------|------|
| Geschwindigkeit | `int` | `double` (feinere Zufallswerte) |
| Rennschleife | manuell | `durchfuehren()` läuft bis Ziel |
| Gewinner | – | `ermittleGewinner()` |
| Wettbüro | – | `Wettbuero` + `Wette` |

## Klassen

| Klasse | Beschreibung |
|--------|-------------|
| `Rennschnecke` | Schnecke mit Name, Rasse, Geschwindigkeit |
| `Rennen` | Teilnehmerverwaltung, Renndurchführung, Gewinner |
| `Wette` | Datenklasse: Spieler + Einsatz + Schnecke |
| `Wettbuero` | Verwaltet Wetten, delegiert Renndurchführung |
| `Main` | Startet die Simulation |

## Lernziele

- Mehrere kooperierende Klassen (Objektkollaboration)
- `while`-Schleife als Spielschleife
- `ArrayList<T>` mit Generics
- Assoziation: Wettbüro *hat ein* Rennen
- Delegation: Methoden an andere Objekte weitergeben

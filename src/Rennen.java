import java.util.ArrayList;

public class Rennen {

	String name;
	int teilnehmerzahl;
	ArrayList<Rennschnecke> Schnecken
	
	new ArrayList<Rennschnecke>();
	
	double streckenlaenge;

	public Rennen(String name, double streckenlaenge) {
		this.name = name;
		this.streckenlaenge = streckenlaenge;

	}

	public void addRennschnecke(Rennschnecke neueSchnecke) {
		Schnecken.add(neueSchnecke);
	}

	public void removeRennschnecke(String name) {
		for (Rennschnecke schnecke : Schnecken) {
			if (schnecke.name.equals(name)) {
				Schnecken.remove(schnecke);
			}
		}

	}
	
public String toString() {
		String Schneckenstring = null;
	for (Rennschnecke schnecke : Schnecken) {
	    Schneckenstring = Schneckenstring + schnecke.toString();
	    }
		return "Name: "+name+", Teilnehmerzahl: "+teilnehmerzahl+", Streckenlänge: "+streckenlaenge+", Teilnehmerzahl: "+teilnehmerzahl+" Teilnehmer: "+Schneckenstring;
	}

	public static void main(String[] args) {
		Rennschnecke Alfred = new Rennschnecke("Alfred", "Weinschnecke", 1.6);
		Rennen Schillerrace = new Rennen("Schillerrace", 7);
		Schillerrace.addRennschnecke(Alfred);
		System.out.println(Schillerrace);

		System.out.println(Alfred);
		Alfred.kriechen();
		System.out.println(Alfred);
	}

}

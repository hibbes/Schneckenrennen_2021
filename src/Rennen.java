import java.util.ArrayList;

public class Rennen {

	String name;
	int teilnehmerzahl;
	ArrayList<Rennschnecke> Schnecken;

	// new ArrayList<Rennschnecke>();

	double streckenlaenge;

	public Rennen(String name, double streckenlaenge) {
		this.name = name;
		this.streckenlaenge = streckenlaenge;
		this.Schnecken = new ArrayList<Rennschnecke>();

	}

	public void addRennschnecke(Rennschnecke neueSchnecke) {

		if (this.Schnecken.contains(neueSchnecke)) {
			System.out.println("This snail is alredy at this race!");
		}

		else {
			this.Schnecken.add(neueSchnecke);
		}
	}

	public void removeRennschnecke(String name) {
		for (Rennschnecke schnecke : Schnecken) {
			if (schnecke.name.equals(name)) {
				Schnecken.remove(schnecke);
			}
		}

	}

	public void lasseSchneckenKriechen() {
		for (Rennschnecke schnecke : Schnecken) {
			schnecke.kriechen();
		}
	}

	public String ermittleGewinner() {
		for (Rennschnecke schnecke : Schnecken) {
			if (schnecke.strecke >= this.streckenlaenge) {
				return ""+schnecke.name +": "+ schnecke.strecke;
			}

		}
		return null;
	}

	public void durchfuehren() {
		while (this.ermittleGewinner() == null) {
			this.lasseSchneckenKriechen();
		}
		

	}

	public String toString() {
		String Schneckenstring = " ";
		for (Rennschnecke schnecke : Schnecken) {
			Schneckenstring = Schneckenstring + schnecke.toString();
		}
		return "Name: " + name + ", Streckenlänge: " + streckenlaenge + ", Teilnehmerzahl: " + teilnehmerzahl
				+ " Teilnehmer:" + Schneckenstring;
	}

	

}

import java.util.ArrayList;

public class Rennen {

	String name;
	int teilnehmerzahl;
	ArrayList<Rennschnecke> Schnecken;
	
	//new ArrayList<Rennschnecke>();
	
	double streckenlaenge;

	public Rennen(String name, double streckenlaenge) {
		this.name = name;
		this.streckenlaenge = streckenlaenge;
		this.Schnecken = new ArrayList<Rennschnecke>();

	}

	public void addRennschnecke(Rennschnecke neueSchnecke) {
		this.Schnecken.add(neueSchnecke);
	}

	public void removeRennschnecke(String name) {
		for (Rennschnecke schnecke : Schnecken) {
			if (schnecke.name.equals(name)) {
				Schnecken.remove(schnecke);
			}
		}

	}
	
public String toString() {
		String Schneckenstring = " ";
	for (Rennschnecke schnecke : Schnecken) {
	    Schneckenstring = Schneckenstring + schnecke.toString();
	    }
		return "Name: "+name+", Streckenlänge: "+streckenlaenge+", Teilnehmerzahl: "+teilnehmerzahl+" Teilnehmer:"+Schneckenstring;
	}

	public static void main(String[] args) {
		Rennschnecke Alfred = new Rennschnecke("Alfred", "Weinschnecke", 1.6);
		Rennschnecke Barbara = new Rennschnecke("Barbara", "Seeschnecke", 2.1);
		Rennen Schillerrace = new Rennen("Schillerrace", 7);
		Schillerrace.addRennschnecke(Alfred);
		Schillerrace.addRennschnecke(Barbara);
		System.out.println(Schillerrace);

		//System.out.println(Alfred);
		Alfred.kriechen();
		System.out.println(Alfred);
	}

}

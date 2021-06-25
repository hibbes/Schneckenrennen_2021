
public class Rennschnecke {

	String name;
	String rasse;
	double geschwindigkeit;
	double strecke = 0;

	public Rennschnecke(String name, String rasse, double geschwindigkeit) {
		this.name = name;
		this.rasse = rasse;
		this.geschwindigkeit = geschwindigkeit;
	}
	
	public void kriechen() {
		strecke = strecke+(Math.random()*geschwindigkeit);
	}
	
	public String toString() {
		
		return "Name: "+name+", Rasse: "+rasse+", Geschwindigkeit: "+geschwindigkeit+", Gekrochene Strecke: "+strecke;
	}
	
}

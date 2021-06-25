import java.util.ArrayList;

public class Wettbuero {

	double faktor = 3;
	Rennen rennen;
	ArrayList<Wette> Wetten;

	public Wettbuero(Rennen rennen) {
        this.rennen=rennen;
		this.Wetten = new ArrayList<Wette>();
		
	}
	
	public void rennenDurchfuehren() {
		rennen.durchfuehren();
	}
	
	public String toString() {
		String wettenstring ="";
		for (Wette wette : Wetten) {
			wettenstring = wettenstring + wette.toString()+"| ";
		}
		return "Rennen: "+rennen+" Gewinnfaktor: "+faktor+", "+wettenstring;
	}

	
}

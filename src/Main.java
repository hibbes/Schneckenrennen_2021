
public class Main {

	public static void main(String[] args) {
		Rennschnecke Alfred = new Rennschnecke("Alfred", "Weinschnecke", 2.1);
		Rennschnecke Barbara = new Rennschnecke("Barbara", "Seeschnecke", 2.1);
		Rennen Schillerrace = new Rennen("Schillerrace", 7);
		Schillerrace.addRennschnecke(Alfred);
		Schillerrace.addRennschnecke(Barbara);
		Schillerrace.durchfuehren();
		System.out.println(Schillerrace.ermittleGewinner());
		
	

	
	}
	
	
}

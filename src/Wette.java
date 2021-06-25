
public class Wette {
   Rennschnecke schnecke;
   double wettEinsatz;
   String spieler;
   
   public Wette(Rennschnecke schnecke, double wettEinsatz, String spieler) {
     this.schnecke=schnecke;
     this.wettEinsatz=wettEinsatz;
     this.spieler=spieler;
   }
	   
	   
   public String toString() {
	   return this.schnecke.name+", "+wettEinsatz+", "+spieler; 
   }
}

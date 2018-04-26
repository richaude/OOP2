package spiegelzahlen;
/**
 * Klasse Spiegelzahl: Erzeugt von einer übergebenen Zahl die Spiegelzahl und kann diese auf die Palindromeigenschaft pruefen
 * @author Lukas
 * @version 1.0
 */

public class Spiegelzahl {
	/**
	 * Standart-Konstruktor
	 * 
	 */
	public Spiegelzahl() {

	}
	/**
	 * Erzeugt die gespiegelte Zahl der Zahl, die als Parameter übergeben wurde, nutzt StringBuilder extrem aus
	 * @return gibt die erzeugte Spiegelzahl als Integer zurueck
	 */
	
	public int erzeugeSpiegelZahl(int zahl) {
		int ergebnis = 0;
		StringBuilder s1 = new StringBuilder(Integer.toString(zahl));
		StringBuilder s2 = new StringBuilder("");
		
		s2.append(s1.reverse());
		
		try {
			ergebnis = Integer.parseInt(s2.toString());
		}
		catch(NumberFormatException nfex) {
			System.out.println("Konnte Spiegelzahl nicht erzeugen!");
			nfex.printStackTrace();
		}
		return ergebnis;
	}
	
	
	/**
	 * Vergleicht die übergebene Zahl mit ihrer Spiegelzahl auf die Palindromeigenschaft
	 * @return gibt True zurueck falls eine Palindromzahl vorliegt, andernfalls false
	 */
	
	public boolean istPalindromZahl(int zahl) {
		int spiegelzahl = erzeugeSpiegelZahl(zahl);
		
		if(zahl == spiegelzahl) {
			return true;
		}
		else {
			return false; 
		}
	}
}

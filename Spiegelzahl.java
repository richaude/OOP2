package spiegelzahlen;

import java.math.BigInteger;

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
	
	public BigInteger erzeugeSpiegelZahl(BigInteger zahl) {
		BigInteger ergebnis = new BigInteger("0");
		StringBuilder s1 = new StringBuilder(zahl.toString());
		StringBuilder s2 = new StringBuilder("");
		
		s2.append(s1.reverse());
		
		try {
			ergebnis = new BigInteger(s2.toString());
		}
		catch(Throwable t) {
			System.out.println("Konnte Spiegelzahl nicht erzeugen!");
			t.printStackTrace();
		}
		return ergebnis;
	}
	
	
	/**
	 * Vergleicht die übergebene Zahl mit ihrer Spiegelzahl auf die Palindromeigenschaft
	 * @return gibt True zurueck falls eine Palindromzahl vorliegt, andernfalls false
	 */
	
	public boolean istPalindromZahl(BigInteger zahl) {
		BigInteger spiegelzahl = erzeugeSpiegelZahl(zahl);
		
		if(zahl.equals(spiegelzahl)) {
			return true;
		}
		else {
			return false; 
		}
	}
}

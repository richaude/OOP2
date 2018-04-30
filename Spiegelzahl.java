package spiegelzahlen;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse Spiegelzahl: Erzeugt von einer uebergebenen Zahl die Spiegelzahl und kann diese auf die Palindromeigenschaft pruefen sowie Summe errechnen
 * @author Lukas
 * @version 2.0
 */

public class Spiegelzahl {

	private List<Byte> ausgangszahl;
	private List<Byte> spiegelzahl;
	/**
	 * Standart-Konstruktor
	 * @param Die Zahl, von der spaeter Spiegelzahl und Summe erstellt werden soll
	 */
	
	
	public Spiegelzahl(List<Byte> ausgangsZahl) {
		this.ausgangszahl = new ArrayList<Byte>();
		this.spiegelzahl = new ArrayList<Byte>();
		this.ausgangszahl = ausgangsZahl;
	}
	/**
	 * Erzeugt die Summe von Ausgangs- und Spiegelzahl
	 * @return gibt die erzeugte Summe als Byte-Liste zurueck
	 */

	public List<Byte> addiere() {
	
		int length = this.ausgangszahl.size() +1;
		
		// Initialisiere Byte-Array, eins laenger als die anderen beiden Zahlen!
		Byte[] bytes = new Byte[length];
		for(int i = 0; i< length; i++) {
			bytes[i] = 0;
		}
		byte uebertrag = 0;
		byte momentaneSumme;
		
		//Zaehlt von hinten nach vorne beide Listen durch, Annahme: Beide sind gleich lang!
		for(int i = this.ausgangszahl.size() -1; i>=0 ; i--) {

			// Momentane Summe wird berechnet und auf Byte gecastet
			if(uebertrag>0) {
			momentaneSumme = (byte) (this.ausgangszahl.get(i) + this.spiegelzahl.get(i)+uebertrag);
			}
			else { 
				momentaneSumme = (byte) (this.ausgangszahl.get(i) + this.spiegelzahl.get(i));
			}
			uebertrag = 0;
			// Bestimme Uebertrag
			while(momentaneSumme >=10) {
				uebertrag +=1;
				momentaneSumme -= 10;
			}
			// Schreibe Summe und Uebertrag in das Byte-Array
			bytes[i+1] = momentaneSumme;
			
			// Jetzt den Uebertrag, falls sich die Anzahl der Stellen der Zahl erhoeht hat
			if((uebertrag !=0) && (i == 0)) {
				bytes[i] = uebertrag;
			}
		}

		// Initialisieren summe-Liste und gib sie zurueck
		List<Byte> summe = new ArrayList<Byte>();
		for(int i = 0; i<bytes.length; i++) {
			summe.add(bytes[i]);
		}
		if(summe.get(0).equals((byte)0)) {
			//while (summe.get(0).equals((byte)0)) {
				summe.remove(0);
			//}
		}
		
		
		return summe;
		
	}
	
	/**
	 * Erzeugt die zur gegebenen Zahl die zugehoerige Spiegelzahl
	 */
	public void erzeugeSpiegelZahl() {
		StringBuilder s1 = new StringBuilder("");
		StringBuilder s2 = new StringBuilder("");
		
		for(Byte b : this.ausgangszahl) {
			s1.append(Byte.toString(b));
		}
		// Abuse die Reverse-Funktion zum Spiegeln der Zahlen
		s2.append(s1.reverse());
		
		// Wandle StringBuilder wieder in Byte-Array um
		while(!(s2.toString().equals(""))) {
			String s = s2.substring(0, 1);
			Byte e = Byte.parseByte(s);
	
			this.spiegelzahl.add(e);
			s2.deleteCharAt(0);
		}
	}
	
	
	/**
	 * Vergleicht die uebergebene Zahl mit ihrer Spiegelzahl auf die Palindromeigenschaft
	 * @return gibt True zurueck falls eine Palindromzahl vorliegt, andernfalls false
	 */
	
	public boolean istPalindromZahl() {
	boolean istPalindrom = true;
		for(int i = 0; i<this.spiegelzahl.size(); i++) {
			if(this.ausgangszahl.get(i).equals(this.spiegelzahl.get(i))) {
				continue;
			}
			else {
				istPalindrom = false;
			}
			
		}
		return istPalindrom;
		
	}
	/**
	 * Einfacher Getter fuer die Spiegelzahl
	 * @return Instanz der Spiegelzahl zur aktuellen Zahl
	 */
	public Spiegelzahl getSpiegelzahl() {
		return new Spiegelzahl(this.spiegelzahl);
	}
	
	/**
	 * toString Methode zum Ausgeben
	 * @return den String, der die Zahl in der Byte-Liste repraesentiert
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<ausgangszahl.size(); i++) {
			sb.append(ausgangszahl.get(i));
		}
		return sb.toString();
	}
}

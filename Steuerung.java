package spiegelzahlen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse koordiniert das Programm.
 * @author richard
 */

public class Steuerung {
	
	private int iterationen;
	private List<Byte> eingabezahl;
	private Berechnungen berechnungen;
	
	/**
	 * Konstruktor
	 */
	public Steuerung() {
	}
	
	/**
	 * Hier wird die Spiegelzahl als Liste von Bytes eingelesen und im Attribut eingabezahl gespeichert.
	 * Bei ungueltigen Eingaben wird die Funktion nochmal aufgerufen.
	 */
	public void einlesenDerSpiegelzahl() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String eingabe = new String("");
		List<Byte> aktuelleEingabe = new ArrayList<>();
		System.out.println("Bitte geben Sie die zu testende Zahl ein:");
		try {
			eingabe = br.readLine();
			for (int j=0; j<eingabe.length(); j++) {
				byte b = Byte.parseByte(eingabe.substring(j, j+1));
				aktuelleEingabe.add(b);
			}
			eingabezahl = aktuelleEingabe;
		} catch(IOException e) {
			System.out.println("Einlesefehler. Bitte nur positive Ganzzahlen eingeben.");
			einlesenDerSpiegelzahl();
		} catch(Throwable t) {
			System.out.println("Ungueltige Eingabe. Bitte nur positive Ganzzahlen verwenden.");
			einlesenDerSpiegelzahl();
		}
	}
	
	/**
	 * Hier wird die Zahl der Iterationen eingelesen, bei Fehlern oder ungueltigen Eingaben ruft die Funktion wieder sich selbst auf.
	 */
	public void einlesenDerIterationen() {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		String iterationsString = new String("");
		iterationen = 0;
		System.out.println("Bitte geben Sie die Zahl der gewuenschten maximalen Iterationen ein:");
		try {
			iterationsString = b.readLine();
			iterationen = Integer.parseInt(iterationsString);
			if (iterationen <= 0) {
				System.out.println("Es macht keinen Sinn, Zahlen kleiner oder gleich Null zu verwenden. Bitte nochmal versuchen!");
				einlesenDerIterationen();
			}
		} catch(IOException io) {
			System.out.println("Einlesefehler. Bitte nur positive Ganzzahlen eingeben.");
			einlesenDerIterationen();
		} catch(NumberFormatException nf) {
			System.out.println("Ungueltige Eingabe, bitte nochmal versuchen!");
			einlesenDerIterationen();
		} catch(Throwable t) {
			System.out.println("Bitte nur positive Ganzzahlen eingeben.");
			einlesenDerIterationen();
		}
	}
	
	/**
	 * Diese Funktion erzeugt eine Instanz der Klasse Berechnungen und weist ihr im Konstruktor die eingelesenen Daten fuer die eingabezahl und iterationen zu.
	 * Anschliessend wird die iteriere() Funktion ausgefuehrt.
	 */
	public void berechne() {
		berechnungen = new Berechnungen(eingabezahl, iterationen);
		berechnungen.iteriere();
	}
	
	/**
	 * Sorgt dafuer, dass in einer do-while-Schleife alle Operationen in der richtigen Reihenfolge ausgefuehrt werden und das Programm beendet werden kann.
	 * Abbruchbedingung ist hier die Eingabe der Antwort als 'n'
	 */
	public void steuern() {
		boolean b = true;
		do {
			einlesenDerSpiegelzahl();
			einlesenDerIterationen();
			berechne();
			System.out.println("\n\n\nDruecke 'n' um aufzuhoeren, oder druecke ein beliebiges anderes Zeichen, um noch einen Versuch zu machen.\n");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String antwort = new String("");
			try {
				antwort = br.readLine().toLowerCase();
			} catch(IOException e) {
				System.out.println("Ungueltige Eingabe, Programm endet automatisch.");
			}
			if (antwort.equals("n")) {
				b = false;
				System.out.println("\nAuf Wiedersehen!\n");
			}
		} while (b);
	}

}

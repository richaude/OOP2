package spiegelzahlen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Steuerung {
	
	private int iterationen;
	private List<Byte> eingabezahl;
	private Berechnungen berechnungen;
	
	public Steuerung() {
	}
	
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
		//System.out.println(iterationen);
	}
	
	public void berechne() {
		berechnungen = new Berechnungen(eingabezahl, iterationen);
		berechnungen.iteriere();
	}
	
	//braucht man nicht mehr
	public void ausgabe() {
		System.out.println(berechnungen.toString());
	}
	
	public void steuern() {
		boolean b = true;
		do {
			einlesenDerSpiegelzahl();
			einlesenDerIterationen();
			berechne();
			//ausgabe();
			System.out.println("\n\n\nDruecke eine beliebige Taste, um noch einen Versuch durchzufuehren, oder druecke 'n' um aufzuhoeren.\n");
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

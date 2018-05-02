package spiegelzahlen;

import java.util.List;
import java.util.Stack;

/**
 * das eigentliche Herzstueck des ganzen Programms
 * @author richard
 */

public class Berechnungen {
	
	private List<Byte> eingabezahl;
	private int iterationen;
	
	/**
	 * Konstruktor (wird in der Steuerung als Instanz erzeugt)
	 * @param eingabezahl die in der Steuerung eingelesene Liste von Bytes
	 * @param iterationen die in der Steuerung eingelesene Zahl der Iterationen
	 */
	Berechnungen(List<Byte> eingabezahl, int iterationen) {
		this.eingabezahl = eingabezahl;
		this.iterationen = iterationen;
	}
	
	/**
	 * erzeugt in einer while-Schleife zu jeder Zahl die Spiegelzahl, addiert sie, und ueberprueft, ob die Summe eine Palindromzahl ist. Die erste Addition findet ausserhalb der Schleife statt, die Summe wird dann immer auf einem Stack gespeichert. Abbruchbedingungen der Schleife sind entweder das Finden einer Palindromzahl oder das Ueberschreiten der Iterationszahl.
	 */
	public void iteriere() {
		Spiegelzahl ausgangsZahl = new Spiegelzahl(eingabezahl);
		Stack<Spiegelzahl> zwischenAblage = new Stack<Spiegelzahl>();
		ausgangsZahl.erzeugeSpiegelZahl();
		if (ausgangsZahl.istPalindromZahl()) {
			System.out.println("Die eingegebene Zahl ist bereits eine Palindromzahl: " + ausgangsZahl);
			System.out.println("Es waren keine Iterationen erforderlich.");
		} else {
			Spiegelzahl schritt1 = new Spiegelzahl(ausgangsZahl.addiere());
			System.out.println(ausgangsZahl.toString() + " und ihre Spiegelzahl "+ ausgangsZahl.getSpiegelzahl().toString() + " ergeben " + schritt1.toString());
			zwischenAblage.push(schritt1);
			int k = 0;
			while(k<iterationen) {
				Spiegelzahl temp = zwischenAblage.pop();
				temp.erzeugeSpiegelZahl();
				if (temp.istPalindromZahl()) {
					iterationen = k+1;
					System.out.println("Die ermittelte Palindromzahl ist also " + temp.toString() + ".");
					System.out.println("Anzahl der erforderlichen Schritte (Iterationen) fuer die Berechnung der Palindromzahl: " + iterationen);
					break;
				} else {
					Spiegelzahl neuTemp = new Spiegelzahl(temp.addiere());
					System.out.println(temp.toString() + " und ihre Spiegelzahl " + temp.getSpiegelzahl().toString() + " ergeben " + neuTemp.toString() + ".");
					zwischenAblage.push(neuTemp);
					if (k == iterationen-1) {
						System.out.println("Es konnte innerhalb der Parameter keine Palindromzahl erzeugt werden.");
					}
					k++;
				}
			}
		}
	}

}

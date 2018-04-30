package spiegelzahlen;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Berechnungen {
	
	private List<Byte> eingabezahl;
	private int iterationen;
	private List<Spiegelzahl> spiegelzahlen = new ArrayList<Spiegelzahl>();
	private List<Spiegelzahl> summen = new ArrayList<Spiegelzahl>();
	
	Berechnungen(List<Byte> eingabezahl, int iterationen) {
		this.eingabezahl = eingabezahl;
		this.iterationen = iterationen;
	}
	
	//hier ist noch eine Menge ueberfluessiges Zeug dabei, aber es funktioniert jetzt so
	public void iteriere() {
		Spiegelzahl ausgangsZahl = new Spiegelzahl(eingabezahl);
		Stack<Spiegelzahl> zwischenAblage = new Stack<Spiegelzahl>();
		ausgangsZahl.erzeugeSpiegelZahl();
		if (ausgangsZahl.istPalindromZahl()) {
			System.out.println("Die eingegebene Zahl ist bereits eine Palindromzahl: " + ausgangsZahl);
			spiegelzahlen.add(ausgangsZahl.getSpiegelzahl());
			summen.add(new Spiegelzahl(ausgangsZahl.addiere()));
		} else {
			spiegelzahlen.add(ausgangsZahl.getSpiegelzahl());
			Spiegelzahl schritt1 = new Spiegelzahl(ausgangsZahl.addiere());
			System.out.println(ausgangsZahl.toString() + " und ihre Spiegelzahl "+ ausgangsZahl.getSpiegelzahl().toString() + " ergeben " + schritt1.toString());
			summen.add(schritt1);
			zwischenAblage.push(schritt1);
			int k = 0;
			while(k<iterationen) {
				Spiegelzahl temp = zwischenAblage.pop();
				temp.erzeugeSpiegelZahl();
				if (temp.istPalindromZahl()) {
					iterationen = k+1;
					System.out.println("Die ermittelte Palindromzahl ist also " + temp.toString() + ".");
					System.out.println("Es waren " + iterationen + " Schritte fuer die Berechnung der Palindromzahl erforderlich.");
					break;
				} else {
					spiegelzahlen.add(temp.getSpiegelzahl());
					Spiegelzahl neuTemp = new Spiegelzahl(temp.addiere());
					System.out.println(temp.toString() + " und ihre Spiegelzahl " + temp.getSpiegelzahl().toString() + " ergeben " + neuTemp.toString() + ".");
					summen.add(neuTemp);
					zwischenAblage.push(neuTemp);
					if (k == iterationen-1) {
						System.out.println("Es konnte innerhalb der Parameter keine Palindromzahl erzeugt werden.");
					}
					k++;
				}
			}
		}
	}
	
	//diese ganze Methode ist im Endeffekt ueberfluessig und ich werde sie spaeter wohl ganz loeschen
	public String toString() {
		System.out.println(iterationen);
		StringBuilder sb = new StringBuilder();
		sb.append("Die Ausgangszahl " + new Spiegelzahl(eingabezahl).toString() + " und ihre Spiegelzahl " + spiegelzahlen.get(0).toString() + " ergeben " + summen.get(0).toString()  + "\n");
		new Spiegelzahl(eingabezahl).erzeugeSpiegelZahl();
		if (summen.get(0).istPalindromZahl()) {
			sb.append("Die erzeugte Palindromzahl ist also: " + summen.get(0).toString()+ "\n");
			sb.append("Nur eine Iteration war notwendig.\n");
		}
		int j = 1;
		while(j<iterationen) {
			sb.append(summen.get(j-1).toString() + " und ihre Spiegelzahl " + spiegelzahlen.get(j).toString() + " ergeben " + summen.get(j).toString() + "\n");
			//if (summen.get(j).istPalindromZahl()) {
			if (j == iterationen-1) {
				summen.get(j).erzeugeSpiegelZahl();
				if (summen.get(j).istPalindromZahl()) {
					sb.append("Die erzeugte Palindromzahl ist also: " + summen.get(j).toString() + "\n");
					sb.append("Es waren " + iterationen + " Iterationen (Schritte) erforderlich.\n");
				} else {
					sb.append("Innerhalb von " + iterationen + "Schritten konnte keine Palindromzahl ermittelt werden.\n");
				}
				
			}
			j++;
		}
		return sb.toString();
	}

}

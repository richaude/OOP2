package spiegelzahlen;

/**
 * Einsprungsklasse fuer die virtuelle Maschine
 * @author richard
 *
 */

public class Main {

	/**
	 * erzeugt eine Instanz der Steuerung und ruft daran die steuern()-Methode auf
	 * @param args
	 */
	public static void main(String[] args) {
		Steuerung steuerung = new Steuerung();
		steuerung.steuern();
	}

}

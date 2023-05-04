/**
 * Diese Klasse beschreibt ein Lied anhand des Namens, des Interpreten sowie
 * der Laenge des Liedes in Sekunden.
 *
 * @author Andrej Felde
 * @version 2018-03-30
 */
public class Lied {

    private String titel;
    private String interpret;
    private int laenge;

    /**
     * Initialisiert ein Lied mit dem Titel t, dem Interpreten i sowie der Laenge l.
     *
     * @param t Titel des Liedes
     * @param i Interpret des Liedes
     * @param l Laenge des Liedes in Sekunden
     */
    public Lied(String t, String i, int l) {
        titel = t;
        interpret = i;
        laenge = l;
    }

    /**
     * Diese Methode gibt den Titel des Liedes zurueck.
     *
     * @return Liedtitel
     */
    public String gibTitel() {
        return titel;
    }

    // TODO: Schreiben Sie eine Methode, die den Interpreten zurueckgibt.
    // public String gibInterpret()

    /**
     * Diese Methode gibt die Laenge des Liedes in Sekunden zurueck.
     *
     * @return Liedlaenge in Sekunden
     */
    public int gibLaenge() {
        return laenge;
    }

    public String gibInterpret(){
        return interpret;
    }

    /**
     * Diese Methode setzt den Titel des Liedes auf den Wert t.
     *
     * @param t Neuer Titel des Liedes
     */
    public void setzeTitel(String t) {
        titel = t;
    }

    /**
     * Diese Methode setzt den Interpreten des Liedes auf den Wert i.
     *
     * @param i Neuer Interpret des Liedes
     */
    public void setzeInterpret(String i) {
        interpret = i;
    }

    public void setzeLaenge(int l){
        laenge = l;
    }

    public double gibFormatierteLaenge(String format){

        double newLaenge = 0;

        switch (format) {
            case "s" -> newLaenge = laenge;
            case "m" -> newLaenge = (double) laenge / 60;
            case "h" -> newLaenge = (double) laenge / 3600;
            default -> {
                System.out.println("Bitte wähle dein Ausgabeformat mit 's' für Sekunden, 'm' für Minuten oder 'h' für Stunden");
            }
        }
        ;

        return newLaenge;

    }

    public String toString(){
        //"String output = Titel: <titel>\nInterpret: <interpret>\nLaenge: <laenge>;"
        return "-Titel: " +  titel + ";\n" + "-Interpret: " + interpret + ";\n" + "-Laenge: " + laenge;
    }

    // TODO: Schreiben Sie eine Methode, die die Laenge des Liedes neu setzt.
    // public void setzeLaenge(int l)

    // TODO: Schreiben Sie eine Methode, die die Laenge des Liedes im
    // angegebenen Format zurueckgibt.
    // public double gibFormatierteLaenge(String format)

    // TODO: Schreiben Sie eine Methode, welche die Datenfelder als String
    // im folgenden Format zurueckgibt:
    // "Titel: <titel>\nInterpret: <interpret>\nLaenge: <laenge>"
    // <titel>, <interpret>, <laenge> steht dabei für den Wert in den entsprechenden Datenfeldern.
    // public String toString()
}

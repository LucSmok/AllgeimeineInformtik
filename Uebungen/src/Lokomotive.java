
/**
 * Diese Klasse modelliert eine einfache Lokomotive.
 *
 * @author Maximilian Flaig, Andrej Felde, Maximilian Kratz, Florian Brandherm
 * @version 2021-04-28
 */
public class Lokomotive {

    private int hoechstgeschwindigkeit;
    private int geschwindigkeit;

    private int zugkraft; //in Tonnen

    // TODO
    /**
     * Erzeugt eine Lokomotive mit der gegebenen Hoechstgeschwindigkeit und
     * der gegebenen Zugkraft. Beide Werte muessen positiv sein.
     * @param vmax Die Hoechstgeschwindigkeit der Lok in km/h.
     * @param zugkraft Das maximale Gewicht der gezogenen Waggons.
     */
    public Lokomotive(int vmax, int zugkraft){
        if(vmax < 0 || zugkraft < 0){
            System.out.println("Höchstgeschwindigkeit und Zugkraft müssen positve Werte. Die Eingabe wurde in positive Werte umgewandelt.");
        }
        this.hoechstgeschwindigkeit = Math.abs(vmax);
        this.zugkraft = Math.abs(zugkraft);
        this.geschwindigkeit = 0;
    }

    // TODO
    /**
     * Passt die Geschwindigkeit der Lokomotive auf den angegebenen Wert an.
     * Dabei muss der Wert zwischen 0 und der Hoechstgeschwindigkeit liegen.
     *
     * @param geschwindigkeit Die Geschwindigkeit in km/h, die der Zug
     * annehmen soll
     */
     public void geschwindigkeitAnpassen(int geschwindigkeit){
         if(geschwindigkeit < hoechstgeschwindigkeit && geschwindigkeit >= 0){
             this.geschwindigkeit = geschwindigkeit;
         }else{
             System.out.println("Bite geben Sie eine gültige Geschwindigkeit ein. Ihre Eingabe konnte nicht übernommen werden");
         };
     }

    /**
     * Gibt die Zugkraft der Lokomotive (in Tonnen) zurueck.
     *
     * @return Zugkraft der Lokomotive (in Tonnen)
     */
    public int gibZugkraft() {
        return zugkraft;
    }

    /**
     * Gibt die Geschwindigkeit des Zuges zurueck.
     *
     * @return Geschwindigkeit in km/h
     */
    public int gibGeschwindigkeit() {
        return geschwindigkeit;
    }
}
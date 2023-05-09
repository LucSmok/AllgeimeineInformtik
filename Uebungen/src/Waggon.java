
/**
 * Diese Klasse modelliert einen Gueterwaggon.
 *
 * @author Maximilian Flaig, Maximilian Kratz, Florian Brandherm
 * @version 2021-04-28
 */
public class Waggon {

    private int kapazitaet;
    private String ware;
    private int zuladung;

    /**
     * Erzeugt einen Waggon.
     * @param kapazitaet Die maximale Zuladung.
     */
    public Waggon(int kapazitaet) {
        if (kapazitaet > 0) {
            this.kapazitaet = kapazitaet;
        } else {
            this.kapazitaet = 0;
        }
        ware = null;
        zuladung = 0;
    }

    /**
     * Liefert die aktuelle Zuladung in Tonnen.
     * @return Die aktuelle Zuladung in Tonnen.
     */
    public int gibZuladung() {
        return zuladung;
    }

    /**
     * Liefert die aktuell verladene Ware.
     * @return Ein String, der die Ware bezeichnet. null, falls der Waggon unbeladen ist.
     */
    public String gibWare() {
        return ware;
    }

    /**
     * Liefert das Eigengewicht des Waggons.
     * @return Eigengewicht in Tonnen.
     */
    public static int gibEigengewicht() {
        return 10;
    }

    /**
     * Liefert das aktuelle Gesamtgewicht (Eigengewicht + Zuladung) des Waggons.
     * @return Gesamtgewicht in Tonnen.
     */
    public int gibGesamtgewicht() {
        return gibEigengewicht() + zuladung;
    }

    /**
     * Verlaedt Waren auf den Waggon. Falls ein anderer Warentyp verladen werden soll, als aktuell vorhanden,
     * kann die Ware nicht verladen werden. Zudem kann die maximale Zuladungskapazitaet nicht ueberschritten werden.
     * @param ware Die Ware, die verladen werden soll.
     * @param gewicht Gewicht der Ware in Tonnen.
     * @return Gewicht der nicht verladenen Ware.
     */
    public int beladen(String ware, int gewicht) {
        if (this.ware == null || this.ware.equals(ware)) {
            this.ware = ware;
            int freieKapazitaet = this.kapazitaet - this.zuladung;
            int neueZuladung = gewicht;
            if (gewicht > freieKapazitaet) {
                neueZuladung = freieKapazitaet;
            }
            this.zuladung += neueZuladung;
            return gewicht - neueZuladung;
        } else { // in diesem Fall ist der Waggon bereits voll oder mit einer anderen Ware beladen.
            return gewicht;
        }
    }
}

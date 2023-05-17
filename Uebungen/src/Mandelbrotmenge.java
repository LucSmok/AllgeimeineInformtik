/**
 * Diese Klasse Repräsentiert eine Visualisierung der Mandelbrotmenge.
 */

public class Mandelbrotmenge {

    BitmapFenster fenster;

    /**
     * Konstruktor, der eine Mandelbrotmenge zeichnet.
     * @param hoehe Bildhoehe in Pixeln.
     * @param breite Bildhoehe in Pixeln.
     * @param kantenglaettung Falls true, wird das Bild in der doppelten Auflösung berechnet und bei der Anzeige verkleinert, was eine Kantenglättung zufolge hat.
     */
    /*
    public Mandelbrotmenge(int hoehe, int breite, boolean kantenglaettung) {

        if (kantenglaettung) {
            breite *= 2;
            hoehe *= 2;
        }

        fenster = new BitmapFenster(bitmapBerechnen(breite, hoehe), kantenglaettung, true);
    }*/

    /**
     * Bildet eine x-Koordinate auf den entsprechenden Realanteil ab.
     * @param x X-Koordinate des Pixels.
     * @param breite Breite des Bilds in Pixeln.
     */
    public double xZuRe(double x, double breite) {
        return (x / breite) * 3.0 - 2.0;
    }

    /**
     * Bildet eine y-Koordinate auf den entsprechenden Realteil ab.
     * @param y Y-Koordinate des Pixels.
     * @param hoehe Hoehe des Bilds in Pixeln.
     */
    public double yZuIm(double y, double hoehe) {
        return (y / hoehe) * 2.0 - 1.0;
    }

    /**
     * Berechnet ein Bild der Mandelbrotmenge.
     * @param breite Bildbreite in Pixel
     * @param hoehe Bildhöhe in Pixel
     * @return 2d-Bild mit den übergebenen Dimensionen
     */
    // TODO private int[][] bitmapBerechnen(int breite, int hoehe)

    /**
     * Berechnet für einen individuellen Punkt in der komplexen Ebene, ob
     * er Teil der Mandelbrot-Menge ist bzw. wie weit er davon entfernt ist.
     * @param c Ein Punkt in der komplexen Ebene, für den die Berechnung durchgeführt werden soll.
     * @return 255, falls der Punkt in der Menge ist. Die Anzahl der Iterationen (0 bis 255) innerhalb des Grenzwertes, falls nicht.
     */
    // TODO private int punktBerechnen(KomplexeZahl c)
}

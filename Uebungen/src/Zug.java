

import java.util.ArrayList;
import java.util.Objects;

/**
 * Diese Klasse modelliert einen Gueterzug.
 *
 * @author Maximilian Flaig, Andrej Felde, Maximilian Kratz
 * @version 2020-05-12
 */
public class Zug {

    private Lokomotive lok;

    private ArrayList<Waggon> waggons;

    // TODO
    /**
     * Erzeugt einen Zug ohne Waggons. Die Zugkraft gibt an wie viele
     * Tonnen der Zug ziehen kann und die Maximalgeschwindigkeit wird auf
     * 120 km/h gesetzt. Die Groesse der Zugkraft muss positiv sein.
     * @param zugkraft Maximalgewicht der Waggons, die der Zug ziehen kann.
     */
    public Zug(int zugkraft){
        if(zugkraft < 0){
            System.out.println("Zugkraft muss ein positiver Werte sein. Die Lokomotive konnte nicht erstellt werden");
        }
        else {
            this.lok = new Lokomotive(120, Math.abs(zugkraft));
        }
        this.waggons = new ArrayList<Waggon>();
    }

    private boolean zugStehtMitMeldung(){
        if(this.lok.gibGeschwindigkeit() == 0){
            return true;
        }
        else{
            System.out.println("Bitte halte den Zug erst an, erst dann kannst du einen Waggon hinzufügen.");
            return false;
        }
    }
    // TODO
    /**
     * Liefert die aktuelle Anzahl der Waggons des Zugs.
     * @return Die aktuelle Anzahl der Waggons.
     */
    public int anzahlWaggons(){
        return waggons.size();
    }

    // TODO
    /**
     * Liefert das Gesamtgewicht aller Waggons zusammen.
     * @return Gesamtgewicht
     */
    public int gibGesamtgewicht(){
        int gesamtGewicht = 0;
        for (Waggon waggon:waggons) {
            gesamtGewicht += waggon.gibGesamtgewicht();
        }
        return gesamtGewicht;
    }

    // TODO
    /**
     * Haengt einen Waggon an den Zug an. Der uebergebene Parameter kapazitaet
     * muss positiv sein.
     * @param kapazitaet Die maximale Zuladung des Waggons.
     */
    public void waggonHinzu(int kapazitaet){
        Waggon newWaggon = new Waggon(kapazitaet);

        if(zugStehtMitMeldung()){
            if(this.gibGesamtgewicht() + newWaggon.gibGesamtgewicht() <= this.lok.gibZugkraft()){
                waggons.add(newWaggon);
            }else{
                System.out.println("Dein Waggon konnte nicht hinzugefügt werden, das Gesamtgewicht würde überschritten werden.");
            }
        }
    }

    // TODO
    /**
     * Koppelt den letzten Waggon vom Zug ab.
     */
    public void abkoppeln(){
        if(zugStehtMitMeldung()){
            if(waggons.size()>=1){
               if(waggons.get(waggons.size()-1).gibZuladung() == 0){
                   waggons.remove(waggons.size()-1);
                   System.out.println("Waggon wurde abgekopplet: " + waggons.size());
               } else {
                   System.out.println("Bitte entladen den letzten Waggon bevor du Ihn abkoppeln möchtest");
               }
            }
        }

    }

    // TODO
    /**
     * Verlaedt die angegebenen Waren auf den Zug.
     * Jeder Waggon kann nur einen Typ Ware enthalten.
     * Waren werden immer in den erstmoeglichen Waggon geladen.
     * Uebersteigt das Gewicht die Kapazitaet eines Waggons, werden
     * die restlichen Waren in den naechstmoeglichen Waggon geladen.
     * @param ware Bezeichnung der Waren
     * @param gewicht Gewicht der zu verladenden Waren.
     * @return Das Gewicht der Waren, die nicht geladen werden konnten.
     */
    public int beladen(String ware, int gewicht){
        if (zugStehtMitMeldung()){
            for (Waggon waggon:waggons) {
                if (Objects.equals(waggon.gibWare(), ware)){
                    gewicht = waggon.beladen(ware, gewicht);
                } else if (waggon.gibWare() == null){
                    gewicht = waggon.beladen(ware, gewicht);
                }
                if(gewicht == 0){break;}
            }
        }
        if (gewicht != 0){
            System.out.println("Es konnte nicht die gesamte Ware verladen werden. Rest: " + gewicht);
        }
        return gewicht;
    }

    // TODO
    /**
     * Liefert den mittleren Waggon des Zuges.
     * Wenn es aufgrund einer geraden Zahl von Waggons keine Mitte gibt, wird null zurueckgegeben.
     * @return Der mittlere Waggon oder null.
     */
    public Waggon mittlererWaggon(){
        if(waggons.size()%2!=0){
            return waggons.get(waggons.size()/2);
        }else {return
        null;
        }
    }

    // TODO
    /**
     * Aendert die Geschwindigkeit des Zuges auf den uebergebenen Wert.
     * @param geschwindigkeit Geschwindigkeitsdelta.
     */
     public void geschwindigkeitAnpassen(int geschwindigkeit){
         this.lok.geschwindigkeitAnpassen(Math.max(0, this.lok.gibGeschwindigkeit()+geschwindigkeit));
     }

    public void printZug(){
         System.out.println("Geschindigkeit: \t" + lok.gibGeschwindigkeit());
         System.out.println("Gesamtgewicht: \t" + gibGesamtgewicht());
         System.out.println("Anzahl Waggons: \t" + anzahlWaggons());

    }

    public  void printWaggons(){

        for (int i = 0; i < waggons.size(); i++) {
            Waggon waggon = waggons.get(i);
            System.out.println("-------------------------");
            System.out.println("Waggon " + i);
            System.out.println("Ware: " + waggon.gibWare());
           // System.out.println("Kapazität"+ waggon.);
            System.out.println("Ladungsmenge: " + waggon.gibZuladung());
        }
        System.out.println("-------------------------");
    }

}

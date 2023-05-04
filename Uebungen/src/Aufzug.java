public class Aufzug {
    private int geschoss; // Variable, um die aktuelle Position des Aufzugs zu speichern
    private final int hoechstesGeschoss; // Variable, um die maximale Stockwerkshöhe zu speichern

    /**
     * Konstruktor, um eine neue Instanz von Aufzug zu erstellen
     *
     * @param obergeschosse Anzahl der Obergeschosse im Gebäude
     * @param hoechstesGeschoss Die maximale Stockwerkshöhe im Gebäude
     */
    public Aufzug(int obergeschosse, int hoechstesGeschoss) {
        this.geschoss = 0; // Setzt die aktuelle Position des Aufzugs auf das Erdgeschoss
        this.hoechstesGeschoss = hoechstesGeschoss; // Setzt die maximale Stockwerkshöhe
    }
    //factory method alternativer Kunstruktor with Exeption
    public static Aufzug newAufzugExeption(int obergeschosse, int hoechstesGeschoss){
        if(hoechstesGeschoss < 0){
            throw new IllegalArgumentException("hoechstesGeschoss darf nicht negativ sein");
        }
        return new Aufzug(obergeschosse, hoechstesGeschoss);
    }
    //factory method alternativer Kunstruktor
    public static Aufzug newAufzug(int obergeschosse, int hoechstesGeschoss){
        if(hoechstesGeschoss < 0){
            System.out.println("hoechstesGeschoss darf nicht negativ sein, zum Fortlaufen des Pogrammes wurde der Betrag des höchsten Geschosses übernommen");
            return new Aufzug(Math.abs(obergeschosse), Math.abs(hoechstesGeschoss));
        }else{
            return new Aufzug(obergeschosse, hoechstesGeschoss);
        }
    }
    /**
     * Bewegt den Aufzug um ein Stockwerk nach unten
     */
    public void fahreRunter(){
        if(geschoss > 0){ // Überprüft, ob der Aufzug nicht schon im Erdgeschoss ist
            geschoss--; // Bewegt den Aufzug um ein Stockwerk nach unten
        }else{
            System.out.println("Unterstes Geschoss bereits erreicht!"); // Gibt eine Fehlermeldung aus, wenn der Aufzug bereits im Erdgeschoss ist
        }
        System.out.println(aktuellesGeschoss()); // Gibt die aktuelle Position des Aufzugs aus
    }

    /**
     * Bewegt den Aufzug um ein Stockwerk nach oben
     */
    public void fahreHoch(){
        if(geschoss < hoechstesGeschoss){ // Überprüft, ob der Aufzug nicht schon das oberste Stockwerk erreicht hat
            geschoss++; // Bewegt den Aufzug um ein Stockwerk nach oben
        }else{
            System.out.println("Oberstes Geschoss bereits erreicht!"); // Gibt eine Fehlermeldung aus, wenn der Aufzug bereits das oberste Stockwerk erreicht hat
        }
        System.out.println(aktuellesGeschoss()); // Gibt die aktuelle Position des Aufzugs aus
    }

    public String aktuellesGeschoss(){
        String output;
        if(geschoss == 0){
            output = "Erdgeschoss";
        }else{
            output = geschoss+". Stock";
        }
        return output;
    }
}

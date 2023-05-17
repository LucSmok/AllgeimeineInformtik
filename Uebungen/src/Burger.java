// Importieren der DecimalFormat-Klasse aus der Java-Standardbibliothek
import java.text.DecimalFormat;

// Definition einer Klasse "Burger"
public class Burger {
    // Instanzvariablen für ein Burger-Objekt
    Bun bun;
    Patty patty;
    Sauce sauce;

    // Konstruktor-Methode für ein Burger-Objekt, der beim Erzeugen des Objekts aufgerufen wird
    public Burger() {
        // Initialisierung der Instanzvariablen mit Standardwerten
        this.bun = new Bun(200, "Weizen");
        this.patty = new Patty(450, false, 180);
        this.sauce = new Sauce(100, "BBQ", true);
    }

    // Setter-Methode für das Brötchen des Burgers
    public void setBun(Bun bun) {
        this.bun = bun;
    }

    // Setter-Methode für das Patty des Burgers
    public void setPatty(Patty patty) {
        this.patty = patty;
    }

    // Setter-Methode für die Sauce des Burgers
    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    // Methode zur Berechnung des Preises des Burgers
    public int gibPreis() {
        // Rückgabe der Summe der Preise für Brötchen, Patty und Sauce
        return this.bun.getPreis() + this.patty.getPreis() + this.sauce.getPreis();
    }

    // Methode zur Berechnung der Mehrwertsteuer des Burgers
    public int gibMehrwertsteuer() {
        // Berechnung der Mehrwertsteuer aus dem Gesamtpreis des Burgers
        return (int) (gibPreis() * (1-(1/1.11))+0.5); //+0.5 damit immer mathematisch korrekt gerundet wird.
    }

    // Methode zur Überprüfung, ob der Burger vegetarisch ist
    public boolean istVegetarisch() {
        // Rückgabe true, falls Patty und Sauce vegetarisch sind, sonst false
        if (patty.isVegetarisch() && sauce.isVegetarisch()){
            return true;
        }else{
            return false;
        }
    }

    // Methode zum Bestellen des Burgers mit der Angabe des Trinkgeldes
    public int bestellen(int trinkgeld) {
        // Ausgabe des Kassenbons mit der übergebenen Trinkgeldsumme
        printReceipt(trinkgeld);
        // Rückgabe des Gesamtpreises des Burgers und des Trinkgeldes
        return gibPreis() + Math.max(trinkgeld, 0);
    }

    // Methode zur Ausgabe des Kassenbons mit der Angabe des Trinkgeldes
    private void printReceipt(int trinkgeld) {
        // Erzeugung eines DecimalFormat-Objekts für die Formatierung des Preisangaben
        DecimalFormat f = new DecimalFormat("#0.00");
        // Ausgabe des Kassenbons
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println("Bestes Burger EU-West");
        System.out.println("---------------------------------");
        System.out.println((istVegetarisch())? "Veggi-Burger" : "Real-Burger" +":");
        System.out.println("* Bun: "+bun.getSorte());
        System.out.println("* Pattay: "+patty.getGewicht()+"g,\t\t"+ (patty.isVegetarisch()? "veg.":""));
        System.out.println("* Sauce: "+sauce.getName()+",\t"+ (sauce.isVegetarisch()? "veg.":""));
        System.out.println("---------------------------------");
        System.out.println("Preis:\t\t\t"+ f.format((double) gibPreis()/100) + " EUR");
        System.out.println("davon MwSt:\t\t"+ f.format((double) gibMehrwertsteuer()/100) + " EUR");
        System.out.println("Trinkgeld:\t\t"+ f.format((double) Math.max(trinkgeld, 0)/100) + " EUR");
        System.out.println("Gesamt:\t\t\t"+ f.format((double) (gibPreis()+Math.max(trinkgeld, 0))/100) + " EUR");
        System.out.println("---------------------------------");
        System.out.println("Vielen Dank, für Ihren Besuch :)");
        System.out.println();

    }

}

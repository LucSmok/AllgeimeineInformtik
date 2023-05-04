public class Rechteck {
    private double breite; // Breite des Rechtecks
    private double hoehe; // Höhe des Rechtecks

    // Konstruktor der Klasse Rechteck
    public Rechteck(double breite, double hoehe) {
        this.breite = Math.abs(breite); // Betrag der Breite wird gesetzt
        this.hoehe = Math.abs(hoehe); // Betrag der Höhe wird gesetzt
        System.out.println("Achtung von allen Werten wird nur mit dem Betrag gearbeitet"); // Hinweis auf Verwendung von Beträgen
    }

    // Getter-Methode für die Breite
    public double getBreite() {
        return breite;
    }

    // Getter-Methode für die Höhe
    public double getHoehe() {
        return hoehe;
    }

    // Setter-Methode für die Breite
    public void setBreite(double breite) {
        this.breite = Math.abs(breite); // Betrag der Breite wird gesetzt
        System.out.println("Achtung von allen Werten wird nur mit dem Betrag gearbeitet"); // Hinweis auf Verwendung von Beträgen
    }

    // Setter-Methode für die Höhe
    public void setHoehe(double hoehe) {
        this.hoehe = Math.abs(hoehe); // Betrag der Höhe wird gesetzt
        System.out.println("Achtung von allen Werten wird nur mit dem Betrag gearbeitet"); // Hinweis auf Verwendung von Beträgen
    }

    // Methode zur Berechnung der Fläche des Rechtecks
    public double gibFlaeche(){
        return breite*hoehe;
    }

    // Methode zur Überprüfung, ob es sich um ein Quadrat handelt
    public boolean istQuadrat(){
        return breite == hoehe;
    }

    // Methode zum Vergleich der Fläche mit einem anderen Rechteck
    public int vergleiche(Rechteck r){
        if (r.gibFlaeche() < this.gibFlaeche()){
            return -1;
        } else if (r.gibFlaeche()>this.gibFlaeche()) {
            return 1;
        } else {
            return 0;
        }
    }

    // Methode zum Ausgeben der Eigenschaften des Rechtecks
    public void printRechteck(){
        System.out.println("Breite:\t\t"+this.breite);
        System.out.println("Höhe:\t\t"+this.hoehe);
        System.out.println("Fläche:\t\t"+this.gibFlaeche());
        System.out.println("Quadrat:\t"+(this.istQuadrat()? "Ja":"Nein"));
    }
}

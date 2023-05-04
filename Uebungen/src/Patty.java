public class Patty {

    private int preis;
    private boolean vegetarisch;
    private int gewicht; //Gewicht in Gramm

    public Patty(int preis, boolean vegetarisch, int gewicht) {
        this.preis = preis;
        this.vegetarisch = vegetarisch;
        this.gewicht = gewicht;
    }

    public int getPreis() {
        return preis;
    }

    public boolean isVegetarisch() {
        return vegetarisch;
    }

    public int getGewicht() {
        return gewicht;
    }
}

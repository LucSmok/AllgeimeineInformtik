public class Sauce {
    private int preis;
    private String name;
    private boolean vegetarisch;

    public Sauce(int preis, String name, boolean vegetarisch) {
        this.preis = preis;
        this.name = name;
        this.vegetarisch = vegetarisch;
    }

    public int getPreis() {
        return preis;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarisch() {
        return vegetarisch;
    }
}

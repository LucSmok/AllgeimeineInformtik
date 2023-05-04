public class Main {
    public static void main(String[] args) {

        //Übung 2
        startBurgerStuff();
        startRechteckStuff();
        //startAufgabe1();

        //Übung 1
        //startAufzugStuff();
        //startLiedStuff();

    }

    private static void startAufgabe1() {
        //Double i = 2.0 % 2;
        //System.out.println(i.equals(0));
        System.out.println(5.0/3); //1.6666666666666667  wer beschränkt double oder Sys.out ???
        System.out.println(1 > 0 || !(!(7 < (28 - (1358 - 1337))) && true)); // reicht aus für true wegen oder
        System.out.println(1 > 0 || !(!(7 < (28 - (1358 - 1337))) && true) || (42 - (256 - 42) > (1337 - (42 + 1256))));

        //Übung 1
    }

    public static void startRechteckStuff() {
        Rechteck rechteck1 = new Rechteck(200, 400);
        Rechteck rechteck2 = new Rechteck(25, 400);

        System.out.println("Rechteck 1");
        rechteck1.printRechteck();
        System.out.println("Rechteck 2");
        rechteck2.printRechteck();

        System.out.println("Vergleich 1 mit 2: " + rechteck1.vergleiche(rechteck2));

        rechteck1.setBreite(25);
        rechteck1.setHoehe(25);
        rechteck2.setHoehe(25);

        System.out.println("Vergleich 1 mit 2: " + rechteck1.vergleiche(rechteck2));

        System.out.println("Rechteck 1");
        rechteck1.printRechteck();
        System.out.println("Rechteck 2");
        rechteck2.printRechteck();

        Rechteck rechteck3 = new Rechteck(-200, -400);
        Rechteck rechteck4 = new Rechteck(-25, 400);

        System.out.println("Rechteck 3");
        rechteck3.printRechteck();
        System.out.println("Rechteck 4");
        rechteck4.printRechteck();

        System.out.println("Vergleich 3 mit 4: " + rechteck3.vergleiche(rechteck4));

        rechteck3.setBreite(-25);
        rechteck3.setHoehe(-25);
        rechteck4.setHoehe(25);

        System.out.println("Vergleich 3 mit 4: " + rechteck3.vergleiche(rechteck4));

        System.out.println("Rechteck 3");
        rechteck3.printRechteck();
        System.out.println("Rechteck 4");
        rechteck4.printRechteck();

    }

    public static void startBurgerStuff(){
        Burger burger = new Burger();

        burger.bestellen(100);
        burger.setBun(new Bun(600, "Cobe Beef"));
        burger.setSauce(new Sauce(150, "Käse", false));
        burger.setBun(new Bun(300, "Brioche"));
        burger.bestellen(250);
        burger.setPatty(new Patty(280,true, 300));
        burger.setSauce(new Sauce(110, "Garlic", true));
        burger.bestellen(80);
    }

    public static void startLiedStuff(){
        Lied lied = new Lied("Humbel", "Nicolaus", 222);
        System.out.println(lied.gibFormatierteLaenge("a"));
        System.out.println(lied.gibFormatierteLaenge("s"));
        System.out.println(lied.gibFormatierteLaenge("m"));
        System.out.println(lied.gibFormatierteLaenge("h"));
        System.out.println(lied.gibTitel());
        System.out.println(lied.gibInterpret());
        System.out.println(lied.gibLaenge());
        lied.setzeLaenge(55);
        System.out.println(lied.gibLaenge());
        System.out.println(lied.toString());

    }

    public static void startAufzugStuff(){

        Aufzug[] aufzuege = new Aufzug[3];

        Aufzug aufzug = Aufzug.newAufzug(18, -5);
        Aufzug aufzug2 = new Aufzug(18, 5);
        Aufzug aufzug3 = new Aufzug(18, 5);

        aufzuege[0] = aufzug;
        aufzuege[1] = aufzug2;
        aufzuege[2] = aufzug3;

        for (Aufzug currentAufzug: aufzuege) {
            for (int i = 0; i < 3; i++) {
                currentAufzug.fahreHoch();
            }

            for (int i = 0; i < 3; i++) {
                currentAufzug.fahreRunter();
            }
        }

    }
}
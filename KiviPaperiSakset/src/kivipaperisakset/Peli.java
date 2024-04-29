package kivipaperisakset;

/**
 * Luokka edustaa kivipaperisakset-pelin pelilogiikkaa.
 * Peli koostuu pelaajien luonnista ja niiden vuoroista, kunnes jompikumpi pelaajista saavuttaa 3 voittoa.
 * Tasapelien määrä lasketaan ja tulostetaan jokaisen erän jälkeen.
 */
public class Peli {

    /**
     * Käynnistää kivipaperisakset-pelin luomalla kaksi pelaajaa, aloittamalla pelin ja ohjaamalla pelaajien vuoroja,
     * kunnes jompikumpi pelaajista saavuttaa 3 voittoa. Tulostaa pelitilanteen jokaisen erän jälkeen, mukaan lukien
     * pelaajien voittojen lukumäärä ja tasapelien määrä.
     *
     * @param args Komentoriviparametrit (ei käytetä tässä)
     */
    public static void main(String args[]) {

        // Pelaajien luonti
        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja();

        // Pelin luonti ja pelaajien asettaminen
        Peli peli = new Peli();
        peli.pelaaPeli(p1, p2);
    }

    /**
     * Aloittaa pelin antamalla pelaajille mahdollisuuden pelata kivipaperisaksia, kunnes jompikumpi pelaajista
     * saavuttaa 3 voittoa. Pelin jokaisen erän jälkeen tulostetaan pelitilanne, mukaan lukien pelaajien voittojen
     * lukumäärä ja tasapelien määrä.
     *
     * @param p1 Pelaaja 1
     * @param p2 Pelaaja 2
     */
    public void pelaaPeli(Pelaaja p1, Pelaaja p2) {

        boolean peliLoppui = false;
        int pelatutPelit = 1;
        int tasapelit = 0;

        do {

            // Tulostetaan pelitilanne
            tulostaPelitilanne(p1, p2, pelatutPelit, tasapelit);

            // Valitaan kivi, paperi tai sakset pelaajille
            String p1Valinta = p1.pelaajanValinta();
            String p2Valinta = p2.pelaajanValinta();
            System.out.println("Pelaaja 1: " + p1Valinta + "\nPelaaja 2: " + p2Valinta);

            // Tarkistetaan pelitilanne
            if (p1Valinta.equals(p2Valinta)) {
                tasapelit++;
                System.out.println("\n\t\t\t * Tasapeli! *");
            } else {
                tarkistaVoitto(p1, p2, p1Valinta, p2Valinta);
            }
            pelatutPelit++;

            // Peli päättyy, kun jompikumpi pelaajista saavuttaa 3 voittoa
            if (p1.getVoitot() >= 3 || p2.getVoitot() >= 3) {
                peliLoppui = true;
                System.out.println("\nKOLME VOITTOA - PELI PÄÄTTYY");
            }
            System.out.println();
        } while (!peliLoppui);
    }

    /**
     * Tulostaa pelitilanteen, mukaan lukien pelaajien voittojen lukumäärä ja tasapelien määrä.
     *
     * @param p1            Pelaaja 1
     * @param p2            Pelaaja 2
     * @param pelatutPelit  Pelattujen pelien määrä
     * @param tasapelit     Tasapelien määrä
     */
    public void tulostaPelitilanne(Pelaaja p1, Pelaaja p2, int pelatutPelit, int tasapelit) {
        System.out.println("Erä " + pelatutPelit + ": =====================\n");
        System.out.println("Pelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.");
        System.out.println("Pelaaja 2:llä koossa " + p2.getVoitot() + " voittoa.");
        System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");
    }

    /**
     * Tarkistaa, kumpi pelaajista voittaa pelin ja lisää voiton kyseiselle pelaajalle.
     *
     * @param p1Valinta     Pelaajan 1 valinta
     * @param p2Valinta     Pelaajan 2 valinta
     * @param p1            Pelaaja 1
     * @param p2            Pelaaja 2
     */
    public void tarkistaVoitto(Pelaaja p1, Pelaaja p2, String p1Valinta, String p2Valinta) {
        if ((p1Valinta.equals("kivi") && p2Valinta.equals("sakset")) ||
                (p1Valinta.equals("paperi") && p2Valinta.equals("kivi")) ||
                (p1Valinta.equals("sakset") && p2Valinta.equals("paperi"))) {
            System.out.println("\n\t\t\t * Pelaaja 1 voittaa! *");
            p1.addVoitto();
        } else {
            System.out.println("\n\t\t\t * Pelaaja 2 voittaa! *");
            p2.addVoitto();
        }
    }

}

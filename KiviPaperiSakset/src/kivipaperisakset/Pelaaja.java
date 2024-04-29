
package kivipaperisakset;

/**
 * Luokka edustaa yhtä pelin pelaajista kivipaperisaksipeli-sovelluksessa.
 * Pelaajalla on voittojen lukumäärä sekä mahdollisuus valita kivi, paperi tai sakset.
 */
public class Pelaaja {

    int voitot;      // Voittojen lukumäärä

    /**
     * Luo uuden pelaajan, jolla ei ole vielä yhtään voittoa.
     */
    public Pelaaja() {
        voitot = 0;
    }

    /**
     * Arpoo ja palauttaa pelaajan valinnan kivestä, paperista tai saksesta.
     *
     * @return pelaajan valinta: "kivi", "paperi" tai "sakset"
     */
    public String pelaajanValinta() {
        String valinta = "";
        int c = (int) (Math.random() * 3);
        switch (c) {
            case 0:
                valinta = ("kivi");
                break;
            case 1:
                valinta = ("paperi");
                break;
            case 2:
                valinta = ("sakset");
                break;
        }
        return valinta;
    }

    /**
     * Lisää yhden voiton pelaajan voittolukumäärään.
     */
    public void addVoitto() {
        voitot++;
    }

    /**
     * Palauttaa pelaajan voittojen lukumäärän.
     *
     * @return pelaajan voittojen lukumäärä
     */
    public int getVoitot() {
        return (voitot);
    }

}

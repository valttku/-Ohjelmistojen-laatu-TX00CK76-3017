package test;

import static org.junit.jupiter.api.Assertions.*;

import kivipaperisakset.Pelaaja;
import kivipaperisakset.Peli;
import org.junit.jupiter.api.*;

/**
 * Testiluokka Peli-luokan testaamiseen.
 */
public class PeliTest {

    private Peli peli;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;

    /**
     * Alustaa testiympäristön jokaisen testin alussa.
     */
    @BeforeEach
    void setUp() {
        peli = new Peli();
        pelaaja1 = new Pelaaja();
        pelaaja2 = new Pelaaja();
    }

    /**
     * Testaa pelin päättymisen, kun jompikumpi pelaaja saavuttaa 3 voittoa.
     */
    @Test
    void testPelaaPeli() {
        peli.pelaaPeli(pelaaja1, pelaaja2);
        int voitot1 = pelaaja1.getVoitot();
        int voitot2 = pelaaja2.getVoitot();
        // Peli päättyy, kun jompikumpi pelaaja saavuttaa 3 voittoa
        assertTrue(voitot1 == 3 || voitot2 == 3);
        // Varmistetaan, ettei kumpikaan pelaaja ole saavuttanut 3 voittoa
        assertFalse(voitot1 == 3 && voitot2 == 3);
    }

    /**
     * Testaa voiton tarkistamisen toimivuuden.
     */
    @Test
    void testTarkistaVoitto() {
        // Testataan pelaajan 1 voitot
        pelaaja1.addVoitto();
        peli.tarkistaVoitto(pelaaja1, pelaaja2, "kivi", "sakset");
        assertEquals(2, pelaaja1.getVoitot());
        // Testataan pelaajan 2 voitot
        peli.tarkistaVoitto(pelaaja1, pelaaja2, "sakset", "kivi");
        assertEquals(1, pelaaja2.getVoitot());
    }

}

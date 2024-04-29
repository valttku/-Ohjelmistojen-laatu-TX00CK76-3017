package test;

import static org.junit.jupiter.api.Assertions.*;

import kivipaperisakset.Pelaaja;
import org.junit.jupiter.api.*;

/**
 * Testiluokka Pelaaja-luokan testaamiseen.
 */
public class PelaajaTest {

    private Pelaaja pelaaja;

    /**
     * Alustaa testiympäristön jokaisen testin alussa.
     */
    @BeforeEach
    void setUp() {
        pelaaja = new Pelaaja();
    }


    /**
     * Testaa pelaajan valinnan toimivuuden.
     */
    @Test
    void testPelaajanValinta() {
        String valinta = pelaaja.pelaajanValinta();
        assertNotNull(valinta);
        assertTrue(valinta.equals("kivi") || valinta.equals("paperi") || valinta.equals("sakset"));
    }

    /**
     * Testaa voittojen lisäämisen toimivuuden.
     */
    @Test
    void testAddVoitto() {
        assertEquals(0, pelaaja.getVoitot());
        pelaaja.addVoitto();
        assertEquals(1, pelaaja.getVoitot());
    }

    /**
     * Testaa voittojen hakemisen toimivuuden.
     */
    @Test
    void testGetVoitot() {
        assertEquals(0, pelaaja.getVoitot());
    }

}

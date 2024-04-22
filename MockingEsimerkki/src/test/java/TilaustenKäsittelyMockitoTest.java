import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;
import org.mockito.*;

public class TilaustenKäsittelyMockitoTest {

	private TilaustenKäsittely käsittelijä;
	
	@Mock
	IHinnoittelija hinnoittelijaMock;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
        käsittelijä = new TilaustenKäsittely();
        käsittelijä.setHinnoittelija(hinnoittelijaMock);
	}
	
	/*
	@Test
	public void testaaKäsittelijäWithMockitoHinnoittelija() {
		// Arrange
		float alkuSaldo = 100.0f;
		float listaHinta = 30.0f;
		float alennus = 20.0f;
		float loppuSaldo = alkuSaldo - (listaHinta * (1 - alennus / 100));
		
		Asiakas asiakas = new Asiakas(alkuSaldo);
		Tuote tuote = new Tuote("TDD in Action", listaHinta);
		// Record
		when(hinnoittelijaMock.getAlennusProsentti(asiakas, tuote))
		.thenReturn(alennus);
		
		// Act
		TilaustenKäsittely käsittelijä = new TilaustenKäsittely();
		käsittelijä.setHinnoittelija(hinnoittelijaMock);
		käsittelijä.käsittele(new Tilaus(asiakas, tuote));
		
		// Assert
		assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
		verify(hinnoittelijaMock).getAlennusProsentti(asiakas, tuote);
	}*/

	
    @Test
    public void testKäsittelijäHintaAlle100() {
    	
        // Arrange
        float alkuSaldo = 100.0f;
        float listaHinta = 80.0f; // Tuotteen hinta 80
        float alennus = 20.0f;
        float loppuSaldo = alkuSaldo - (listaHinta * (1 - alennus / 100));

        Asiakas asiakas = new Asiakas(alkuSaldo);
        Tuote tuote = new Tuote("Testituote", listaHinta);
        
        // Record
        when(hinnoittelijaMock.getAlennusProsentti(asiakas, tuote)).thenReturn(alennus);

        // Act
        käsittelijä.käsittele(new Tilaus(asiakas, tuote));
    
        // Assert
        assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
        verify(hinnoittelijaMock, atLeast(1)).getAlennusProsentti(asiakas, tuote);
        verify(hinnoittelijaMock).aloita();
        verify(hinnoittelijaMock).lopeta();
    }
    
    @Test
    public void testKäsittelijäHintaYli100() {
    	
        // Arrange
        float alkuSaldo = 100.0f;
        float listaHinta = 120.0f; // Tuotteen hinta 120
        float alennus = 50.0f;
        float loppuSaldo = alkuSaldo - (listaHinta * (1 - alennus / 100));

        Asiakas asiakas = new Asiakas(alkuSaldo);
        Tuote tuote = new Tuote("Testituote", listaHinta);
        
        // Record
        when(hinnoittelijaMock.getAlennusProsentti(asiakas, tuote)).thenReturn(alennus);

        // Act
        käsittelijä.käsittele(new Tilaus(asiakas, tuote));

        // Assert
        assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
        verify(hinnoittelijaMock, atLeast(1)).getAlennusProsentti(asiakas, tuote);
        verify(hinnoittelijaMock).aloita();
        verify(hinnoittelijaMock).lopeta();
    }
	
}


 public class FakeHinnoittelija implements IHinnoittelija {
	 
	 private float alennus;
	 
	 public FakeHinnoittelija(float alennus) {
		 this.alennus = alennus;
	 }
	 
	 public float getAlennusProsentti(Asiakas asiakas, Tuote tuote) {
		 return alennus;
	 }

	@Override
	public void setAlennusProsentti(Asiakas asiakas, float prosentti) {
		//
	}

	@Override
	public void aloita() {
		System.out.println("Aloitetaan...");
	}

	@Override
	public void lopeta() {
		System.out.println("Lopetetaan...");
	}
	 
 }

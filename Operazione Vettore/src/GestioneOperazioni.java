import java.util.Random;

public class GestioneOperazioni implements IOperazioneVettore{

	private static final int NUM_MAX_NUMERI = 100;

	

	public int[] generaNumeriCasuali() {
		Random rand = new Random();
		int[] vet = new int[NUM_MAX_NUMERI];
		
		for (int i=0; i<NUM_MAX_NUMERI; i++) {
			vet[i] =  rand.nextInt(101);
			System.out.print(" "+vet[i]+",");
		}
		System.out.println("\n");
		return vet;
	}



	public void somma(int[] vet, int num) {
		for (int i=0; i<NUM_MAX_NUMERI; i++) {
			vet[i] += num;
			System.out.print(" "+vet[i]+",");
		}
		
	}

	public static void main(String[]args) {
	GestioneOperazioni gOp = new GestioneOperazioni();
	int[] vet = new int[NUM_MAX_NUMERI];
	vet = gOp.generaNumeriCasuali();
	gOp.somma(vet, 5);
	}


}

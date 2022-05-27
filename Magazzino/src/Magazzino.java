import java.util.Random;

public class Magazzino {

	private Prodotto elencoProdotti[];
	private int index;
	
	public Magazzino() {
		elencoProdotti = new Prodotto[100];
		index = 0;
	}
	
	public void venidtaProdotto(String nome, int qta) throws ScortaMinimaException{
		
		for (int i=0; i< index; i++) {
		if (elencoProdotti[i].getNome().equals(nome)&&(elencoProdotti[i]!=null)) {
			elencoProdotti[i].setQuantita(elencoProdotti[i].getQuantita()-qta);
			
			if((elencoProdotti[i].getQuantita() -qta)>= elencoProdotti[i].getQtaMinima()){
				throw new ScortaMinimaException("non c'e abbastanza scorta minima");
			}
		}
		}
	}
	public static void main(String[]args) {
		for (int i = 0; i<22; i++) {
			Random num = new Random();
	     int numero =  num.nextInt(2);
	      System.out.println(""+numero);
		}
	}
}

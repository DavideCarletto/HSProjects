package negozioStrumenti;

import util.Tastiera;

public class Negozio {
		static Tastiera t1 = new Tastiera();
		static Strumento negozio[] = new Strumento[4];
		
		
		public void visualizzaStrumento() {
			int i=0;
			for (i=0; i<4; i++);{
				System.out.println(+negozio[i].getCodice()+","+negozio[i].getTipo()+","+negozio[i].getPrezzo());
			}
		}
		public void calcolaPrezzoMinore(){
			float conta = 100000;
			int i=0;
			
			for (i=0; i<4; i++);{
				if (negozio[i].getPrezzo()<conta) {
					conta=negozio[i].getPrezzo();
				}
				System.out.println("il prezzo minore e'"+conta);
			}
		}
		
		public static void main(String[]args) {
			Negozio neg = new Negozio();
			
			for (int i=0; i<4; i++) {
				Strumento s = new Strumento(t1.leggiNumeroIntero("inserisci il codice dello strumento: "),t1.leggiNumero("Che strumento e'? "),t1.leggiNumeroFloat("Inserisci il prezzo:"));
				negozio [i]= s;
			}
			
			neg.visualizzaStrumento();
			neg.calcolaPrezzoMinore();
		}
}

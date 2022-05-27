package liceocuneo.figure;

public class InserimentoException extends Exception{

	
	public InserimentoException  (String msg) {
		super(msg);
	}
	
	public  void inserisciPrimitiva(String comando1) throws InserimentoException {
		if((comando1.equals("RETTANGOLO")==false) &&(comando1.equals("CERCHIO")==false)&&(comando1.equals("LINEA")==false)) {
			throw new InserimentoException  ("hai scritto in modo errato la parola chiave");
		}
		
	}
	
}

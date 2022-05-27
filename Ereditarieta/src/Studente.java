import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Studente extends Persona {
	
	private String matricola;
	

	public Studente(String cognome, String nome, String matricola) {
		super(cognome,nome);
		this.matricola=matricola;
		// TODO Auto-generated constructor stub
		
	}
	/*se tolgo tutta la parte sopra non da errore.**/

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	public void stampaDati() {
		System.out.println(this.getCognome()+" "+this.getNome());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(sdf.format(getDataNascita().getTime()));
	}

}

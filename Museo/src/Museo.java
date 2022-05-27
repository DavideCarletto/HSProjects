
public class Museo {

	private String nome;
	private String luogo;
	private OperaArte elencoOpere[];
	private int index = 0;
	
	public Museo(String nome, String luogo) {
		super();
		this.nome = nome;
		this.luogo = luogo;
	}

	public String getNome() {
		return nome;
	}

	public String getLuogo() {
		return luogo;
	}

	public OperaArte[] getElencoOpere() {
		return elencoOpere;
	}
	
	public String toString() {
		return "NOME: "+getNome()+" LUOGO:"+getLuogo();
	}
	
	public void addOpera(OperaArte opera) {
		elencoOpere[index++] = opera;
	}
	
	public void visualizzaOpereMuseo() {
		for (int i=0;i<index; i++) {
			System.out.println(elencoOpere[i].toString());
		}
		
	}
}

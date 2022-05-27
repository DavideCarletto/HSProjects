
public class Museo {

	private String nome;
	private String luogo;
	private OperaArte elencoOpere[];
	private  int index = 0;
	private static final int NUM_MAX_OPERE = 20;
	
	public Museo(String nome, String luogo) {
		super();
		this.nome = nome;
		this.luogo = luogo;
		elencoOpere = new OperaArte[NUM_MAX_OPERE];
	}

	public String getNome() {
		return nome;
	}

	public String getLuogo() {
		return luogo;
	}
	
	public String toString() {
		return "Nome: "+getNome()+", Luogo:"+getLuogo();
	}
	public void aggiungiOpera(OperaArte opera) {
		
		elencoOpere[index++] = opera;
	}
	
	public OperaArte[] getElencoOpere() {
		return elencoOpere;
	}

	public void visualizzaOpere() {
		
	
			for (int i=0; i<index; i++) {
					System.out.print(""+(i+1)+"- ");
					if(elencoOpere[i]!= null) {
					System.out.println(elencoOpere[i].toString());
					}
					else
						System.out.println("Opera trasferita");
				}
		
		}
	}
	



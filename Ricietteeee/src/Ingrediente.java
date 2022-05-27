
public class Ingrediente {

	private String nome;

	public Ingrediente(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		
		return "Ingrediente [nome=" + nome + "]";
	}
	 

}

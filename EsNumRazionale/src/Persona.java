
public class Persona {

	private String codfiscale; //String essendo una variabile di tipo classe avrebbe bisogno di una new, ma per comodit� non di mette *

	public String getCodfiscale() {
		return codfiscale.toUpperCase(); //toUpperCase() � una funzione di tipo String
	}

	public void setCodfiscale(String codfiscale) {
		if (codfiscale.length() == 16)
		this.codfiscale = codfiscale;
	}
	
	
}

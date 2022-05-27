
public class ParolaIta {
	private String parola;
	

	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	
	public void visualizza() {
		System.out.println("La parola visualizzata e' "+parola);
	}
	public String inverti() {
		
		String testoinv = null;
		for (int i=0; i<parola.length(); i++) {
			char c;
			c= parola.charAt(parola.length()-i-1);
			testoinv= testoinv + c;	
		}
		return testoinv;
	}
	public boolean isPalindroma() {
	
		return parola.equals(inverti());
	}
}

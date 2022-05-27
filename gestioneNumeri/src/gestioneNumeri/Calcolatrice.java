package gestioneNumeri;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Calcolatrice {

	private static final String bit0 = "0";
	private static final String bit1 = "1";
	
	public float radQuadrata(float numero) {
		return (float) Math.sqrt(numero);
	}
	public float pow2(float numero) {
		return (float) Math.pow(numero, 2);
	}
	public float pow3(float numero) {
		return (float) Math.pow(numero, 3);
	}
	public float inversione(float numero) {
		return numero*(-1);
	}
	public float valAssoluto(float numero) {
		if(numero<0) {
			numero = numero*(-1);
		}
		return numero;
	}
	public int parteIntera(float numero) {
		String stringa = String.valueOf(numero);
		int indice = stringa.indexOf('.');
		return  Integer.parseInt(stringa.substring(0,indice));
	}
	public float parteDecimale(float numero) {
		String stringa = String.valueOf(numero);
		int indice = stringa.indexOf('.');
		return Float.parseFloat(stringa.substring(indice));
	}
	public String conversioneBinario(float numero) {
		boolean value=false;
		String numeroCompleto="";
		if(numero<0) {
			value = true;
			numero = numero*(-1);
		}
		
		int parteIntera = parteIntera(numero);
		float parteDecimale = parteDecimale(numero);
		if((numero%1)==0) {
		numeroCompleto =convertiParteIntera(parteIntera);
		}else {
		String numeroBinario = ""+convertiParteIntera(parteIntera)+"."+convertiParteDecimaleBinario(parteDecimale);
		System.out.println("\nnumero converito:\n"+numeroBinario);
		numeroCompleto = floatingPoint(numeroBinario,value);
		}
		return numeroCompleto;
	}
	public String convertiParteIntera(int parteIntera) {
		String numeroStringa="";
		
		do {
			if((parteIntera%2)==0) {
				parteIntera = parteIntera/2;
				numeroStringa+=bit0;
			}if((parteIntera%2)==1) {
				parteIntera = parteIntera/2;
				numeroStringa+=bit1;
			}
		}while(parteIntera!=0);
		return inverti(numeroStringa);

	}
	public String convertiParteDecimaleBinario(float parteDecimale) {
		String numeroStringa = "";
		float tuttiNumeri[] = new float [100000];
		int conta =0;
		tuttiNumeri[conta++]=parteDecimale;
		float moltiplicato=0;
		do {
			
			 moltiplicato = new BigDecimal(parteDecimale*2f).setScale(20, BigDecimal.ROUND_HALF_UP).floatValue();
			if(moltiplicato<1f) {
				numeroStringa+=bit0;
			}else if(moltiplicato>1f) {
				moltiplicato = moltiplicato-1f;
				numeroStringa+=bit1;
			}else if(moltiplicato==1f) {
				moltiplicato = 1f;
				numeroStringa+=bit1;
			}
			for(int i=0; i<conta; i++) {
				if(moltiplicato==tuttiNumeri[i]) {
					numeroStringa+=bit1;
					moltiplicato = 1f;
					break;
				}
			}
			tuttiNumeri[conta++]+=moltiplicato;
			parteDecimale = moltiplicato;
			
		}while((moltiplicato!=1f));
		
		return numeroStringa;
	}
	public String inverti(String numeroStringa) {
		String testoInv = "";
		for (int i=0; i<numeroStringa.length(); i++) {
			char c;
			c= numeroStringa.charAt(numeroStringa.length()-i-1);
			testoInv= testoInv + c;	
		}
		return testoInv;
	}
	
	public String floatingPoint(String numeroBinario,boolean value) {
		int indice = numeroBinario.indexOf('.')-1;
		String mantissa = numeroBinario.substring(1,indice+1)+numeroBinario.substring(indice+2);
		String esponente = convertiParteIntera(indice + 127);
		if(value==false) {
			numeroBinario = "|"+bit0+"|";
		}else {
			numeroBinario = "|"+bit1+"|";
		}
		numeroBinario += esponente+"|"+mantissa+"|";
		
		
		return numeroBinario;
	}
	
	public String conversioneOttale(float numero) {
		if(numero<0) {
			numero = numero*(-1);
		}
		String stringa = String.valueOf(numero);
		int indice = stringa.indexOf('.');
		int parteIntera = parteIntera(numero);
		float parteDecimale = parteDecimale(numero);
		String numeroCompleto = "";
		if((numero%1)==0) {
			numeroCompleto = convertiParteInteraOttale(parteIntera);
			}else {
			 numeroCompleto=""+convertiParteInteraOttale(parteIntera)+"."+convertiParteDecimaleOttale(parteDecimale);
	}
		return numeroCompleto;
		}
	public String convertiParteInteraOttale(int parteIntera) {
		String numeroStringa="";
		
			do {
				int resto = parteIntera%8;
				parteIntera = parteIntera/8;
				numeroStringa+=String.valueOf(resto);
				
			}while(parteIntera!=0);
			return inverti(numeroStringa);
		}
	public String convertiParteDecimaleOttale(float parteDecimale) {
		String numeroStringa = "";
		float tuttiNumeri[] = new float [100000];
		int conta =0;
		tuttiNumeri[conta++]=parteDecimale;
		float moltiplicato=0;
		boolean value = true;
		do {
			 moltiplicato = new BigDecimal(parteDecimale*8f).setScale(20, BigDecimal.ROUND_HALF_UP).floatValue();
				if(moltiplicato%1f!=0) {
					parteDecimale = parteDecimale(moltiplicato);
				}else {
					value = false;
				}
				for(int i=0; i<conta; i++) {
					if(moltiplicato==tuttiNumeri[i]) {
						value = false;
						break;
					}
				}
				numeroStringa+= parteIntera(moltiplicato);
				tuttiNumeri[conta++]+=moltiplicato;
			}while(value ==true);
		return numeroStringa;
		}	
	
	public String conversioneEsadecimale(float numero) {
		if(numero<0) {
			numero = numero*(-1);
		}
		String stringa = String.valueOf(numero);
		int indice = stringa.indexOf('.');
		int parteIntera = parteIntera(numero);
		float parteDecimale = parteDecimale(numero);
		String numeroCompleto= "";
		if(numero%1==0) {
		numeroCompleto = parteInteraEsadecimale(parteIntera);
		}else {
			numeroCompleto = parteInteraEsadecimale(parteIntera)+"."+parteDecimaleEsadecimale(parteDecimale);
		}
		return numeroCompleto;
	}
	public String parteInteraEsadecimale(int parteIntera) {
		String numeroStringa="";

		do {
			String resto = String.valueOf(parteIntera%16);
			parteIntera = parteIntera/16;
			switch(Integer.parseInt(resto)) {
			case 10:
				resto = "A";
				break;
			case 11:
				resto = "B";
				break;
			case 12:
				resto = "C";
				break;
			case 13:
				resto = "D";
				break;
			case 14:
				resto = "E";
				break;
			case 15:
				resto = "F";
				break;
			}
			numeroStringa+=resto;
			
		}while(parteIntera!=0);
		return inverti(numeroStringa);
		
	}
	
	public String parteDecimaleEsadecimale(float parteDecimale) {
		String numeroStringa = "";
		float tuttiNumeri[] = new float [100000];
		int conta =0;
		tuttiNumeri[conta++]=parteDecimale;
		float moltiplicato=0;
		boolean value = true;
		do {
			 moltiplicato = new BigDecimal(parteDecimale*16f).setScale(20, BigDecimal.ROUND_HALF_UP).floatValue();
			if(moltiplicato%1f!=0) {
		
				if(moltiplicato<10) {
					numeroStringa += String.valueOf(parteIntera(moltiplicato));
				}
				switch (parteIntera(moltiplicato)) {
				case 10:
					 numeroStringa += "A";
					
					break;
				case 11:
					numeroStringa += "B";
					break;
				case 12:
					numeroStringa+= "C";
					break;
				case 13:
					numeroStringa += "D";
					break;
				case 14:
					numeroStringa+= "E";
					break;
				case 15:
					numeroStringa += "F";
					break;
				}
				 moltiplicato = moltiplicato-parteIntera(moltiplicato);
			}else {
				if(moltiplicato<10) {
					numeroStringa += String.valueOf(parteIntera(moltiplicato));
				}
				switch ((int)(moltiplicato)) {
				case 10:
					 numeroStringa += "A";
					break;
				case 11:
					numeroStringa += "B";
					break;
				case 12:
					numeroStringa+= "C";
					break;
				case 13:
					numeroStringa += "D";
					break;
				case 14:
					numeroStringa+= "E";
					break;
				case 15:
					numeroStringa += "F";
					break;
				}
				value = false;
			}
				for(int i=0; i<conta; i++) {
					if(moltiplicato==tuttiNumeri[i]) {
						value = false;
						break;
					}
				}
				tuttiNumeri[conta++]+=moltiplicato;
				parteDecimale = moltiplicato;
			}while(value ==true);
		return numeroStringa;
	}
}


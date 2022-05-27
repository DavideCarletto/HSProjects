package gestioneNumeri;

import java.util.Scanner;

public class Matematica {
	static Scanner s = new Scanner(System.in);
	
	public int menuUtente() {
		System.out.println("\nMENU UTENTE");
		System.out.print("1- Radice quadrata   ");
		System.out.print("2- Potenza di 2   ");
		System.out.print("3- Potenza di 3   ");
		System.out.print("4- Inversione   ");
		System.out.println("5- Valore assoluto   ");
		System.out.print("6- Converti in binario   ");
		System.out.print("7- Converti in ottale   ");
		System.out.print("8- Converti in esadecimale   ");
		System.out.println("9- Uscita   ");
		System.out.print("Scegli:");
		return s.nextInt();
	}
	public static void main(String[] args) {
		Matematica mat = new Matematica();
		Calcolatrice calc = new Calcolatrice();
		
		int opz= 0;
		System.out.println("Inserisci un numero: ");
		float numero = s.nextFloat();
		do {
			opz= mat.menuUtente();
		
			switch(opz) {
			
			case 1:
				System.out.println("\nRadice Quadrata del numero = "+calc.radQuadrata(numero));
				break;
			case 2:
				System.out.println("\npotenza di 2 del numero = "+calc.pow2(numero));
				break;
			case 3:
				System.out.println("\npotenza di 3 del numero = "+calc.pow3(numero));
				break;
			case 4:
				System.out.println("\nnumero con segno invertito = "+calc.inversione(numero));
				break;
			case 5:
				System.out.println("\nnumero con valore assoluto = |"+calc.valAssoluto(numero)+"|");
				break;
			case 6:
				System.out.println("\nnumero convertito in binario = "+calc.conversioneBinario(numero));
				break;
			case 7:
				System.out.println("\nnumero convertito in Ottale = "+calc.conversioneOttale(numero));
				break;
			case 8:
				System.out.println("\nnumero convertito in esadecimale = "+calc.conversioneEsadecimale(numero));
				break;
			case 9:
				System.out.println("Arrivederci :)");
				break;
				
			}
		}while(opz!=9);
		
	}

}

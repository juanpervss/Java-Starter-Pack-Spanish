package nuevoTema;

import java.util.Random;
import java.util.Scanner;

public class dadosMagicos {

	public static void main(String[] args) {
		menuPrincipal();
	}

	public static void menuPrincipal() {
		System.out.println("---------- DADOS MAGICOS ----------");
		System.out.println("Seleccione el numero de caras que quiere que tenga el dado");
		System.out.println("El minimo de caras es 2");
		System.out.println("Disponemos solo de dados de hasta 20 caras");
		System.out.println("-----------------------------------");
		Scanner sc = new Scanner(System.in);
		String aux = "";
		int numeroCaras = 0;
		aux = sc.nextLine();
		numeroCaras = Integer.parseInt(aux);
		if (numeroCaras >= 2 && numeroCaras <= 20) {
			sacarDado(numeroCaras);
		} else {
			System.out.println("---------- DADOS MAGICOS ----------");
			System.out.println("Solo hay dados de longitud 2-20");
			menuPrincipal();
		}
	}

	public static void sacarDado(int numeroCaras) {
		System.out.println("---------- DADOS MAGICOS ----------");
		Random rd = new Random();
		int valorDado = rd.nextInt(2, numeroCaras + 1);
		System.out.println("El dado con " + numeroCaras + " caras ha sacado el numero: " + valorDado);
	}
}

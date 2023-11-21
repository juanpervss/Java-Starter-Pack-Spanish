package clase;

import java.util.Scanner;

public class PrimerJuegoV2 {

	public static void main(String[] args) {

		iniciarJuego();
	}

	public static void iniciarJuego() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Si quieres jugar pon 1, en caso negativo pon cualquier otra cosa: ");
		int aux = 0;
		try {
			aux = sc.nextInt();
			sc.nextLine();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (aux == 1) {
			for(int i=0;i<5;i++){
				System.out.println("");
			}
			
			System.out.println("Bien, veo que has elegido jugar al juego, es facil solo ves diciendo numeros del");
			System.out.println("0-99 y trata de adivinar que numero estamos pensando, disfruta del juego y reta a tus amigos!!!");
			sacarNumRandom();
		} else {
			for(int i=0;i<5;i++){
				System.out.println("");
			}
			acabarFuncion();
		}
	}

	public static void sacarNumRandom() {
		int num = (int) (Math.random() * 100);
		System.out.println("----------------------");
		System.out.println("Ayudita para el deleveloper (no voy a probar 100 numeros :) " + num);
		System.out.println("----------------------");
		insertarNumero(num);
	}

	public static void insertarNumero(int num) {
		Scanner sc = new Scanner(System.in);
		System.out.print("");
		System.out.print("Introduce un numero del 0-99: ");
		try {
			int numUsuario = sc.nextInt();
			sc.nextLine();
			comprobarNumero(numUsuario, num);
		} catch (Exception e) {
			for(int i=0;i<5;i++){
				System.out.println("");
			}
			System.out.println("Eres un fucking tonto, no sirves ni pa poner un numero que tienes que poner letras");
			System.out.println("Como veo que te cuesta reiniciamos el juego");
			sacarNumRandom();
		}

	}

	public static void comprobarNumero(int numUsuario, int num) {
		if (numUsuario > 100) {
			System.out.println("Eres langui, tiene que ser menor que 100 palurdo");
		} else if (numUsuario < 0) {
			System.out.println("Eres langui, tiene que ser mayor que 0 palurdo");
		} else if (numUsuario > num) {
			System.out.println("El numero es menor");
		} else if (numUsuario < num) {
			System.out.println("El numero es mayor");
		} else {
			System.out.println("Has adivinado el numero!!!");
			iniciarJuego();
		}
		insertarNumero(num);
	}
	public static void acabarFuncion() {
		System.out.println("Acabé...");
	}
}

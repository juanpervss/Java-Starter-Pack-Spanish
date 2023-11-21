package juegosClase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AhorcadoJuegoFix {

	public static void main(String[] args) {
		menuPrincipal();
	}
	
	public static void menuPrincipal() {
		System.out.println("--------JUEGO AHORCADO--------");
		System.out.println("Que deseas hacer?");
		System.out.println("Jugar");
		System.out.println("Salir");
		System.out.println("-----------------------------");
		Scanner sc = new Scanner(System.in);
		String txt = "";
		txt = sc.nextLine().toLowerCase();
		if(txt.equals("jugar")) {
			System.out.println("Perfecto! Empecemos!!!");
			iniciarJuego();
		}else if (txt.equals("salir")) {
			System.out.println("Hasta pronto!!!");
		}else {
			System.out.println("Pon algo valido.");
			menuPrincipal();
		}
	}
	
	public static void iniciarJuego() {
		List<String> palabras = new ArrayList<String>();
		List<Character> caracteres = new ArrayList<Character>();
		for (int i = 0; i < 4; i++) {
			meterPalabras(palabras);
		}
		String txt = "";
		txt = elegirPalabra(palabras);
		int contador = txt.length();
		char[] comprobarWin = new char[txt.length()];
		for (int i = 0; i < comprobarWin.length; i++) {
			comprobarWin[i] = '_';
		}
		System.out.println("--------JUEGO AHORCADO--------");
		System.out.print(""
				+ "----|\r\n"
				+ "|   |\r\n"
				+ "|   O\r\n"
				+ "|  -|-\r\n"
				+ "|  / \\     ");
		for (int i = 0; i < comprobarWin.length; i++) {
			System.out.print(comprobarWin[i] + " ");
		}
		System.out.println("");
		System.out.println("-----------------");
		for (int i = txt.length() + 5; i >= 0; i--) {
			System.out.println("Tienes: " + i + " intento/s");
			meterLetras(palabras, caracteres);
			contador = comprobarVictoria(palabras, caracteres, comprobarWin, contador, txt);
			System.out.println("--------JUEGO AHORCADO--------");
			System.out.print(""
					+ "----|\r\n"
					+ "|   |\r\n"
					+ "|   O\r\n"
					+ "|  -|-\r\n"
					+ "|  / \\     ");
			for (int j = 0; j < comprobarWin.length; j++) {
				System.out.print(comprobarWin[j] + " ");
			}
			System.out.println("");
			System.out.println("-----------------");
			if (contador == 0) {
				System.out.println("Enhorabuena has ganado!!!!!!!");
				break;
			}
			if (i == 0) {
				System.out.println("Has perdido!!!!!");
			}
		}
	}
	
	public static void meterPalabras(List<String> palabras) {
		System.out.println("--------JUEGO AHORCADO--------");
		System.out.println("Introduce una palabra: ");
		Scanner sc = new Scanner(System.in);
		String txt = "";
		txt = sc.nextLine().toLowerCase();
		if (palabras.contains(txt)) {
			System.out.println("Esta palabra ya esta puesta merluzo");
			meterPalabras(palabras);
		} else {
			palabras.add(txt);
		}
	}

	public static String elegirPalabra(List<String> palabras) {
		int num = -1;
		num = (int) (Math.random() * 3);
		System.out.println(num);
		String txt = "";
		if (num == 0) {
			txt = palabras.get(0);
		} else if (num == 1) {
			txt = palabras.get(1);
		} else if (num == 2) {
			txt = palabras.get(2);
		} else if (num == 3) {
			txt = palabras.get(3);
		} else {
			elegirPalabra(palabras);
		}
		return txt;
	}

	public static void meterLetras(List<String> palabras, List<Character> caracteres) {
		System.out.println("Agregue una letra: ");
		Scanner sc = new Scanner(System.in);
		char car = ' ';
		car = sc.nextLine().charAt(0);
		if (caracteres.contains(car)) {
			System.out.println("Este caracter ya esta ingresado");
			meterLetras(palabras, caracteres);
		} else {
			caracteres.add(car);
		}
	}

	public static int comprobarVictoria(List<String> palabras, List<Character> caracteres, char[] comprobarWin,
			int contador, String txt) {
		for (int i = 0; i < txt.length(); i++) {
			for (int j = 0; j < caracteres.size(); j++) {
				if (caracteres.get(j).equals(txt.charAt(i))) {
					comprobarWin[i] = txt.charAt(i);
				}
			}
		}
		contador = txt.length();
		for (int i = 0; i < comprobarWin.length; i++) {
			if (comprobarWin[i] == '_') {

			} else {
				contador--;
			}
		}
		return contador;
	}
}


/*
----|
|	|
|   O
|  -|-
|  / \

*/
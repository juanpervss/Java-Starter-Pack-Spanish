package nuevoTema;

import java.util.Random;
import java.util.Scanner;

public class random {

	// En el main se solicita la longitud que se pasa luego al menu para el bucle
	public static void main(String[] args) {
		System.out.println("Introduce la longitud que deseas que tenga tu contraseña");
		System.out.println("El minimo numero de cracteres es 9");
		Scanner sc = new Scanner(System.in);
		int longitud = 0;
		String aux = "";
		aux = sc.nextLine();
		sc.close();
		longitud = Integer.parseInt(aux);
		if (longitud < 9) {
			System.err.println("La longitud no es valida!!!");
			System.out.println("La longitud minima es 9, por lo que te aplicamos esa longitud");
			longitud = 9;
		}else {
			System.out.println("Perfecto se hara una contraseña con una longitud de " + longitud + " caracteres");
		}
		menuPrincipal(longitud);
	}

	// Funcion que realiza un bucle con la longitud determinada en main y comprueba si la comprobacion de
	// contraseña sale true o false
	// Tambien aplica los caracteres traidos de la funcion al String de contraseña
	public static void menuPrincipal(int longitud) {
		char caracterEscogido = ' ';
		String password = "";
		for (int i = 0; i < longitud; i++) {
			caracterEscogido = elegirRandom();
			password += caracterEscogido;
		}
		if (comprobarPassword(password)) {
			System.out.println("Su contaseña segura es: " + password);
		}else {
			menuPrincipal(longitud);
		}
	}

	// Funcion que de manera aleatoria elige un caracter del txt y lo returna a menuPrincipal()
	public static char elegirRandom() {
		String txt = "qwertyuiopñlkjhgfdsazxcvbnmQWERTYUIOPÑLKJHGFDSAZXCVBNM1234567890@_!&-#*^";
		Random rd = new Random();
		int aux = 0;
		aux = rd.nextInt(0, txt.length());
		char caracterEscogido = ' ';
		caracterEscogido = txt.charAt(aux);
		return caracterEscogido;
	}

	// Comprueba que el valor de caracteres minimos de cada seccion es correcto
	// Si hay ese numero o mas se returna true, sino false
	public static boolean comprobarPassword(String password) {
		int auxLetras = 0;
		int auxEnteros = 0;
		int auxCaracteres = 0;
		for(int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				auxEnteros++;
			}else if(Character.isLetter(password.charAt(i))) {
				auxLetras++;
			}else {
				auxCaracteres++;
			}
		}

		if (auxCaracteres >= 3 && auxEnteros >= 3 && auxLetras >= 3) {
			return true;
		}else {
			return false;
		}
	}
}

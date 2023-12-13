package segondoTrimestre;

import java.util.ArrayList;
import java.util.HashMap;

public class ContadorPalabras {

	public static void main(String[] args) {
		HashMap<String, Integer> contador = new HashMap<>();
		String txt = "Hola voy a hacer un texto con palabras y repetir palabras puesto que me encanta repetir palabras palabras";
		ArrayList<String> prueba = new ArrayList<String>();
		separarPalabras(txt, prueba);
		añadirAHashMap(contador, prueba);
		System.out.println(contador);
		comprobarRepes(contador);
	}

	public static void comprobarRepes(HashMap<String, Integer> contador) {
		String aux = "";
		String auxPal = "";
		int max = 0;
		int auxNum = 0;
		for (int auxi : contador.values()) {
			if (auxi > max) {
				max = auxi;
				auxNum++;
			}
		}

	}

	public static void añadirAHashMap(HashMap<String, Integer> contador, ArrayList<String> prueba) {
		for (int i = 0; i < prueba.size(); i++) {
			String palabra = prueba.get(i);
			if (contador.containsKey(palabra)) {
				int aux = contador.get(palabra);
				aux++;
				contador.put(palabra, aux);
			} else {
				contador.put(palabra, 1);
			}
		}
	}

	public static void separarPalabras(String txt, ArrayList<String> prueba) {
		int contador = 0;
		String palabra = "";
		for (int i = 0; i < txt.length(); i++) {
			if (txt.charAt(i) == ' ') {
				if (contador >= 3) {
					prueba.add(palabra);
					contador = 0;
				}
				palabra = "";
			} else if (i == txt.length() - 1) {
				palabra += txt.charAt(i);
				contador++;
				if (contador >= 3) {
					prueba.add(palabra);
					contador = 0;
				}
			} else {
				palabra += txt.charAt(i);
				contador++;
			}
		}
		System.out.println(prueba);

	}

}

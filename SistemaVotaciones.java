package segondoTrimestre;

import java.util.HashMap;
import java.util.Scanner;

public class SistemaVotaciones {

	public static void main(String[] args) {
		HashMap<String, Integer> votaciones = new HashMap<String, Integer>();
		votaciones.put("PP", 0);
		votaciones.put("PSOE", 0);
		votaciones.put("VOX", 0);
		votaciones.put("SUMAR", 0);
		votaciones.put("PACMA", 0);
		votaciones.put("BILDU", 0);
		menuPrincipal(votaciones);
	}

	public static void menuPrincipal(HashMap<String, Integer> votaciones) {
		System.out.println("-------- SISTEMA NACIONAL DE VOTACIONES --------");
		System.out.println("Que deseas hacer???");
		System.out.println("Votar????");
		System.out.println("Mostrar las votaciones???");
		Scanner sc = new Scanner(System.in);
		String txt = "";
		txt = sc.nextLine().toLowerCase();
		if (txt.equals("votar")) {
			System.out.println("-------- SISTEMA NACIONAL DE VOTACIONES --------");
			solicitarVoto(votaciones);
			menuPrincipal(votaciones);
		} else if (txt.equals("mostrar")) {
			System.out.println("-------- SISTEMA NACIONAL DE VOTACIONES --------");
			System.out.println("Votaciones actuales:");
			for (String key : votaciones.keySet()) {
				System.out.println(key + ": " + votaciones.get(key));
			}
			menuPrincipal(votaciones);
		}
	}

	public static void solicitarVoto(HashMap<String, Integer> votaciones) {
		Scanner sc = new Scanner(System.in);
		String txt = "";
		System.out.println("Ingrese el nombre del partido que desea votar entre estos:");
		for (String key : votaciones.keySet()) {
			System.out.print(key + ", ");
		}
		System.out.println();
		System.out.println("---------------------");
		txt = sc.nextLine().toUpperCase();
		int aux = 0;
		if (votaciones.containsKey(txt)) {
			aux = votaciones.get(txt);
			aux++;
			votaciones.put(txt, aux);
		} else {
			System.err.println("No has introducido un partido valido para la votacion!!!");
			solicitarVoto(votaciones);
		}

	}

}

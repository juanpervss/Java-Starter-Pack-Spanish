package segondoTrimestre;

import java.util.HashMap;
import java.util.Scanner;

public class ContadorArticuos {

	public static void main(String[] args) {
		HashMap<String, Integer> inventario = new HashMap<String, Integer>();
		menuPrincipal(inventario);
	}

	public static void menuPrincipal(HashMap<String, Integer> inventario) {
		System.out.println("---------- INVENTARIO ----------");
		System.out.println("Que desea hacer?");
		System.out.println("Añadir? Actualizar? Consultar? Salir?");
		Scanner sc = new Scanner(System.in);
		String txt = sc.nextLine().toLowerCase();
		if (txt.equals("añadir")) {
			System.out.println("---------- INVENTARIO ----------");
			añadirItem(inventario);
			menuPrincipal(inventario);
		} else if (txt.equals("actualizar")) {
			System.out.println("---------- INVENTARIO ----------");
			actualizarItem(inventario);
			menuPrincipal(inventario);
		} else if (txt.equals("consultar")) {
			System.out.println("---------- INVENTARIO ----------");
			System.out.println(inventario);
			/*for(String key : inventario.keySet()) {
				System.out.print(key);
				
			}*/
			menuPrincipal(inventario);
		} else if (txt.equals("salir")) {
			System.out.println("---------- INVENTARIO ----------");
			System.out.println("Adios!!!!!!!");
		} else {
			System.out.println("---------- INVENTARIO ----------");
			System.out.println("Ingresa un valor valido");
			menuPrincipal(inventario);
		}
	}

	public static void actualizarItem(HashMap<String, Integer> inventario) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el articulo a consultar");
		String txt = sc.nextLine();
		if (inventario.containsKey(txt)) {
			int aux = 0;
			try {
				System.out.println("Ingresa el nuevo valor del objeto");
				aux = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Ingresa un numero valido");
				actualizarItem(inventario);
			}
			if (aux < 0) {
				System.out.println("No se puede poner en negativo un articulo");
			}else {
				inventario.put(txt, aux);
			}
		} else {
			System.out.println("Este ariculo no esta en el inventario");
			menuPrincipal(inventario);
		}
	}

	public static void añadirItem(HashMap<String, Integer> inventario) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el articulo a ingresar");
		String itemAñadir = sc.nextLine().toLowerCase();
		int cantidadAñadir = 0;
		System.out.println("Ingrese la cuantia ingresada");
		try {
			cantidadAñadir = sc.nextInt();
		} catch (Exception e) {
			System.out.println("No has metido una cantidad valida");
			añadirItem(inventario);
		}
		if (inventario.containsKey(itemAñadir)) {
			int aux = 0;
			aux = inventario.get(itemAñadir) + cantidadAñadir;
			if (aux < 0) {
				System.out.println("No se puede tener un articulo en negativo");
			} else {
				inventario.put(itemAñadir, aux);
			}
		} else {
			if (cantidadAñadir < 0) {
				System.out.println("No se puede tener un articulo en negativo");
			} else {
				inventario.put(itemAñadir, cantidadAñadir);
			}
		}

	}

}

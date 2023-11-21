package personales;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListAplicaciones {

	public static void main(String[] args) {
		List<Integer> listaArray = new ArrayList<Integer>();
		menuPrincipal(listaArray);
	}

	public static void menuPrincipal(List<Integer> listaArray) {
		System.out.println("Que desea hacer?");
		System.out.println("Añadir enteros a la lista");
		System.out.println("Mostrar la lista");
		System.out.println("Mostrar solo los elementos pares (poner 'pares'");
		System.out.println("Eliminar los elementos duplicados");
		System.out.println("Salir del programa");
		System.out.println("----------------------------");
		Scanner sc = new Scanner(System.in);
		String txt = sc.nextLine().toLowerCase();
		if (txt.equals("añadir")) {
			seleccionarCantidadNumero(listaArray, sc);
			System.out.println("----------------------------");
			menuPrincipal(listaArray);
		} else if (txt.equals("mostrar")) {
			System.out.println(listaArray);
			System.out.println("----------------------------");
			menuPrincipal(listaArray);
		} else if (txt.equals("pares")) {
			filtrarPares(listaArray);
			System.out.println("----------------------------");
			menuPrincipal(listaArray);
		} else if (txt.equals("eliminar")) {
			listaArray = eliminarDuplicados(listaArray);
			System.out.println("Los numeros duplicados fueron borrados correctamente");
			System.out.println("----------------------------");
			menuPrincipal(listaArray);
		}else if(txt.equals("salir")){
			System.out.println("Gracias por usar nuestra aplicacion, hasta pronto!!");
		} else {
			System.out.println("No has introducido un valor valido");
			System.out.println("----------------------------");
			menuPrincipal(listaArray);
		}
	}

	public static List<Integer> eliminarDuplicados(List<Integer> listaArray) {
		List<Integer> listaArraySinDuplicar = new ArrayList<Integer>();
		for (int i = 0; i < listaArray.size(); i++) {
			int num = listaArray.get(i);
			if (listaArray.indexOf(num) != listaArray.lastIndexOf(num)) {
				listaArraySinDuplicar.add(num);
				listaArray.remove(listaArray.lastIndexOf(num));
				eliminarDuplicados(listaArray);
			} else {
				listaArraySinDuplicar.add(num);
			}
		}
		return listaArraySinDuplicar;
	}

	public static void filtrarPares(List<Integer> listaArray) {
		List<Integer> listaArrayPares = new ArrayList<Integer>();
		for (int i = 0; i < listaArray.size(); i++) {
			int num = 0;
			num = listaArray.get(i);
			if (num % 2 == 0) {
				listaArrayPares.add(num);
			}
		}
		System.out.println(listaArrayPares);
	}

	public static int rellenarLista(List<Integer> listaArray, Scanner sc) {
		String numEscogido = "";
		int aux = 0;
		try {
			System.out.print("Escoja un numero entero: ");
			numEscogido = sc.nextLine();
			aux = Integer.parseInt(numEscogido);

		} catch (Exception e) {
			System.out.println("Solo numeros enteros");
			rellenarLista(listaArray, sc);
		}
		return aux;
	}

	public static void seleccionarCantidadNumero(List<Integer> listaArray, Scanner sc) {
		System.out.println("Determine la cantidad de numeros enteros que desea introducir");
		String num = "";
		int aux = 0;
		try {
			num = sc.nextLine();
			aux = Integer.parseInt(num);
		} catch (Exception e) {
			System.out.println("No agregue letras/espacios/decimales");
			seleccionarCantidadNumero(listaArray, sc);
		}
		System.out.println("Bien, se añadiran " + aux + " numero/s a la lista");
		int numEscogido = 0;
		for (int i = 0; i < aux; i++) {
			numEscogido = rellenarLista(listaArray, sc);
			listaArray.add(numEscogido);
		}
	}
}

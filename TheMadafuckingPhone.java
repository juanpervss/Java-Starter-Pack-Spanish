package segondoTrimestre;

import java.util.*;

public class TheMadafuckingPhone {

	public static void main(String[] args) {
		HashMap<String, String> agenda = new HashMap<String, String>();
		menuPrincipal(agenda);
	}

	public static void menuPrincipal(HashMap<String, String> agenda) {
		System.out.println("------------ AGENDA TELEFONICA ------------");
		System.out.println("Que desea hacer?");
		System.out.println("Agregar");
		System.out.println("Buscar");
		System.out.println("Eliminar");
		System.out.println("Actualizar (mostrar todos los contactos)");
		System.out.println("Salir");
		System.out.println("--------------------------------------------");
		Scanner sc = new Scanner(System.in);
		String txt = sc.nextLine().toLowerCase();
		txt = txt.toLowerCase();
		if (txt.equals(EnumeraditoFachero.AGREGAR.valor)) {
			System.out.println("------------ AGENDA TELEFONICA ------------");
			agregarContacto(agenda);
		} else if (txt.equals(EnumeraditoFachero.BUSCAR.valor)) {
			System.out.println("------------ AGENDA TELEFONICA ------------");
			buscarContacto(agenda);
		} else if (txt.equals(EnumeraditoFachero.ELIMINAR.valor)) {
			System.out.println("------------ AGENDA TELEFONICA ------------");
			eliminarContacto(agenda);
		} else if (txt.equals(EnumeraditoFachero.ACTUALIZAR.valor)) {
			System.out.println("------------ AGENDA TELEFONICA ------------");
			mostrarTodosContactos(agenda);
			menuPrincipal(agenda);
		} else if (txt.equals(EnumeraditoFachero.SALIR.valor)) {
			System.out.println("------------ AGENDA TELEFONICA ------------");
			System.out.println("Adios, vuelva pronto!!!");
		} else {
			menuPrincipal(agenda);
		}
	}

	public static void mostrarTodosContactos(HashMap<String, String> agenda) {
		System.out.println("Todos tus contactos son:");
		for (String key : agenda.keySet()) {
			System.out.println(key + ":");
			System.out.println(agenda.get(key));
		}
	}

	public static void buscarContacto(HashMap<String, String> agenda) {
		System.out.println("Introduzca el contacto a buscar");
		Scanner sc = new Scanner(System.in);
		String txt = sc.nextLine().toLowerCase();
		if (agenda.containsKey(txt)) {
			System.out.println(txt + ":");
			System.out.println(agenda.get(txt));
		}
		menuPrincipal(agenda);
	}

	public static void eliminarContacto(HashMap<String, String> agenda) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escriba el nombre del contacto que desea eliminar");
		String txt = sc.nextLine().toLowerCase();
		if (agenda.containsKey(txt)) {
			agenda.remove(txt);
			System.out.println("El contacto a sido eliminado");
		} else {
			System.out.println("No se a encontrado el contacto a eliminar");
		}
		menuPrincipal(agenda);
	}

	public static void agregarContacto(HashMap<String, String> agenda) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un nombre al contacto");
		String txt = sc.nextLine().toLowerCase();
		System.out.println("Introduzca el numero de telefono");
		String aux = sc.nextLine().toLowerCase();
		String txt2 = " +34 ";
		for (int i = 0; i < 9; i++) {
			if (aux.length() == 9) {
				if (i == 3 || i == 6 || i == 9) {
					txt2 += " ";
					txt2 += aux.charAt(i);
				} else {
					txt2 += aux.charAt(i);
				}
			} else {
				System.out.println("Has introducido mal el numero, vuelve a intentarlo");
				agregarContacto(agenda);
			}
		}
		if (!agenda.containsValue(txt2)) {
			if (agenda.containsKey(txt)) {
				String aux2 = agenda.get(txt);
				aux2 += "\r\n" + txt2;
				txt2 = aux2;
				agenda.put(txt, txt2);
				System.out.println("Contacto agregado correctamente a la lista");
			}else {
				agenda.put(txt, txt2);
				System.out.println("Contacto agregado correctamente a la lista");
			}
		} else {
			System.out.println("Este numero ya esta agregado en la lista");
		}
		menuPrincipal(agenda);
	}
}
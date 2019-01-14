package org.iesalandalus.programacion.agenda;

import java.util.Arrays;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	
	private static Agenda agenda = new Agenda();

	private static boolean repetir = true;

	public static void main(String[] args) {

		int opcion = 0;

		System.out.println("Programa para gestionar una agenda de contactos");

		do {

			mostrarMenu();
			opcion = elegirOpcion();
			ejecutarOpcion(opcion);

		} while (repetir);
	}

	private static void mostrarMenu() {
		System.out.println("                       ");
		System.out.println("   ***   MENU   ***    ");
		System.out.println("                       ");
		System.out.println("1. Añadir un contacto  ");
		System.out.println("2. Buscar un contacto  ");
		System.out.println("3. Borrar un contacto  ");
		System.out.println("4. Listar los contactos");
		System.out.println("5. Salir               ");
		System.out.println("                       ");
	}

	private static int elegirOpcion() {

		int opcion = 0;
		boolean elegido = false;

		do {

			System.out.print("\nElige una opcion: ");
			try {
				opcion = Entrada.entero();
				if (opcion >= 1 && opcion <= 5) {
					elegido = true;
				} else {
					System.out.println("Tienes que elejir un entero entre los que hay en menu");
				}
			} catch (NumberFormatException nfe) {
				System.err.println("Tienes que introducir un entero de los que hay en menu");
			}

		} while (!elegido);

		return opcion;
	}

	private static void ejecutarOpcion(int opcion) {

		switch (opcion) {
		case 1:
			anadirContacto();
			System.out.println("--- el contacto esta añadido ---/n");
			break;
		case 2:
			buscarContacto();
			System.out.println("--- se ha terminado la busqueda ---/n");
			break;
		case 3:
			borrarContacto();
			System.out.println("--- se ha terminado borrar el contacto ---/n");
			break;
		case 4:
			listarAgenda();
			System.out.println("--- se ha listado la agenda ---/n");
			break;
		case 5:
			repetir = false;
			System.out.println("El programa se ha terminado!!!");
			break;
		default:
			System.out.println("no tiene que aparecer");
			break;

		}

	}

	private static void anadirContacto() {

		Contacto contacto = null;
		String nombre = "";
		String telefono = "";
		String correo = "";

		do {
			System.out.print("Introduce el nombre: ");
			nombre = Entrada.cadena();
		} while (nombre.trim().equals(""));

		do {
			System.out.print("Introduce el telefono: ");
			telefono = Entrada.cadena();
		} while (telefono.trim().equals(""));

		do {
			System.out.print("Introduce el correo: ");
			correo = Entrada.cadena();
		} while (correo.trim().equals(""));

		contacto = new Contacto(nombre, telefono, correo);

		try {
			agenda.anadir(contacto);
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}

	}

	private static void buscarContacto() {
		
		String nombre = "";	
		Contacto contacto = null;
		
		do {
			System.out.print("Introduce el nombre: ");
			nombre = Entrada.cadena();
		} while (nombre.trim().equals(""));
		
		contacto = agenda.buscar(nombre);
		
		if (contacto == null) {
			System.out.println("Este contacto no esta en la agenda.");
		} else {
			System.out.println(contacto.toString());
		}		

	}

	private static void borrarContacto() {
		
		String nombre = "";
		
		do {
			System.out.print("Introduce el nombre: ");
			nombre = Entrada.cadena();
		} while (nombre.trim().equals(""));
		
		try {
			agenda.borrar(nombre);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			System.err.println("este contacto no existe.");;
		}

	}

	private static void listarAgenda() {
		System.out.println(Arrays.toString(agenda.getContactos()));
	}

}

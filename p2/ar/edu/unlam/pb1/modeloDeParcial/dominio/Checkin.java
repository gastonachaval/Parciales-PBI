package ar.edu.unlam.pb1.modeloDeParcial.dominio;

import java.util.Scanner;

public class Checkin {

	public static void main(String[] args) {

		System.out.println("Bienvenido ");

		int CantidadPasajero = 192;

		Vuelo vuelo = new Vuelo("Buenos Aires", "Bariloche", CantidadPasajero);

		int opcion = 0;

		do {
			opcion = seleccionarOpcion();
			switch (opcion) {
			case 1:
				registrarPasajero(vuelo);
				break;
			case 2:
				elegirAsiento(vuelo);
				break;
			case 3:
				listarPasajeros(vuelo);
				break;
			default:
				System.out.println("Opción Invalida");
				break;
			}
		} while (opcion != 9);
	}

	private static int seleccionarOpcion() {
		Scanner teclado = new Scanner(System.in);
		int opcionSeleccionada = 0;
		System.out.println("************************");
		System.out.println("Menu de opciones\n");
		System.out.println("1 - Registrar pasajero");
		System.out.println("2 - Elegir Asiento");
		System.out.println("3 - Listar pasajeros");
		System.out.println("9 - Salir");
		System.out.println("************************");
		System.out.println("Ingrese una opcion");
		opcionSeleccionada = teclado.nextInt();
		return opcionSeleccionada;
	}

	public static void registrarPasajero(Vuelo actual) {
		/*
		 * Interfaz de usuario encargada de cargar un pasajero al vuelo. Debe ingresar
		 * los datos necesarios e informar por pantalla el resultado de la operación
		 */
		Scanner teclado = new Scanner(System.in);
		String nombre, apellido;
		int dni;
		Vuelo vueloAlCualSeDebeCargarElPasajero = actual;
		System.out.println("Ingrese su nombre");
		nombre = teclado.next();
		System.out.println("Ingrese su apellido");
		apellido = teclado.next();
		System.out.println("Ingrese su DNI");
		dni = teclado.nextInt();
		Pasajero pasajeroARegistrar = new Pasajero(dni, nombre, apellido);
		if (vueloAlCualSeDebeCargarElPasajero.agregarPasajero(pasajeroARegistrar)==true) {
			System.out.println("El pasajero se cargo correctamente en el vuelo");
		}
		else {
			System.out.println("Hubo un problema con la carga del pasajero");
		}
	}

	private static void elegirAsiento(Vuelo actual) {
		/*
		 * Interfaz de usuario encargada de gestionar la asignación de asientos en el
		 * vuelo. Debe permitir el ingreso de los datos y mostrar por pantalla el
		 * resultado de la operación
		 */
		Scanner teclado = new Scanner(System.in);
		int dni, fila, columna;
		Pasajero pasajeroASentar=null;
		Vuelo vueloActual=actual;
		System.out.println("Ingrese su DNI");
		dni=teclado.nextInt();
		
		for (int i = 0; i < vueloActual.getPasajeros().length; i++) {
			if (vueloActual.getPasajeros()[i].getDni()==dni) {
				pasajeroASentar=vueloActual.getPasajeros()[i];
				break;
			}
			else {
				System.out.println("El pasajero no se encuentra cargado en la lista de pasajeros");
				return;
			}
		}
		
		System.out.println(vueloActual.toString());
		
		
		System.out.println("Ingrese la fila de su asiento");
		fila=teclado.nextInt();
		System.out.println("Ingrese la columna de su asiento");
		columna=teclado.nextInt();
		
		

		if (vueloActual.verificarDisponibilidadAsiento(fila,columna)==true) {
			vueloActual.asignarAsiento(pasajeroASentar, fila, columna);
			System.out.println("El pasajero "+pasajeroASentar.getApellido()+" fue asignado correctamente al asiento de la fila "+fila+" columna "+columna+".");
		}
		else {
			System.out.println("El asiento seleccionado no esta disponible");
		}
	}

	private static void listarPasajeros(Vuelo actual) {
		/*
		 * Se debe mostrar la lista de pasajeros registrados para éste vuelo ordenados
		 * por DNI
		 */
	
	Vuelo vueloAOrdenar=actual;
	vueloAOrdenar.ordenarListaDePasajerosPorDNI();
	for (int i = 0; i < vueloAOrdenar.getPasajeros().length; i++) {
		if (vueloAOrdenar.getPasajeros()[i]!=null) {
			System.out.println(vueloAOrdenar.getPasajeros()[i].toString());
		}
		else {
			System.out.println("Espacio V");
		}
		
	}
	
	}

}

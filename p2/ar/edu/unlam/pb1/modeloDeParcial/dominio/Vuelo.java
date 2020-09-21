package ar.edu.unlam.pb1.modeloDeParcial.dominio;

public class Vuelo {
	private final int CANTIDAD_DE_FILAS = 32;
	private final int CANTIDAD_DE_ASIENTOS_POR_FILA = 6;
	private String origen;
	private String destino;
	private Pasajero[] pasajeros;
	private Pasajero[][] asientos;

	public Vuelo(String origen, String destino, int cantidadPasajero) {
		this.origen = origen;
		this.destino = destino;
		this.pasajeros = new Pasajero[cantidadPasajero];
		this.asientos = new Pasajero[CANTIDAD_DE_FILAS][CANTIDAD_DE_ASIENTOS_POR_FILA];

		for (int i = 0; i < pasajeros.length; i++) {
			pasajeros[i] = null;
		}

		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				asientos[i][j] = null;
			}
		}

	}

	public boolean agregarPasajero(Pasajero pasajero) {
		/*
		 * Incorpora un nuevo pasajero a la lista de pasajeros del vuelo. Devuelve true
		 * si se pudo agregar o false si la capacidad del vuelo se encuentra completa.
		 */

		boolean sePudoAgregarPasajero = false;

		for (int i = 0; i < pasajeros.length; i++) {
			if (pasajeros[i] == null) {
				pasajeros[i] = pasajero;
				sePudoAgregarPasajero = true;
				break;
			}
		}
		return sePudoAgregarPasajero;
	}

	public boolean verificarDisponibilidadAsiento(int fila, int columna) {
		/*
		 * Verifica si el asiento indicado se encuentra disponible.
		 */

		boolean seEncuentraDisponibleElAsiento = false;
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos.length; j++) {
				if (asientos[i][j] == null) {
					seEncuentraDisponibleElAsiento = true;
					break;
				}
			}
		}
		return seEncuentraDisponibleElAsiento;
	}

	public Pasajero buscarPasajero(int dni) {
		/*
		 * Busca un pasajero en la lista de pasajeros a partir del DNI. Si no lo
		 * encuentra devuelve null.
		 */
		Pasajero pasajeroABuscar = null;

		for (int i = 0; i < pasajeros.length; i++) {
			if (pasajeros[i].getDni() == dni) {
				pasajeroABuscar = pasajeros[i];
				break;
			}
		}
		return pasajeroABuscar;
	}

	public boolean asignarAsiento(Pasajero pasajero, int fila, int columna) {
		/*
		 * Asigna el asiento al pasajero recibido por parámetro. Devuelve true si lo
		 * pudo asignar o false en caso que el asiento no se encuentre disponible.
		 */
		boolean sePudoAsignarAsiento = false;
		if (asientos[fila][columna] == null) {
			asientos[fila][columna] = pasajero;
			sePudoAsignarAsiento = true;
		}
		return sePudoAsignarAsiento;

	}

	public void ordenarListaDePasajerosPorDNI() {
		/*
		 * Ordena la lista de pasajeros por DNI.
		 */
		Pasajero temporal = null;
		for (int i = 0; i < pasajeros.length; i++) {
			if (pasajeros[i + 1].getDni() > pasajeros[i].getDni()) {
				temporal = pasajeros[i];
				pasajeros[i] = pasajeros[i + 1];
				pasajeros[i + 1] = temporal;
			}
		}

	}

	public Pasajero[] getPasajeros() {
		/*
		 * Devuelve la lista de pasajeros
		 */
		return pasajeros;
	}

	public String toString() {
		/*
		 * Devuelve un mapa de los asientos del vuelo indicando por cada uno si se
		 * encuentra libre "L" u ocupado "O".
		 */
		String mapa="";
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				if (asientos[i][j]==null) {

					mapa+=("L"+"\t");
				}
				else {
					mapa+=("O"+"\t");
				}
			}
			mapa+="\n";
		}
		return mapa;
	}
}

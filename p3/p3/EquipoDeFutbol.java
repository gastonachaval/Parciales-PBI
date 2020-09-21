package p3;
import p3.Jugador;

public class EquipoDeFutbol {
	private String nombre;
	private Jugador jugadores[];
	
	public EquipoDeFutbol(String nombre) {
		this.nombre=nombre;
		this.jugadores=new Jugador [23];
		for (int i = 0; i < jugadores.length; i++) {
			jugadores [i]=null;
		}		
	}

	/*
	 * La capacidad máxima de un equipo es 23. No se permiten jugadores repetidosa
	 * Se retorna el resultado de la operación
	 */
	public boolean agregarJugador(Jugador jugador) {
		boolean sePudoAgregarJugador=false;
		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i]!=null) {
			if (jugadores[i].getNombre()==jugador.getNombre()) {
				return sePudoAgregarJugador;
			}
		}
		}
		for (int i = 0; i < jugadores.length; i++) {

			if (jugadores[i]==null) {
				jugadores[i]=jugador;
				sePudoAgregarJugador=true;
				break;
			}
		}
		return sePudoAgregarJugador;
	}

	/*
	 * Permite cambiar cualquier jugador. 
	 * Para que el cambio se produzca, el jugador saliente debe estar presente en el equipo
	 */
	public boolean cambiarJugador(Jugador saliente, Jugador entrante) {
		boolean sePudoCambiarJugador=false;
		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i]==saliente) {
				jugadores[i]=entrante;
				sePudoCambiarJugador=true;
				break;
			}
		}
		return sePudoCambiarJugador;
	}

	public Jugador[] getJugadores() {
		return jugadores;
	}
	
	/*
	 * Permite buscar un jugador por su numero. 
	 * 
	 */
	public Jugador buscar(int numero) {
		Jugador jugadorBuscado=null;
		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i].getNumero()==numero) {
				jugadorBuscado=jugadores[i];
				break;
			}
			jugadorBuscado=new Jugador(0,"El jugador buscado no forma parte del plantel",2000);
		}
		return jugadorBuscado;
	}
	
	/*
	 * Permite buscar un jugador por su nombre. 
	 * 
	 */
	public Jugador buscar(String nombre) {
		Jugador jugadorBuscado=null;
		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i].getNombre()==nombre) {
				jugadorBuscado=jugadores[i];
				break;
			}
			jugadorBuscado=new Jugador(0,"El jugador buscado no forma parte del plantel",2000);
		}
		return jugadorBuscado;
	}
	
	/*
	 * Calcula el valor del equipo. 
	 * 
	 */
	public double calcularElValorDelEquipo() {
		double valorDelEquipo=0.0;
		for (int i = 0; i < jugadores.length; i++) {
			valorDelEquipo=valorDelEquipo+jugadores[i].getPrecio();
		}
		return valorDelEquipo;
	}
	
	/*
	 * Calcula el precio promedio de sus jugadores 
	 * 
	 */
	public double calcularElPrecioPromedio() {
		double precioPromedioDeLosJugadores=0.0;
		for (int i = 0; i < jugadores.length; i++) {
			precioPromedioDeLosJugadores=(precioPromedioDeLosJugadores+jugadores[i].getPrecio());
		}
		precioPromedioDeLosJugadores=precioPromedioDeLosJugadores/jugadores.length;
		return precioPromedioDeLosJugadores;
	}
}

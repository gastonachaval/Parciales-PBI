package dominio;

public class Venta{
	private static final int cantidadMaximaDeProductosEnElCarrito=100;
	private String nombreDelCliente;
	private Integer dni;
	private Producto[] carrito;

	/*
	 * Identificar e incorporar los atributos necesarios.
	 */

	public Venta(Integer dni, String nombreDelCliente)  {
		this.dni=dni;
		this.nombreDelCliente=nombreDelCliente;
		this.carrito=new Producto[cantidadMaximaDeProductosEnElCarrito];
		
		/*
		 * Costructor de la clase.
		 */

	}
	
	public int getDni() {
		return dni;
		/*
		 * Devuelve el dni del cliente.
		 */

	}
	
	public String getNombrDelCliente() {
		return nombreDelCliente;
		/*
		 * Devuelve el dni del cliente.
		 */

	}
	
	public void agregarItem(Producto producto) {
		for (int i = 0; i < carrito.length; i++) {
			if (carrito[i] == null) {
				carrito[i]=producto;
				break;
			}
		}
		
		/*
		 * Agrega un producto a la venta
		 */

	}
	
	public int getCantidadDeProductosComprados() {
		int cantidadDeProductosComprados=0;
		for (int i = 0; i < carrito.length; i++) {
			if (carrito[i] != null) {
				cantidadDeProductosComprados++;
			}
		}
		return cantidadDeProductosComprados;
		
		/*
		 * Devuelve la cantidad de proctos comprados 
		 */

	}
	
	public double getImporteTotal() {
		double importeTotal=0.0;
		for (int i = 0; i < carrito.length; i++) {
			if (carrito[i] != null) {
				importeTotal+=carrito[i].getPrecio();
			}
		}
		return importeTotal;
		
		/*
		 * Importe total de la venta o sumatoria del precio del producto
		 */
		

	}
	
	public String toString() {
		return nombreDelCliente+"-"+getImporteTotal();
		
		/*
		 * Devuelve infomacion de la venta (Nombre del cliente e importe total)
		 */

	}

}

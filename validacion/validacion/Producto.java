package validacion;

public class Producto {
	private Integer codigoDeProducto;
	private String descripcion;
	private Double precio;

	/*
	 * Identificar e incorporar los atributos necesarios.
	 */

	public Producto(Integer codigo, String descripcion, Double precio) {
		this.codigoDeProducto=codigo;
		this.descripcion=descripcion;
		this.precio=precio;
		
		/*
		 * Costructor de la clase.
		 */

	}

	public int getCodigo() {
		return codigoDeProducto;
		/*
		 * Devuelve el codigo del producto.
		 */

	}

	public String getDescripcion() {
		return descripcion;
		/*
		 * Devuelve la descripcion del producto.
		 */

	}

	public Double getPrecio() {
		return precio;
		/*
		 * Devuelve el precio del producto.
		 */

	}
	
	public String toString() {
		return codigoDeProducto+"-"+descripcion;
		/*
		 * Devuelve la informacion del producto (codigo y descripcion).
		 */

	}	
}

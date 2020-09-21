package validacion;

public class Empresa {

	private static final int tamanioDelCatalogo=100;
	private static final int cantidadDeVentasMaxima=100;
	private String nombre;
	private Producto[] productos;
	private Venta[] ventasRealizadas;

	/*
	 * Identificar e incorporar los atributos necesarios.
	 */
	public Empresa(String nombre) {
		this.nombre = nombre;
		productos = new Producto[tamanioDelCatalogo];
		ventasRealizadas=new Venta[cantidadDeVentasMaxima];

		/*
		 * Costructor de la clase.
		 */

	}

	public String getNombre() {
		return nombre;
		/*
		 * Devuelve el nombre de la empresa.
		 */

	}

	public void agregarProducto(Producto nuevo) {
		for (int i = 0; i < productos.length; i++) {
			if (productos[i] == null) {
				productos[i] = nuevo;
				break;
			}
		}

		/*
		 * Agrega un producto al catalogo
		 */

	}

	public void realizarVenta(Venta nueva) {
		for (int i = 0; i < ventasRealizadas.length; i++) {
			if (ventasRealizadas[i] == null) {
				ventasRealizadas[i] = nueva;
				break;
			}
		}

		/*
		 * Registra una venta
		 */

	}

	public Producto getProductoPorNombre(String nombreDelProducto) {
		Producto buscado = null;
		for (int i = 0; i < productos.length; i++) {
			if (productos[i].getDescripcion().equals(nombreDelProducto)) {
				buscado = productos[i];
				break;
			}
		}
		return buscado;

		/*
		 * Busca y devuelve un producto basado en su nombre
		 */

	}

	public double getImportePromedioDeVentas() {
		double importe = 0.0;
		int cantidadDeVentas = 0;

		for (int i = 0; i < ventasRealizadas.length; i++) {
			if (ventasRealizadas[i] != null) {
				importe += ventasRealizadas[i].getImporteTotal();
				cantidadDeVentas++;
			}
		}

		return importe / cantidadDeVentas;

		/*
		 * Busca y devuelve un producto basado en su nombre
		 */

	}

	public void ordenarLosProductosPorCodigo() {
		Producto temporal = null;
		for (int i = 0; i < 99; i++) {
			if (productos[i+1]!=null) {
				if (productos[i + 1].getCodigo() > productos[i].getCodigo()) {
					temporal = productos[i];
					productos[i] = productos[i + 1];
					productos[i + 1] = temporal;
				}
			}
		}


		/*
		 * Ordena el catalogo de productos por codigo
		 */

	}

	public String toString() {
		String listado="";
		for (int i = 0; i < productos.length; i++) {
			if (productos[i] != null) {
					listado+=productos[i].toString()+"\n";	
			}
		}
		return listado;
		
		/*
		 * Devuelve un listado con el catalogo de productos
		 */

	}
}

package co.com.udem.maquinaria.DTO;

public class MaquinariaDTO {
	String imagen;
	String nombre;
	Double precio;
	Double descuento;
	String descripcion;
	String disponibilidad;
	
	public MaquinariaDTO(String imagen, String nombre, Double precio,
			Double descuento, String descripcion, String disponibilidad) {
		super();
		this.imagen = imagen;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		this.descripcion = descripcion;
		this.disponibilidad = disponibilidad;
	}

	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the precio
	 */
	public Double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	/**
	 * @return the descuento
	 */
	public Double getDescuento() {
		return descuento;
	}

	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the disponibilidad
	 */
	public String getDisponibilidad() {
		return disponibilidad;
	}

	/**
	 * @param disponibilidad the disponibilidad to set
	 */
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	
	
	

}

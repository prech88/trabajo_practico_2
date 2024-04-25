package ar.edu.unju.fi.ejercicio1.model;

public class Producto {
	private Integer codigo;
	private String descripcion;
	private Double precioUnitario;
	private Paises origenFabricacion;
	private Categorias categoria;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(Integer codigo, String descripcion, Double precioUnitario, Paises origenFabricacion,Categorias categoria) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario
				+ ", origenFabricacion=" + origenFabricacion.name() + ", categoria=" + categoria.name() + "]";
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Paises getOrigenFabricacion() {
		return origenFabricacion;
	}

	public void setOrigenFabricacion(Paises origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	public enum Paises {
		ARGENTINA, CHINA, BRASIL, URUGUAY;
	}
	
	public enum Categorias {
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS;
	}
}

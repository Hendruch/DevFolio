package mx.ulsa.hendricklpsw.modelo;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="proyecto")
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idProyecto")
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="categoria")
	private String categoria;
	
	@Column(name="fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	@Column(name="foto")
	private String foto;

	@Column(name = "precio")
	private Double precio;

	public Proyecto(){}
	
	public Proyecto(String nombre, String categoria, Date fecha, String foto, Double precio) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.fecha = fecha;
		this.foto = foto;
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
}

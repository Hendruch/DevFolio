package mx.ulsa.hendricklpsw.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="blog")
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idBlog")
	private Integer id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="foto")
	private String foto;
	
	@Column(name="texto")
	private String texto;

	public Blog(){}
	
	public Blog(String titulo, String foto, String texto) {
		super();
		this.titulo = titulo;
		this.foto = foto;
		this.texto = texto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}

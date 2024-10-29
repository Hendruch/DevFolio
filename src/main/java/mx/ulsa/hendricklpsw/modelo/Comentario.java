package mx.ulsa.hendricklpsw.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="comentario")
public class Comentario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //autoincrementable
	@Column(name="id")
	private int id;
	
	@Column(name = "comentario")
	private String comentario;
	
	@OneToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name="blog_id")
	private Blog blog;
	

	public Comentario(){}
	public Comentario(String comentario, Usuario usuario, Blog blog) {
		super();
		this.comentario = comentario;
		this.usuario = usuario;
		this.blog = blog;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

}

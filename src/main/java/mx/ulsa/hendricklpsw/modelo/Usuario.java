package mx.ulsa.hendricklpsw.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usuario")
public class Usuario implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//@Column(name="nombre")
	@Column(nullable = false, unique = true)
	private String nombre;
	
	//@Column(name="email")
	@Column(nullable = false, unique = true)
	private String email;
	
	//@Column(name="password")
	@Column(nullable = false)
	private String password;
	
	@Column(name="celular")
	private String celular;

	//@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//@ManyToMany
	//@JoinColumn(name = "rol_id")
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
	)
	private Set<Role> rol;

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.nombre;
	}

	@Override
	public Set<GrantedAuthority> getAuthorities() {
		return this.getRol().stream()
				.map((role) -> new SimpleGrantedAuthority(role.getNombre()))
				.collect(Collectors.toSet());
	}

	@Override
	public boolean isAccountNonExpired() {
		// Implement account expiration logic if needed
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// Implement account locking logic if needed
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// Implement credential expiration logic if needed
		return true;
	}

	@Override
	public boolean isEnabled() {
		// Implement logic to enable/disable user accounts
		return true;
	}


	/*
	public Usuario() {}

	public Usuario(Integer id, String nombre, String email, String password, String celular, Set<Role> rol) {
		id = id;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.celular = celular;
		this.rol = rol;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Set<Role> getRol() {
		return rol;
	}

	public void setRol(Set<Role> rol) {
		this.rol = rol;
	}

	 */

}

package mx.ulsa.hendricklpsw.repository;

import mx.ulsa.hendricklpsw.modelo.Role;
import mx.ulsa.hendricklpsw.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombre(String nombre);

    Boolean existsByEmail(String email);

    Optional<Usuario> findByNombreOrEmail(String nombre, String email);

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByRolIn(Set<Role> rol);

    boolean existsByNombre(String nombre);
}

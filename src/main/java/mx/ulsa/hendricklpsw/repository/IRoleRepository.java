package mx.ulsa.hendricklpsw.repository;

import mx.ulsa.hendricklpsw.modelo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByNombre(String nombre);
}

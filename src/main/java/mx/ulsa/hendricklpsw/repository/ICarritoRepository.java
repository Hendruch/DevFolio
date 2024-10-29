package mx.ulsa.hendricklpsw.repository;

import mx.ulsa.hendricklpsw.modelo.Carrito;
import mx.ulsa.hendricklpsw.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICarritoRepository extends JpaRepository<Carrito, Integer> {
    Carrito findByUsuario(Usuario usuario);
}

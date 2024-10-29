package mx.ulsa.hendricklpsw.repository;

import mx.ulsa.hendricklpsw.modelo.Usuario;
import mx.ulsa.hendricklpsw.modelo.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Integer> {

    List<Venta> findAllByUsuario(Usuario usuario);
}

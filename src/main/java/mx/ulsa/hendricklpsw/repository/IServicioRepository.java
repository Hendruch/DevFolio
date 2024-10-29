package mx.ulsa.hendricklpsw.repository;

import mx.ulsa.hendricklpsw.modelo.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServicioRepository extends JpaRepository<Servicio, Integer> {
}

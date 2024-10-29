package mx.ulsa.hendricklpsw.repository;

import mx.ulsa.hendricklpsw.modelo.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Integer> {
}

package mx.ulsa.hendricklpsw.repository;

import mx.ulsa.hendricklpsw.modelo.CarritoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarritoItemRepository extends JpaRepository<CarritoItem, Integer> {
}

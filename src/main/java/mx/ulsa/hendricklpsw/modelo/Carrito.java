package mx.ulsa.hendricklpsw.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="carrito_carritoItem",
            joinColumns=@JoinColumn(name="carrito_id"),
            inverseJoinColumns=@JoinColumn(name="item_id"))
    private Set<CarritoItem> carritoItem = new HashSet<>();

    @OneToOne
    private Usuario usuario;
}

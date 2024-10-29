package mx.ulsa.hendricklpsw.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer id;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="carrito_venta",
            joinColumns=@JoinColumn(name="venta_id"),
            inverseJoinColumns=@JoinColumn(name="carritoItem_id"))
    private Set<CarritoItem> listaProyectos = new HashSet<>();


    @Column(name = "total")
    private Double total;

    @Column(name = "fechaVenta")
    private Date fechaVenta;

    @ManyToOne
    private Usuario usuario;

}
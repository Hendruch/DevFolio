package mx.ulsa.hendricklpsw.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class CarritoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne
    private Proyecto proyecto;

    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "subtotal")
    private Double subtotal;
    //descuento
    //fecha_agregado


    public CarritoItem(Proyecto proyecto, Integer cantidad) {
        super();
        this.proyecto = proyecto;
        this.cantidad = cantidad;
        this.subtotal = proyecto.getPrecio()*cantidad;
    }


/*
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "Carrito [proyecto=" + proyecto + ", cantidad=" + cantidad + ", subtotal=" + subtotal + "]";
    }

 */
}

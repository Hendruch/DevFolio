package mx.ulsa.hendricklpsw.service;

import mx.ulsa.hendricklpsw.modelo.Carrito;
import mx.ulsa.hendricklpsw.modelo.CarritoItem;
import mx.ulsa.hendricklpsw.modelo.Usuario;
import mx.ulsa.hendricklpsw.modelo.Venta;
import mx.ulsa.hendricklpsw.repository.ICarritoRepository;
import mx.ulsa.hendricklpsw.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
public class VentaService {

    @Autowired
    IVentaRepository ventaRepo;

    @Autowired
    ICarritoRepository carritoRepo;

    @Autowired
    CarritoService carritoService;

    public boolean addVenta(Usuario usuario){
        Venta venta = new Venta();
        double total = 0;

        if(carritoRepo.findByUsuario(usuario) != null){
            Carrito carrito = carritoRepo.findByUsuario(usuario);
            venta.setUsuario(usuario);
            venta.setFechaVenta(Date.from(Instant.now()));

            List<CarritoItem> copiedCarritoItems = new ArrayList<>();

            for(CarritoItem c : carrito.getCarritoItem()){
                CarritoItem copiedItem = new CarritoItem(c.getProyecto(), c.getCantidad());
                copiedCarritoItems.add(copiedItem);
                total += c.getSubtotal();
            }
            venta.setTotal(total);
            venta.setListaProyectos(new HashSet<>(copiedCarritoItems));

            carritoService.deleteCarrito(usuario);

            ventaRepo.save(venta);
            return true;
        }

        return false;
    }

    public List<Venta> getAllVentas(){
        List<Venta> ventaList = new ArrayList<>();
        ventaRepo.findAll().forEach(Venta -> ventaList.add(Venta));
        return ventaList;
    }

    public List<Venta> getVentasByUsuario(Usuario usuario){
        List<Venta> compraList = new ArrayList<>();
        ventaRepo.findAllByUsuario(usuario).forEach(Compra -> compraList.add(Compra));
        return compraList;
    }

    public Venta getVentaById(Integer id){
        return ventaRepo.findById(id).get();
    }

    public List<CarritoItem> getItemsVenta(Integer id){
        Venta venta = getVentaById(id);
        return venta.getListaProyectos().stream().toList();
    }

    public boolean deleteVenta(Integer id){
        ventaRepo.deleteById(id);
        if(ventaRepo.findById(id) != null){
            return true;
        }
        return false;
    }

}

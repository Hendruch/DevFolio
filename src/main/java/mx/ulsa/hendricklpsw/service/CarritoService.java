package mx.ulsa.hendricklpsw.service;

import mx.ulsa.hendricklpsw.modelo.Carrito;
import mx.ulsa.hendricklpsw.modelo.CarritoItem;
import mx.ulsa.hendricklpsw.modelo.Proyecto;
import mx.ulsa.hendricklpsw.modelo.Usuario;
import mx.ulsa.hendricklpsw.repository.ICarritoItemRepository;
import mx.ulsa.hendricklpsw.repository.ICarritoRepository;
import mx.ulsa.hendricklpsw.repository.IProyectoRepository;
import mx.ulsa.hendricklpsw.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class CarritoService {

    @Autowired
    ICarritoRepository carritoRepo;

    @Autowired
    IUsuarioRepository usuarioRepo;

    @Autowired
    IProyectoRepository proyectoRepo;

    @Autowired
    ICarritoItemRepository carritoItemRepo;

    public List<CarritoItem> getCarritoByUsuario(Usuario usr){
        Carrito carrito = new Carrito();

        if(carritoRepo.findByUsuario(usr) != null){
            carrito = carritoRepo.findByUsuario(usr);
        }else {
            carrito.setUsuario(usr);
        }

        carritoRepo.save(carrito);
        if(carrito.getCarritoItem() != null){
            return carrito.getCarritoItem().stream().toList();
        }else {
            List<CarritoItem> carritoItemList = new ArrayList<>();
            return carritoItemList;
        }
    }

    public boolean addToCarrito(Integer proyectoId, Usuario usr) {
        Proyecto proyecto = proyectoRepo.findById(proyectoId).orElse(null);

        if (proyecto == null) {
            return false;
        }

        List<CarritoItem> carritoItemList = new ArrayList<>(getCarritoByUsuario(usr));
        Carrito carritoUsr = carritoRepo.findByUsuario(usr);

        boolean itemFound = false;

        for (CarritoItem c : carritoItemList) {
            if (c.getProyecto().getId().equals(proyectoId)) {
                c.setCantidad(c.getCantidad() + 1);
                c.setSubtotal(c.getCantidad() * c.getProyecto().getPrecio());
                carritoItemRepo.save(c);
                itemFound = true;
                break;
            }
        }

        if (!itemFound) {
            CarritoItem carritoItem = new CarritoItem(proyecto, 1);
            carritoItemRepo.save(carritoItem);
            carritoItemList.add(carritoItem);
        }

        carritoUsr.setCarritoItem(new HashSet<>(carritoItemList));
        carritoRepo.save(carritoUsr);

        return true;
    }

    public boolean deleteFromCarrito(Integer carritoItemID, Usuario usr){
        List<CarritoItem> carritoItemList = new ArrayList<>(getCarritoByUsuario(usr));
        Carrito carritoUsr = carritoRepo.findByUsuario(usr);

        boolean itemFound = false;

        for (CarritoItem c : carritoItemList) {
            if (c.getId().equals(carritoItemID)) {
                carritoItemList.remove(c);
                carritoUsr.setCarritoItem(new HashSet<>(carritoItemList));
                carritoItemRepo.deleteById(carritoItemID);
                itemFound = true;
                break;
            }
        }

        if(carritoItemRepo.findById(carritoItemID) != null && itemFound==true){
            return true;
        }
        return false;
    }

    public void deleteCarrito(Usuario usuario){
        try{
            Carrito carritoUsr = carritoRepo.findByUsuario(usuario);

            if (carritoUsr != null) {
                carritoUsr.getCarritoItem().clear();
                carritoRepo.save(carritoUsr);

                carritoRepo.delete(carritoUsr);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}

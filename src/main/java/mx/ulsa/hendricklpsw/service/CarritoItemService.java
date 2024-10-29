package mx.ulsa.hendricklpsw.service;

import mx.ulsa.hendricklpsw.modelo.CarritoItem;
import mx.ulsa.hendricklpsw.modelo.Proyecto;
import mx.ulsa.hendricklpsw.repository.ICarritoItemRepository;
import mx.ulsa.hendricklpsw.repository.IProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoItemService {

    @Autowired
    ICarritoItemRepository carritoItemRepo;

    @Autowired
    IProyectoRepository proyectoRepo;
    public List<CarritoItem> getAllCarritoItem(){
        List<CarritoItem> carritoItemList = new ArrayList<>();
        carritoItemRepo.findAll().forEach(CarritoItem -> carritoItemList.add(CarritoItem));
        System.out.println(carritoItemList);

        return carritoItemList;
    }

    //public CarritoItem getCarritoItemById(Integer id){return carritoItemItemRepo.findById(id).get(); }

    public boolean addCarritoItem(Integer proyectoId){
        Proyecto proyecto =  proyectoRepo.findById(proyectoId).get();
        CarritoItem carritoItem = new CarritoItem(proyecto, 1);

        List<CarritoItem> carritoItemList = new ArrayList<>();
        carritoItemRepo.findAll().forEach(CarritoItem -> carritoItemList.add(CarritoItem));

        for(CarritoItem c : carritoItemList){
            if(c.getProyecto().getId().equals(proyectoId) ){
                carritoItem.setCantidad(c.getCantidad()+1);
            }
        }

        CarritoItem updatedCarritoItem = carritoItemRepo.save(carritoItem);

        if(carritoItemRepo.findById(updatedCarritoItem.getId()) != null){
            return true;
        }


       return false;
       /*
        CarritoItem updatedCarritoItem = carritoItemItemRepo.save(carritoItem);

        if(carritoItemItemRepo.findById(updatedCarritoItem.getId()) != null){
            return true;
        }
        return false;
        */

    }

    public boolean addQty(Integer id){
        try{
            CarritoItem carritoItem = carritoItemRepo.findById(id).orElse(null);

            carritoItem.setCantidad(carritoItem.getCantidad()+1);
            carritoItem.setSubtotal(carritoItem.getCantidad() * carritoItem.getProyecto().getPrecio());

            carritoItemRepo.save(carritoItem);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public boolean lessQty(Integer id){
        try{
            CarritoItem carritoItem = carritoItemRepo.findById(id).orElse(null);

            carritoItem.setCantidad(carritoItem.getCantidad()-1);
            carritoItem.setSubtotal(carritoItem.getCantidad() * carritoItem.getProyecto().getPrecio());

            carritoItemRepo.save(carritoItem);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteCarritoItemItem(Integer id){
        carritoItemRepo.deleteById(id);
        if(carritoItemRepo.findById(id) != null){
            return true;
        }
        return false;
    }
}

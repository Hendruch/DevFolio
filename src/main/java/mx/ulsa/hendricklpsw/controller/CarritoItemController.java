package mx.ulsa.hendricklpsw.controller;

import mx.ulsa.hendricklpsw.modelo.CarritoItem;
import mx.ulsa.hendricklpsw.repository.ICarritoItemRepository;
import mx.ulsa.hendricklpsw.service.CarritoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CarritoItemController {

    @Autowired
    CarritoItemService carritoItemService;

    @Autowired
    ICarritoItemRepository carritoItemRepo;

    //@GetMapping("/Carrito")
    public String verCarrito(@ModelAttribute("carrito") CarritoItem carritoItem, Model model){
        model.addAttribute("listaCarrito", carritoItemService.getAllCarritoItem());
        return "carrito/viewCarrito";
    }

    //@PostMapping("/addToCart/{proyectoId}")
    public String addToCart(@PathVariable(name = "proyectoId") Integer proyectoId, RedirectAttributes redirectAttributes){
        /*
        Proyecto proyecto =  proyectoRepo.findById(proyectoId).get();
        Carrito carrito = new Carrito(proyecto, 1);

        for(Carrito c : cart){
            if(c.getProyecto().getId().equals(proyectoId) ){
                carrito.setCantidad(c.getCantidad()+1);
                cart.remove(c);
            }
        }

        cart.add(carrito);
        System.out.println(cart);
         */

        if(carritoItemService.addCarritoItem(proyectoId)){
            redirectAttributes.addFlashAttribute("message", "Proyecto agregado al carrito correctamente");
        }else {
            redirectAttributes.addFlashAttribute("message", "Error al agregar proyecto al carrito");
        }


        return "redirect:/Carrito";
    }
}

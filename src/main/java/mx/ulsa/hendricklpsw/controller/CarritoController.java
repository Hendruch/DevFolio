package mx.ulsa.hendricklpsw.controller;

import mx.ulsa.hendricklpsw.modelo.CarritoItem;
import mx.ulsa.hendricklpsw.service.CarritoItemService;
import mx.ulsa.hendricklpsw.service.CarritoService;
import mx.ulsa.hendricklpsw.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CarritoController {

    @Autowired
    CarritoService carritoService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    CarritoItemService carritoItemService;

    @GetMapping("/Carrito")
    public String verCarrito(@ModelAttribute("carrito") CarritoItem carritoItem, Model model){
        model.addAttribute("listaCarrito", carritoService.getCarritoByUsuario(usuarioService.getCurrentUser()));
        return "carrito/viewCarrito";
    }

    @PostMapping("/addToCart/{proyectoId}")
    public String addToCart(@PathVariable(name = "proyectoId") Integer proyectoId, RedirectAttributes redirectAttributes){
        if(carritoService.addToCarrito(proyectoId, usuarioService.getCurrentUser())){
            redirectAttributes.addFlashAttribute("message", "Proyecto agregado al carrito correctamente");
        }else {
            redirectAttributes.addFlashAttribute("message", "Error al agregar proyecto al carrito");
        }


        return "redirect:/Carrito";
    }

    @GetMapping("/more/{id}")
    public String addQty(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if(carritoItemService.addQty(id)){
            redirectAttributes.addFlashAttribute("message", "CarritoItem modificado correctamente");
        }else {
            redirectAttributes.addFlashAttribute("message", "Error al modificar CarritoItem");
        }
        return "redirect:/Carrito";
    }

    @GetMapping("/less/{id}")
    public String lessQty(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if(carritoItemService.lessQty(id)){
            redirectAttributes.addFlashAttribute("message", "CarritoItem modificado correctamente");
        }else {
            redirectAttributes.addFlashAttribute("message", "Error al modificar CarritoItem");
        }
        return "redirect:/Carrito";
    }

    @GetMapping("/deleteFromCart/{itemID}")
    public String deleteFromCart(@PathVariable(name = "itemID") Integer carritoItemID, RedirectAttributes redirectAttributes){
        if(carritoService.deleteFromCarrito(carritoItemID, usuarioService.getCurrentUser())){
            redirectAttributes.addFlashAttribute("message", "CarritoItem Eliminado correctamente");
        }else {
            redirectAttributes.addFlashAttribute("message", "Error al eliminar CarritoItem");
        }

        return "redirect:/Carrito";
    }


}

package mx.ulsa.hendricklpsw.controller;

import mx.ulsa.hendricklpsw.modelo.Venta;
import mx.ulsa.hendricklpsw.repository.IVentaRepository;
import mx.ulsa.hendricklpsw.service.UsuarioService;
import mx.ulsa.hendricklpsw.service.VentaService;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class VentaController {

    @Autowired
    VentaService ventaService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/addVenta")
    public String addVenta(){
        if(ventaService.addVenta(usuarioService.getCurrentUser())){
            return "venta/ventaConfirmada";
        }
        return "venta/ventaFallida";
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/Ventas")
    public String viewVentas(@ModelAttribute("venta")Venta venta, Model model){
        model.addAttribute("listaVentas", ventaService.getAllVentas());
        return "venta/viewVentas";
    }

    @GetMapping("/compras")
    public String verCompras(@ModelAttribute("venta")Venta venta, Model model){
        model.addAttribute("listaCompras", ventaService.getVentasByUsuario(usuarioService.getCurrentUser()));
        return "compras/viewCompras";
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/verVenta/{id}")
    public String verVenta(@PathVariable Integer id, Model model){
        model.addAttribute("venta", ventaService.getVentaById(id));
        model.addAttribute("listaProyectos", ventaService.getItemsVenta(id));
        return "venta/viewEditVenta";
    }

    @GetMapping("/verCompra/{id}")
    public String verCompra(@PathVariable Integer id, Model model){
        model.addAttribute("venta", ventaService.getVentaById(id));
        model.addAttribute("listaProyectos", ventaService.getItemsVenta(id));
        return "compras/verCompra";
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/deleteVenta/{id}")
    public String deleteVenta(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if(ventaService.deleteVenta(id)){
            redirectAttributes.addFlashAttribute("message", "Venta eliminada correctamente");
        }else {
            redirectAttributes.addFlashAttribute("message", "Error al eliminar venta");
        }
        return "redirect:/Ventas";
    }
}

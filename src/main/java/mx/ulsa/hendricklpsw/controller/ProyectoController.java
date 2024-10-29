package mx.ulsa.hendricklpsw.controller;

import mx.ulsa.hendricklpsw.modelo.Proyecto;
import mx.ulsa.hendricklpsw.repository.IProyectoRepository;
import mx.ulsa.hendricklpsw.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
//@SessionAttributes("cart")
public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;

    @Autowired
    IProyectoRepository proyectoRepo;

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/proyectos")
    public String viewRoles(@ModelAttribute("proyecto") Proyecto proyecto, Model model){
        model.addAttribute("listaProyectos", proyectoService.getAllProyecto());
        return "proyecto/viewProyecto";
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/addProyecto")
    public String addProyecto(@ModelAttribute("message") String message, Model model){
        model.addAttribute("proyecto", new Proyecto());
        model.addAttribute("message", message);

        return "proyecto/viewAddProyecto";
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @PostMapping("/saveProyecto")
    public String saveProyecto(@RequestParam("file") MultipartFile file, Proyecto proyecto, RedirectAttributes redirectAttributes){

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Seleccione un archivo para cargarse.");
        } else {

            try {
                proyectoService.guardarImagen(file);
                proyecto.setFoto(file.getOriginalFilename());
                redirectAttributes.addFlashAttribute("message", "Carga de archivo correcto: '" + file.getOriginalFilename() + "'.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(proyectoService.saveOrUpdateProyecto(proyecto)){
            redirectAttributes.addFlashAttribute("message", "Registro Exitoso");
            return "redirect:/proyectos";
        }

        redirectAttributes.addFlashAttribute("message", "Error al hacer el registro");
        return "redirect:/addProyecto";
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/editProyecto/{id}")
    public String editProyecto(@PathVariable Integer id, Model model){
        model.addAttribute("proyecto", proyectoService.getProyectoById(id));

        return "proyecto/viewEditProyecto";
    }

    @GetMapping("/viewProyecto/{id}")
    public String viewProyecto(@PathVariable Integer id, Model model){
        model.addAttribute("proyecto", proyectoService.getProyectoById(id));

        return "carrito/addCarrito";
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @PostMapping("/editSaveProyecto")
    public String editSaveProyecto(@RequestParam("file") MultipartFile file, @ModelAttribute("proyecto") Proyecto proyecto, RedirectAttributes redirectAttributes){

        try {
            proyectoService.guardarImagen(file);
            proyecto.setFoto(file.getOriginalFilename());
            redirectAttributes.addFlashAttribute("message", "Carga de archivo correcto: '" + file.getOriginalFilename() + "'.");
        } catch (IOException e) {
            e.printStackTrace();
        }


        if(proyectoService.saveOrUpdateProyecto(proyecto)){
            redirectAttributes.addFlashAttribute("message","Proyecto actualizado con éxito");
            return "redirect:/proyectos";
        }

        redirectAttributes.addFlashAttribute("message", "Error al actualizar el proyecto");
        return "redirect:/editProyecto/" + proyecto.getId();
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/deleteProyecto/{id}")
    public String deleteProyecto(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if(proyectoService.deleteProyecto(id)){
            redirectAttributes.addFlashAttribute("message", "Proyecto eliminado correctamente");
        }else {
            redirectAttributes.addFlashAttribute("message", "Error al eliminar proyecto");
        }

        return "redirect:/proyectos";
    }




}

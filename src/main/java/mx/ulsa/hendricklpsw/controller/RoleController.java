package mx.ulsa.hendricklpsw.controller;

import mx.ulsa.hendricklpsw.modelo.Role;
import mx.ulsa.hendricklpsw.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RoleController {

    @Autowired
    RoleService roleService;

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/roles")
    public String viewRoles(@ModelAttribute("rol") Role rol, Model model){
        model.addAttribute("listaRoles", roleService.getAllRoles());
        return "rol/viewRol";
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/addRol")
    public String addRol(@ModelAttribute("message") String message, Model model){
        model.addAttribute("rol", new Role());
        model.addAttribute("message", message);

        return "rol/viewAddRol";
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @PostMapping("/saveRol")
    public String saveRol(Role rol, RedirectAttributes redirectAttributes){
        if(roleService.saveOrUpdateRol(rol)){
            redirectAttributes.addFlashAttribute("message", "Registro Exitoso");
            return "redirect:/roles"; // cambiar a redirect:/usuarios
        }

        redirectAttributes.addFlashAttribute("message", "Error al hacer el registro");
        return "redirect:/addRol";
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/editRol/{id}")
    public String editRol(@PathVariable Integer id, Model model){
        model.addAttribute("rol", roleService.getRolById(id));

        return "rol/viewEditRol";
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @PostMapping("/editSaveRol")
    public String editSaveRol(Role rol, RedirectAttributes redirectAttributes){
        if(roleService.saveOrUpdateRol(rol)){
            redirectAttributes.addFlashAttribute("message","Rol actualizado con éxito");
            return "redirect:/roles";
        }

        redirectAttributes.addFlashAttribute("message", "Error al actualizar el rol");
        return "redirect:/editRol/" + rol.getId();
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/deleteRol/{id}")
    public String deleteRol(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if(roleService.deleteRol(id)){
            redirectAttributes.addFlashAttribute("message", "Rol eliminado correctamente");
        }else {
            redirectAttributes.addFlashAttribute("message", "Error al eliminar rol");
        }

        return "redirect:/roles";
    }
}

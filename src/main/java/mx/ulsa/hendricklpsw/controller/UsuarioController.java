package mx.ulsa.hendricklpsw.controller;

import mx.ulsa.hendricklpsw.modelo.Role;
import mx.ulsa.hendricklpsw.modelo.Usuario;
import mx.ulsa.hendricklpsw.repository.IRoleRepository;
import mx.ulsa.hendricklpsw.service.RoleService;
import mx.ulsa.hendricklpsw.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedHashSet;
import java.util.Set;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RoleService roleService;

    @Autowired
    IRoleRepository roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/usuarios")
    public String viewUsuarios(@ModelAttribute("usuario") Usuario usuario, Model model){
        model.addAttribute("listaUsuarios", usuarioService.getAllUsuarios());
        model.addAttribute("listaRoles", roleService.getAllRoles());
        return "usuario/viewUsuarios";
    }

    @GetMapping("/Registrar")
    public String addUsuario(@ModelAttribute("message") String message, Model model){
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("message", message);

        return "usuario/viewAddUsuario";
    }

    @PostMapping("/saveUsuario")
    public String saveUsuario(Usuario usuario, RedirectAttributes redirectAttributes){
        String hasPassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(hasPassword);
        if(usuarioService.registrarUsuario(usuario)){
            redirectAttributes.addFlashAttribute("message", "Registro Exitoso");
            return "redirect:/"; // cambiar a redirect:/usuarios
        }

        redirectAttributes.addFlashAttribute("message", "Error al hacer el registro");
        return "redirect:/Registrar";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(Usuario usuario, RedirectAttributes redirectAttributes){
        String hasPassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(hasPassword);
        if(usuarioService.saveOrUpdateUsuario(usuario)){
            redirectAttributes.addFlashAttribute("message", "Registro Exitoso");
            return "redirect:/usuarios"; // cambiar a redirect:/usuarios
        }

        redirectAttributes.addFlashAttribute("message", "Error al hacer el registro");
        return "redirect:/usuarios";
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/editUsuario/{id}")
    public String editUsuario(@PathVariable Integer id, Model model){
        model.addAttribute("usuario", usuarioService.getUsuarioById(id));
        model.addAttribute("listaRoles", roleService.getAllRoles());
        model.addAttribute("rol", usuarioService.getUsuarioById(id).getRol().stream().findFirst().get().getNombre());

        return "usuario/viewEditUsuario";
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @PostMapping("/editSaveUsuario")
    public String editSaveUsuario(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes redirectAttributes){
        if(usuarioService.saveOrUpdateUsuario(usuario)){
            redirectAttributes.addFlashAttribute("message","Usuario actualizado con éxito");
            return "redirect:/usuarios";
        }

        redirectAttributes.addFlashAttribute("message", "Error al actualizar el usuario");
        return "redirect:/editUsuario/" + usuario.getId();
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/deleteUsuario/{id}")
    public String deleteUsuario(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if(usuarioService.deleteUsuario(id)){
            redirectAttributes.addFlashAttribute("message", "Usuario eliminado correctamente");
        }else {
            redirectAttributes.addFlashAttribute("message", "Error al eliminar usuario");
        }

        return "redirect:/usuarios";
    }


}

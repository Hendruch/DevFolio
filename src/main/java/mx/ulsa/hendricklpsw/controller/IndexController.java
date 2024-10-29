package mx.ulsa.hendricklpsw.controller;

import mx.ulsa.hendricklpsw.modelo.Proyecto;
import mx.ulsa.hendricklpsw.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class IndexController {

    @Autowired
    ProyectoService proyectoService;

    @GetMapping({"/", "/index"})
    public String index(@ModelAttribute("proyecto") Proyecto proyecto, Model model){
        model.addAttribute("listaProyectos", proyectoService.getAllProyecto());
        return "index";
    }

    @GetMapping("/403")
    public String not_authorized(){
        return "403";
    }
}

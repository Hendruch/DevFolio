package mx.ulsa.hendricklpsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServicioController {

    @GetMapping("/Servicio")
    public String viewServicio(){
        return "servicios/servicioDetail";
    }
}

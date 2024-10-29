package mx.ulsa.hendricklpsw.controller;

import mx.ulsa.hendricklpsw.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/imagen")
    public String index(Model model) {
        model.addAttribute("images", imageService.getAllImages());
        return "imagen/viewImagen";
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Seleccione un archivo para cargarse.");
        } else {

            try {
                imageService.guardarImagen(file);
                redirectAttributes.addFlashAttribute("message", "Carga de archivo correcto: '" + file.getOriginalFilename() + "'.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/imagen";
        //return "redirect:/displayImage/" + file.getOriginalFilename();
    }

    @GetMapping("/displayImage/{filename:.+}")
    public String displayImage(@PathVariable String filename, Model model) {
        model.addAttribute("filename", filename);
        return "private/imagen/viewImagen";
    }
}

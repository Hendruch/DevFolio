package mx.ulsa.hendricklpsw.controller;

import mx.ulsa.hendricklpsw.modelo.Blog;
import mx.ulsa.hendricklpsw.service.BlogService;
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
public class BlogController {
    
    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public String viewRoles(@ModelAttribute("blog") Blog blog, Model model){
        model.addAttribute("listaBlogs", blogService.getAllBlog());
        return "blog/viewBlog";
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/addBlog")
    public String addBlog(@ModelAttribute("message") String message, Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("message", message);

        return "blog/viewAddBlog";
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @PostMapping("/saveBlog")
    public String saveBlog(Blog blog, RedirectAttributes redirectAttributes){
        if(blogService.saveOrUpdateBlog(blog)){
            redirectAttributes.addFlashAttribute("message", "Registro Exitoso");
            return "redirect:/blogs";
        }

        redirectAttributes.addFlashAttribute("message", "Error al hacer el registro");
        return "redirect:/addBlog";
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/editBlog/{id}")
    public String editBlog(@PathVariable Integer id, Model model){
        model.addAttribute("blog", blogService.getBlogById(id));

        return "blog/viewEditBlog";
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @PostMapping("/editSaveBlog")
    public String editSaveBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        if(blogService.saveOrUpdateBlog(blog)){
            redirectAttributes.addFlashAttribute("message","Blog actualizado con éxito");
            return "redirect:/blogs";
        }

        redirectAttributes.addFlashAttribute("message", "Error al actualizar el blog");
        return "redirect:/editBlog/" + blog.getId();
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/deleteBlog/{id}")
    public String deleteBlog(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if(blogService.deleteBlog(id)){
            redirectAttributes.addFlashAttribute("message", "Blog eliminado correctamente");
        }else {
            redirectAttributes.addFlashAttribute("message", "Error al eliminar blog");
        }

        return "redirect:/blogs";
    }
}

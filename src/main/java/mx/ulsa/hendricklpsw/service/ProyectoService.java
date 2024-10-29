package mx.ulsa.hendricklpsw.service;

import mx.ulsa.hendricklpsw.modelo.Proyecto;
import mx.ulsa.hendricklpsw.repository.IProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProyectoService {

    @Autowired
    IProyectoRepository proyectoRepo;

    private static final String UPLOAD_DIR = "src/main/webapp/images/";

    // Tomar el archivo y guardarlo en el directorio de imagenes
    public void guardarImagen(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
        Files.write(path, bytes);
    }
    public List<Proyecto> getAllProyecto(){
        List<Proyecto> proyectolList = new ArrayList<>();
        proyectoRepo.findAll().forEach(Proyecto -> proyectolList.add(Proyecto));
        return proyectolList;
    }

    public Proyecto getProyectoById(Integer id){return proyectoRepo.findById(id).get(); }

    public boolean saveOrUpdateProyecto(Proyecto proyecto){
        Proyecto updatedProyecto = proyectoRepo.save(proyecto);

        if(proyectoRepo.findById(updatedProyecto.getId()) != null){
            return true;
        }

        return false;
    }

    public boolean deleteProyecto(Integer id){
        proyectoRepo.deleteById(id);
        if(proyectoRepo.findById(id) != null){
            return true;
        }
        return false;
    }
}

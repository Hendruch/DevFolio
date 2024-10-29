package mx.ulsa.hendricklpsw.seeders;

import mx.ulsa.hendricklpsw.modelo.Proyecto;
import mx.ulsa.hendricklpsw.modelo.Role;
import mx.ulsa.hendricklpsw.modelo.Usuario;
import mx.ulsa.hendricklpsw.repository.IProyectoRepository;
import mx.ulsa.hendricklpsw.repository.IRoleRepository;
import mx.ulsa.hendricklpsw.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class UsuarioSeeder implements ApplicationRunner {

    @Autowired
    IUsuarioRepository usuarioRepo;

    @Autowired
    IRoleRepository roleRepo;

    @Autowired
    IProyectoRepository proyectoRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Superadmin
        Set<Role> roles = new LinkedHashSet<Role>();
        roles.add(new Role(Integer.valueOf(1), "ROLE_SUPERADMIN", "administrador general con operaciones CRUD"));

        Usuario admin = new Usuario(Integer.valueOf(1), "Administrador","admin@mail.com", "secreto", "9511234568", roles);
        String hashedPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(hashedPassword);
        usuarioRepo.save(admin);

        //Usuario
        Set<Role> rolesDirDoc = new LinkedHashSet<Role>();
        rolesDirDoc.add(new Role(Integer.valueOf(2), "ROLE_USUARIO", "leer, crear, actualizar"));

        Usuario usuarioDirDoc = new Usuario(Integer.valueOf(2), "Usuario","usuario@mail.com", "secreto", "9511234567", rolesDirDoc);
        hashedPassword = passwordEncoder.encode(usuarioDirDoc.getPassword());
        usuarioDirDoc.setPassword(hashedPassword);
        usuarioRepo.save(usuarioDirDoc);


        //Proyecto
        Proyecto proyectoOp = new Proyecto("Página Web", "Web Development", Date.from(Instant.now()), "web-min.png", 3000.00);
        proyectoRepo.save(proyectoOp);

        Proyecto proyectoOp2 = new Proyecto("SOC", "Cybersecurity", Date.from(Instant.now()), "cyber.png", 4000.00);
        proyectoRepo.save(proyectoOp2);

        Proyecto proyectoOp3 = new Proyecto("App Movil", "Mobile Development", Date.from(Instant.now()), "mobile.png", 5000.00);
        proyectoRepo.save(proyectoOp3);

        //Role default
        Role roleD = new Role(Integer.valueOf(-1), "ROLE_DEFAULT", "Por defecto");
        roleRepo.save(roleD);

    }
}

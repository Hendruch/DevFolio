package mx.ulsa.hendricklpsw.service;

import mx.ulsa.hendricklpsw.modelo.Role;
import mx.ulsa.hendricklpsw.modelo.Usuario;
import mx.ulsa.hendricklpsw.repository.IRoleRepository;
import mx.ulsa.hendricklpsw.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    IUsuarioRepository usuarioRepo;
    @Autowired
    IRoleRepository roleRepository;


    public List<Usuario> getAllUsuarios(){
        List<Usuario> usrList = new ArrayList<>();
        usuarioRepo.findAll().forEach(usuario -> usrList.add(usuario));
        return usrList;
    }

    public Usuario getUsuarioById(Integer id){return usuarioRepo.findById(id).get(); }

    public boolean registrarUsuario(Usuario usuario){
        Set<Role> role =  new LinkedHashSet<>();
        role.add( roleRepository.findByNombre("ROLE_USUARIO").orElse(null));

        usuario.setRol(role);

        Usuario updatedUsuario = usuarioRepo.save(usuario);

        if(usuarioRepo.findById(updatedUsuario.getId()) != null){
            return true;
        }

        return false;
    }

    public boolean saveOrUpdateUsuario(Usuario usuario){
        //usuario.setId(8);
        Usuario updatedUsuario = usuarioRepo.save(usuario);
        if(usuarioRepo.findById(updatedUsuario.getId()) != null){
            return true;
        }

        return false;
    }

    public boolean deleteUsuario(Integer id){
        try {
            Usuario user = usuarioRepo.findById(id).orElse(null);
            user.setRol(null);
            saveOrUpdateUsuario(user);
            usuarioRepo.delete(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Usuario getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        /*
        Usuario user = (Usuario)authentication.getPrincipal();

        return  user;
         */
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                // Retrieve details from your custom Usuario class
                UserDetails userDetails = (UserDetails) principal;
                // Assuming Usuario extends UserDetails
                return (Usuario) userDetails;
            }
        }
        return null;
    }

    public List<Usuario> getUsersByRole(Set<Role> roles){
        return usuarioRepo.findByRolIn(roles);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario user = usuarioRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

        Set<GrantedAuthority> authorities = user.getRol().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getNombre()))
                .collect(Collectors.toSet());

        return user;
        /*
                org.springframework.security.core.userdetails.User(
                email,
                user.getPassword(),
                authorities
        );

         */
    }

}

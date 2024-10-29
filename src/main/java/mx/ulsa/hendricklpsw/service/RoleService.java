package mx.ulsa.hendricklpsw.service;

import mx.ulsa.hendricklpsw.modelo.Role;
import mx.ulsa.hendricklpsw.modelo.Usuario;
import mx.ulsa.hendricklpsw.repository.IRoleRepository;
import mx.ulsa.hendricklpsw.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleService {

    @Autowired
    IRoleRepository rolRepo;

    @Autowired
    UsuarioService usuarioService;

    public List<Role> getAllRoles(){
        List<Role> rolList = new ArrayList<>();
        rolRepo.findAll().forEach(Rol -> rolList.add(Rol));
        return rolList;
    }

    public Role getRolById(Integer id){return rolRepo.findById(id).get(); }

    public boolean saveOrUpdateRol(Role rol){
        Role updatedRol = rolRepo.save(rol);

        if(rolRepo.findById(updatedRol.getId()).get() != null){
            return true;
        }

        return false;
    }

    public boolean deleteRol(Integer id) {
        Role rolToDelete = rolRepo.findById(id).orElse(null);
        if (rolToDelete == null) {
            return false; // Role not found
        }

        Role rolDefault = rolRepo.findByNombre("ROLE_DEFAULT").orElse(null);
        if (rolDefault == null) {
            return false; // Default role not found
        }

        // Get users with the role to delete
        Set<Role> rolesToDelete = new LinkedHashSet<>();
        rolesToDelete.add(rolToDelete);
        List<Usuario> usuarioList = usuarioService.getUsersByRole(rolesToDelete);

        // Assign the default role to the users
        Set<Role> rolesDefault = new LinkedHashSet<>();
        rolesDefault.add(rolDefault);

        for (Usuario u : usuarioList) {
            u.setRol(rolesDefault);
            usuarioService.saveOrUpdateUsuario(u);
        }

        // Delete the role
        rolRepo.deleteById(id);

        // Check if the role is still present (it should not be)
        return rolRepo.findById(id).isEmpty();
    }
}

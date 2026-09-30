package acceso.services;

import java.util.stream.Collectors;

import acceso.dtos.RolDto;
import acceso.entity.models.Permiso;
import acceso.entity.models.Rol;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import acceso.entity.repository.PermisoRepository;
import acceso.entity.repository.RolesRepository;

@ApplicationScoped
public class RolesServices extends FactoryCrud<Rol, RolesRepository> {

    @Inject
    PermisoRepository rolesRepository;

   
    @Transactional 
    public Rol crear(RolDto rol) {
        Rol rolNew = new Rol();
        rolNew.description = rol.description();
        rolNew.activo = rol.activo();

        var permiso = rol.permiso()
        .stream()
        .map(p -> rolesRepository.findById(p))
        .collect(Collectors.toSet());
        rolNew.permisos = permiso;
        this.repository.persist(rolNew);
        return rolNew;
    }
}

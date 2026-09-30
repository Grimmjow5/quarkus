package acceso.entity.repository;

import acceso.entity.models.Rol;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped 
public class RolesRepository implements PanacheRepository<Rol>  {


}

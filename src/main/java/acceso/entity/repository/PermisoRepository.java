package acceso.entity.repository;

import acceso.entity.models.Permiso;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped 
public class PermisoRepository implements PanacheRepository<Permiso>{


}

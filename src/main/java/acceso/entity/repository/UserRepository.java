package acceso.entity.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import acceso.entity.models.User;



@ApplicationScoped 
public class UserRepository implements PanacheRepository<User> {
    
}

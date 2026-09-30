package acceso;

import acceso.entity.repository.PermisoRepository;
import acceso.entity.models.Permiso;
import java.util.Map;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Path("/permisos")
public class PermisosController {

    @Inject
    PermisoRepository permisoRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public Response hello() {
        var lista = permisoRepository.findAll().stream();
        return Response.ok(lista).build();
    }

    @POST

    public Response createUser(Permiso permiso) {
        permisoRepository.persist(permiso);
        return Response.ok().build();
    }

}

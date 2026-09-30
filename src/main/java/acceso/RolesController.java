package acceso;

import acceso.dtos.RolDto;
import acceso.entity.models.Rol;
import acceso.entity.repository.RolesRepository;
import acceso.services.RolesServices;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/roles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RolesController {

    @Inject
    RolesServices services;

    @POST
    public Response create(RolDto rol) {
        Rol newRol = this.services.crear(rol);
        return Response.status(Response.Status.CREATED)
        .entity(newRol).build();

    }

}

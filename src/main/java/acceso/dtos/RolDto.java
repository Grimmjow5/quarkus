package acceso.dtos;

import java.util.Set;

public record RolDto(Long id, String description, boolean activo,Set<Long> permiso) {

}

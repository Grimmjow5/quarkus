package acceso.entity.models;

import io.quarkus.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "permisos")
@Table(name = "permisos", uniqueConstraints = {
        @UniqueConstraint(name = "permisos_unique", columnNames = { "modulo", "accion" })
})
public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permiso_req")
    @SequenceGenerator(name = "permiso_req", sequenceName = "permiso_req", allocationSize = 1)
    public Long id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String modulo;

    @Enumerated(EnumType.STRING)
    public AccionPermiso accion;

    public String descripcion;
    public boolean activo = true;

}

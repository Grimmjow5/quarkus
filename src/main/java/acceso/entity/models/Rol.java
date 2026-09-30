package acceso.entity.models;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.UniqueConstraint;


@Entity(name = "roles")
public class Rol {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)     
    public Long id;

    @Column(unique = true, nullable = false)
    public String description;

    @Column 
    public boolean activo = true;

   

    ///Uniones de cada a otras tablas
    //Relacion de uno a muchos
    @OneToMany(fetch = FetchType.EAGER)    
    @JoinTable(//Esto creara una tabla separa que se llamara joinTable
        name = "rol_permiso",
        joinColumns = @JoinColumn(name="rol_id"),
        inverseJoinColumns = @JoinColumn(name="permiso_id"),
        uniqueConstraints = @UniqueConstraint(columnNames = {"rol_id", "permiso_id"})

    )
    public Set<Permiso> permisos;


}

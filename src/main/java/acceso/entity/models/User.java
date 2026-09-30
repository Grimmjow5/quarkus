package acceso.entity.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    public Long id;

    public String name;

    // Ignorar en resultado de json
    @JsonIgnore
    @Column(nullable = false)
    public String password;

    @Column(unique = true)
    public String email;

    // Relación de muchos a muchos limitados por la condición de la convinación
    @ManyToMany
    @JoinTable(name = "usuarios_rol", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"), uniqueConstraints = @UniqueConstraint(columnNames = {
            "user_id", "rol_id" }))
    public Set<Rol> rol;

}

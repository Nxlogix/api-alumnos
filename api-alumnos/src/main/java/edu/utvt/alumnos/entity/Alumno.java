package edu.utvt.alumnos.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "alumnos", indexes = {
        @Index(name = "idx_matricula", columnList = "matricula"),
        @Index(name = "idx_correo_electronico", columnList = "correo_electronico"),
        @Index(name = "idx_activo", columnList = "activo")
})
/**
 * Entidad JPA que representa a un alumno en la base de datos.
 *
 * Contiene información personal y académica básica del alumno, como
 * matrícula, nombres, correo electrónico, carrera y semestre. La entidad
 * también almacena si el alumno está activo y la fecha de registro.
 */
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 20, nullable = false, unique = true)
    /** Matrícula del alumno. Única y no nula. */
    private String matricula;

    @Column(length = 100, nullable = false)
    /** Nombre(s) del alumno. */
    private String nombre;

    @Column(name = "apellido_paterno", length = 100, nullable = false)
    /** Apellido paterno del alumno. */
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 100)
    /** Apellido materno del alumno (opcional). */
    private String apellidoMaterno;

    @Column(name = "correo_electronico", length = 255, nullable = false, unique = true)
    /** Correo electrónico del alumno. Único y no nulo. */
    private String correoElectronico;

    @Column(length = 10)
    /** Teléfono de contacto del alumno (opcional). */
    private String telefono;

    @Column(name = "fecha_nacimiento", nullable = false)
    /** Fecha de nacimiento del alumno. */
    private LocalDate fechaNacimiento;

    @Column(length = 100, nullable = false)
    /** Nombre de la carrera o programa académico. */
    private String carrera;

    @Column(nullable = false)
    /** Semestre actual del alumno. */
    private Integer semestre;

    @Column(nullable = false)
    /** Indica si el alumno está activo en el sistema. Por defecto true. */
    private boolean activo = true;

    @CreationTimestamp
    @Column(name = "fecha_registro", nullable = false, updatable = false)
    /** Marca de tiempo automática de cuando se registró el alumno. */
    private LocalDateTime fechaRegistro;
}

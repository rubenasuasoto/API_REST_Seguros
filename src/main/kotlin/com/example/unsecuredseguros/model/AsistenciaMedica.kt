package com.example.unsecuredseguros.model
import java.time.LocalDate
import java.time.LocalTime
import jakarta.persistence.*


@Entity
@Table(name = "asistencias_medicas")
data class AsistenciaMedica(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia_medica")
    val idAsistenciaMedica: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seguro", nullable = false)
    val seguro: Seguro,

    @Column(name = "breve_descripcion", nullable = false)
    val breveDescripcion: String,

    @Column(name = "lugar", nullable = false)
    val lugar: String,

    @Column(name = "explicacion", nullable = false)
    val explicacion: String,

    @Column(name = "tipo_asistencia", nullable = false, length = 100)
    val tipoAsistencia: String,

    @Column(name = "fecha", nullable = false)
    val fecha: LocalDate,

    @Column(name = "hora", nullable = false)
    val hora: LocalTime,

    @Column(name = "importe", nullable = false, precision = 12, scale = 2,)
    val importe: Double
)

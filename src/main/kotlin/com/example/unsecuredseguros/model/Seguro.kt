package com.example.unsecuredseguros.model

import jakarta.persistence.*
import java.util.Date
@Entity
@Table(name = "seguros")
data class Seguro(
    @Column(name = "id_seguro")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idSeguro: Int,
    @Column(nullable = false , length = 10)
    val nif: String,
    @Column(nullable = false , length = 100)
    var nombre: String,
    @Column(nullable = false , length = 100)
    var ape1: String,
    @Column( length = 100)
    val ape2: String?,
    @Column(nullable = false )
    var edad: Int,
    @Column(nullable = false )
    val numHijos: Int,
    @Column(name = "fecha_creacion" , nullable = false)
    val fechaCreacion: Date,
    @Column(nullable = false , length = 10)
    val sexo: String,
    @Column(nullable = false)
    val casado: Boolean,
    @Column(nullable = false)
    val embarazada: Boolean
)
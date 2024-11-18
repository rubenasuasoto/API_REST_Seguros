package com.exam

import com.example.unsecuredseguros.excepciones.ValiadationException


import com.example.unsecuredseguros.model.Seguro
import com.example.unsecuredseguros.service.SeguroService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/seguros")
class SeguroController {

    @Autowired
    private lateinit var seguroService: SeguroService

    // Método para insertar un nuevo seguro
    @PostMapping
    fun insert(@RequestBody autornuevo: Seguro): Seguro? {
        // Delegar al servicio
        return seguroService.insert(autornuevo)
    }

    // Método para obtener un seguro por ID
    @GetMapping("/{id}")
    fun getByID(@PathVariable id: String?): ResponseEntity<Seguro>? {
        if (id!!.isBlank()  || id =="a") {
           throw ValiadationException("El id no puede estar vacio")
        }
        val s:Seguro? = seguroService.getById(id)

        return ResponseEntity(s,HttpStatus.OK)
    }

    // Método para actualizar un seguro existente
    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody seguroActualizado: Seguro): Seguro? {
        if (id.isNullOrEmpty()) {
            return null
        }
        return seguroService.update(id, seguroActualizado)
    }

    // Método para eliminar un seguro por ID
    @DeleteMapping("/{id}")
    fun deleteByID(@PathVariable id: String): Boolean {
        if (id.isNullOrEmpty()) {
            return false
        }
        return seguroService.deleteById(id)
    }
}

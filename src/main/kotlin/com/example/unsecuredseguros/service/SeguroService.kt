package com.example.unsecuredseguros.service
import com.example.unsecuredseguros.model.Seguro
import com.example.unsecuredseguros.repository.SeguroRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody

@Service
class SeguroService {

    @Autowired
    private lateinit var seguroRepository: SeguroRepository


    fun insert(@RequestBody seguronuevo: Seguro): Seguro? {
        if (seguronuevo.nombre.isNullOrBlank() || seguronuevo.nombre.length > 100) {
            return null
        }
        if (seguronuevo.ape1.isNullOrBlank() || seguronuevo.ape1.length > 100) {
            return null
        }
        if (seguronuevo.edad <= 0) {
            return null
        }

        // Guardar el seguro en el repositorio
        return seguroRepository.save(seguronuevo)
    }

    // Método para obtener un seguro por su ID
    @GetMapping("/{id}")
    fun getById(id: String): Seguro? {
        var idl: Int = 0
        try {
            idl = id.toInt()
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
        return seguroRepository.findByIdOrNull(idl)
    }

    // Método para actualizar un seguro existente
    fun update(id: String, @RequestBody seguroActualizado: Seguro): Seguro? {
        var idl: Int = 0
        try {
            idl = id.toInt()
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

        val seguroExistente = seguroRepository.findByIdOrNull(idl) ?: return null

        // Actualizar los campos necesarios
        seguroExistente.nombre = seguroActualizado.nombre
        seguroExistente.ape1 = seguroActualizado.ape1
        seguroExistente.edad = seguroActualizado.edad

        // Guardar los cambios
        return seguroRepository.save(seguroExistente)
    }

    @DeleteMapping("/{id}")
    fun deleteById(id: String): Boolean {
        var idl: Int = 0
        try {
            idl = id.toInt()
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }

        return if (seguroRepository.existsById(idl)) {
            seguroRepository.deleteById(idl)
            true
        } else {
            false
        }
    }
}

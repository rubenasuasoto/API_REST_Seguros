package com.example.unsecuredseguros.service

import com.example.unsecuredseguros.model.Seguro
import com.example.unsecuredseguros.repository.SeguroRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import kotlin.math.absoluteValue


@Service
class SeguroService {
    @Autowired
    private lateinit var seguroRepository: SeguroRepository

    fun insert(
        @RequestBody seguronuevo: Seguro
    ):Seguro?{
        /*
        //Logica de negocio


         */

        if (seguronuevo.nombre.isNullOrBlank() || seguronuevo.nombre.length > 100) {
            return null
        }
        if (seguronuevo.ape1.isNullOrBlank() || seguronuevo.ape1.length > 100) {
            return null
        }
        if (seguronuevo.edad <= 0) {
            return null
        }


        return null
    }
    fun getById(id:String):Seguro?{
        //1º Implementar la logica del negocio
        var   idl : Int = 0
        try {
            idl = id.toInt()
        } catch (e:Exception) {
            e.printStackTrace()
            return null
        }
        //  2º comunicación con repository
        val seguro: Seguro? = seguroRepository.findByIdOrNull(idl)
        return seguro
    }
}


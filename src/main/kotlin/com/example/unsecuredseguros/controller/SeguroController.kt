package com.example.unsecuredseguros.controller
import com.example.unsecuredseguros.model.Seguro
import com.example.unsecuredseguros.service.SeguroService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
@RestController
@RequestMapping("/seguros")
class SeguroController {
    private lateinit var seguroService: SeguroService

    fun insert(
        @RequestBody autornuevo : Seguro
    ):Seguro?{




        return null
    }
    @GetMapping("/{id}") // URI de este metodo -> localhost:8080/auotres/2
    fun getByID(
        @PathVariable id:String
    ):Seguro?{
        //Comprobacion basica de parametros de entrada
        if (id.isNullOrEmpty()){
            return null
        }
        // 2º Comunico el controller con el service
        return seguroService.getById(id)

    }

}

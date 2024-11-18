package com.example.unsecuredseguros.excepciones

class ValiadationException(mensaje:String)
    : Exception("Error en la validacion (400). $mensaje") {

}
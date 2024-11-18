package com.example.unsecuredseguros.excepciones

class NotFoundException(mensaje:String)
    : Exception("Not found exception (404). $mensaje") {
}
package com.example.unsecuredseguros.utils

object DniValidator {

    private val DNI_FORMAT_REGEX = "^[A-Za-z]{9}\\d$";
    fun CheckDniFormat(dni : String):Boolean{

        return DNI_FORMAT_REGEX.toRegex().matches(dni)
    }
}
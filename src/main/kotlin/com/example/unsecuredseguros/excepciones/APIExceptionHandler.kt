﻿package com.example.unsecuredseguros.excepciones

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

class APIExceptionHandler {
    @ExceptionHandler(IllegalArgumentException::class, NumberFormatException::class,ValiadationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleBadRequest(request: HttpServletRequest, e:Exception):ErrorRespuesta {
        return ErrorRespuesta(e.message!!,request.requestURI)
    }
    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    fun handleNotFound(request: HttpServletRequest, e:Exception):ErrorRespuesta {
        return ErrorRespuesta(e.message!!,request.requestURI)
    }
}
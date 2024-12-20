package com.premier.app.infra.validation.exception

class ValidationException (
    override val message: String,
    val field: String
) : RuntimeException(message)
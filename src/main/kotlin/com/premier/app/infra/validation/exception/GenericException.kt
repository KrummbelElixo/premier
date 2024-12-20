package com.premier.app.infra.validation.exception

import com.premier.app.infra.validation.ErrorField

class GenericException(
    override val message: String,
    val title: String,
    val status: Int,
    val errors: MutableList<ErrorField> = mutableListOf()
): RuntimeException(message) {
}
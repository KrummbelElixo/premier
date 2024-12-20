package com.premier.app.infra.validation.exception

class NotFoundException(
    override val message: String,
    val field: String
) : RuntimeException(message) {
}
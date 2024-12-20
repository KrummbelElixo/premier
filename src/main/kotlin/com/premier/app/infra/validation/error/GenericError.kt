package com.premier.app.infra.validation.error

import com.premier.app.infra.validation.BadRequestBody

class GenericError : BadRequestBody (
    title = "Undefined",
    status = 0,
    errors = mutableListOf()
) {
}
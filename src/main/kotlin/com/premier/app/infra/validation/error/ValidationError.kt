package com.premier.app.infra.validation.error

import com.premier.app.infra.validation.BadRequestBody

class ValidationError : BadRequestBody (
    title = "Validation Error",
    status = 400,
    errors = mutableListOf()
) {
}
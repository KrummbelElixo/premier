package com.premier.app.infra.validation.error

import com.premier.app.infra.validation.BadRequestBody

class NotFoundError : BadRequestBody(
    title = "Not Found Error",
    status = 404,
    errors = mutableListOf()
) {
}
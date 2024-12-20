package com.premier.app.infra.validation

open class BadRequestBody (
    var title: String,
    var status: Int,
    var errors: MutableList<ErrorField>
)
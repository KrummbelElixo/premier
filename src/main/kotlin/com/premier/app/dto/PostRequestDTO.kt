package com.premier.app.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

@JvmRecord
data class PostRequestDTO(
    @field:NotNull(message = "Content field should be not null")
    @field:NotEmpty(message = "Content field should be not empty")
    val content: String
)

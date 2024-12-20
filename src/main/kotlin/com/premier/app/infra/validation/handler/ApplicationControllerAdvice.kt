package com.premier.app.infra.validation.handler

import com.premier.app.infra.validation.ErrorField
import com.premier.app.infra.validation.error.GenericError
import com.premier.app.infra.validation.error.NotFoundError
import com.premier.app.infra.validation.error.ValidationError
import com.premier.app.infra.validation.exception.GenericException
import com.premier.app.infra.validation.exception.NotFoundException
import com.premier.app.infra.validation.exception.ValidationException
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
@ControllerAdvice
class ApplicationControllerAdvice {

    @ExceptionHandler(GenericException::class)
    fun handleGenericException(exception: GenericException): ResponseEntity<GenericError> {
        val genericError = GenericError()

        genericError.title = exception.title
        genericError.status = exception.status
        genericError.errors = exception.errors

        return ResponseEntity(genericError, HttpStatusCode.valueOf(genericError.status))
    }

    @ExceptionHandler(ValidationException::class)
    fun handleValidationException(exception: ValidationException): ResponseEntity<ValidationError> {
        val validationError = ValidationError()

        validationError.errors.add(ErrorField(
            field = exception.field,
            message = exception.message
        ))

        return ResponseEntity(validationError, HttpStatusCode.valueOf(400))
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException): ResponseEntity<ValidationError> {
        val validationError = ValidationError()

        for(ex in exception.fieldErrors) {
            validationError.errors.add(
                ErrorField(
                    ex.field,
                    ex.defaultMessage.toString()
                )
            )
        }

        return ResponseEntity(validationError, HttpStatusCode.valueOf(400))
    }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(exception: NotFoundException): ResponseEntity<NotFoundError> {
        val notFoundError = NotFoundError()

        notFoundError.errors.add(
            ErrorField(
                field = exception.field,
                message = exception.message
            )
        )

        return ResponseEntity(notFoundError, HttpStatusCode.valueOf(404))
    }
}
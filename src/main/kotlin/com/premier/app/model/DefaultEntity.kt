package com.premier.app.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Id

@MappedSuperclass
class DefaultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
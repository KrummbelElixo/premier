package com.premier.app.model

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class Post(
    @Column(nullable = false)
    val context: String
) : DefaultEntity()
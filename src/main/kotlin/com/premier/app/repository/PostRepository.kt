package com.premier.app.repository

import com.premier.app.model.Post
import org.springframework.data.repository.CrudRepository

interface PostRepository : CrudRepository<Post, Long>
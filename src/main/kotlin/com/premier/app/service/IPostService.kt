package com.premier.app.service

import com.premier.app.dto.PostRequestDTO
import com.premier.app.model.Post

interface IPostService {
    fun create(dto: PostRequestDTO): Post

    fun listPosts(): List<Post>
}
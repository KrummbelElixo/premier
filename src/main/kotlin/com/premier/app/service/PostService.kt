package com.premier.app.service

import com.premier.app.dto.PostRequestDTO
import com.premier.app.infra.validation.exception.ValidationException
import com.premier.app.model.Post
import com.premier.app.repository.PostRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class PostService(
    val postRepository: PostRepository
) : IPostService {

    @Transactional
    override fun create(dto: PostRequestDTO): Post {
        val post = Post(dto.content)

        postRepository.save(post)

        return post
    }

    override fun listPosts(): List<Post> {
        return postRepository.findAll().toList()
    }
}
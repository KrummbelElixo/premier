package com.premier.app.dto

import com.premier.app.model.Post

data class PostResponseDTO(
    val id: Long,
    val content: String
) {
    companion object {
        fun valueOf(post: Post): PostResponseDTO {
            return PostResponseDTO(
                post.id ?: throw IllegalStateException(),
                post.context
            )
        }
    }
}

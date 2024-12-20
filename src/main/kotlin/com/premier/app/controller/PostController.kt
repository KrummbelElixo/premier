package com.premier.app.controller

import com.premier.app.dto.PostRequestDTO
import com.premier.app.dto.PostResponseDTO
import com.premier.app.service.IPostService
import jakarta.validation.Valid
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/posts")
class PostController(
    val postService: IPostService
) {

    @PostMapping
    fun create(@RequestBody @Valid dto: PostRequestDTO): ResponseEntity<PostResponseDTO> {
        val post = postService.create(dto)

        return ResponseEntity(PostResponseDTO.valueOf(post), HttpStatusCode.valueOf(201))
    }

    @GetMapping
    fun listAll(): ResponseEntity<List<PostResponseDTO>> {
        return ResponseEntity.ok(postService.listPosts().map {
            PostResponseDTO.valueOf(it)
        })
    }
}
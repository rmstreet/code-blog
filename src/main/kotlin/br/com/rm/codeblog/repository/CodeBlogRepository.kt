package br.com.rm.codeblog.repository

import br.com.rm.codeblog.model.Post
import org.springframework.data.jpa.repository.JpaRepository

interface CodeBlogRepository : JpaRepository<Post, Long> {
}
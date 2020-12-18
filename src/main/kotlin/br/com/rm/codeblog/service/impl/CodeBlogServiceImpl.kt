package br.com.rm.codeblog.service.impl

import br.com.rm.codeblog.model.Post
import br.com.rm.codeblog.repository.CodeBlogRepository
import br.com.rm.codeblog.service.CodeBlogService
import org.springframework.stereotype.Service

@Service
class CodeBlogServiceImpl(
        private val codeBlogRepository: CodeBlogRepository
) : CodeBlogService{

    override fun findAll(): List<Post> {
        return codeBlogRepository.findAll()
    }

    override fun findById(id: Long): Post {
        return codeBlogRepository.findById(id).get()
    }

    override fun save(post: Post): Post {
        return codeBlogRepository.save(post)
    }

}
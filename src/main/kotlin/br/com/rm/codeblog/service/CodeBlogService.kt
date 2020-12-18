package br.com.rm.codeblog.service

import br.com.rm.codeblog.model.Post

interface CodeBlogService {

    fun findAll(): List<Post>;
    fun findById(id: Long): Post;
    fun save(post: Post): Post;

}
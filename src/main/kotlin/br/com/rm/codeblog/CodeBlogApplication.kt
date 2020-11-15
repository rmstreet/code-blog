package br.com.rm.codeblog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CodeBlogApplication

fun main(args: Array<String>) {
	runApplication<CodeBlogApplication>(*args)
}

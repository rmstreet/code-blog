package br.com.rm.codeblog.controller

import br.com.rm.codeblog.model.Post
import br.com.rm.codeblog.service.CodeBlogService
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.time.LocalDate
import javax.validation.Valid

@Controller
class CodeBlogController(
        val codeBlogService: CodeBlogService
) {

    @RequestMapping(value = ["/posts"], method = [RequestMethod.GET])
    fun getPosts(): ModelAndView{
        val mv = ModelAndView("posts")
        val posts = codeBlogService.findAll()
        mv.addObject("posts", posts)
        return mv
    }

    @RequestMapping(value = ["/posts/{id}"], method = [RequestMethod.GET])
    fun getPostDetails(@PathVariable("id") id: Long): ModelAndView{
        val mv = ModelAndView("postDetails")
        val post = codeBlogService.findById(id)
        mv.addObject("post", post)
        return mv
    }

    @RequestMapping(value = ["/newpost"], method = [RequestMethod.GET])
    fun getPostForm(): String = "postForm"

    @RequestMapping(value = ["/newpost"], method = [RequestMethod.POST])
    fun savePost(@Valid post: Post, result: BindingResult, attributes: RedirectAttributes): String{
        if(result.hasErrors()){
            return "redirect:/newpost"
        }

        post.date = LocalDate.now()
        codeBlogService.save(post)

        return "redirect:/posts"
    }

}
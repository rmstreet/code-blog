package br.com.rm.codeblog.utils

import br.com.rm.codeblog.model.Post
import br.com.rm.codeblog.repository.CodeBlogRepository
import org.springframework.stereotype.Component
import java.time.LocalDate
import javax.annotation.PostConstruct

@Component
class DummyData(
        private val codeBlogRepository: CodeBlogRepository
) {

    @PostConstruct
    fun savePosts(){
        val existData = codeBlogRepository.count() > 0
        if(!existData){
            val posts = listOf(
                    Post(
                            id = 1,
                            title = "Ted Poof",
                            author = "Nolan Holmes",
                            date = LocalDate.now(),
                            text = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."
                    ),
                    Post(
                            id = 2,
                            title = "Short Thank",
                            author = "Siff Cold",
                            date = LocalDate.now(),
                            text = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."
                    ),
                    Post(
                            id = 3,
                            title = "Ok Tok",
                            author = "Tuck Fries",
                            date = LocalDate.now(),
                            text = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."
                    ),
                    Post(
                            id = 4,
                            title = "Shield Blank",
                            author = "Fenix Richard",
                            date = LocalDate.now(),
                            text = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."
                    ),
                    Post(
                            id = 5,
                            title = "Vigen Alone",
                            author = "Duff Puff",
                            date = LocalDate.now(),
                            text = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."
                    )
            )

            posts.forEach {
                val postSaved = codeBlogRepository.save(it)
                println(postSaved.id)
            }
        }
    }

}
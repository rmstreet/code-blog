package br.com.rm.codeblog.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "TB_POST")
data class Post(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,

        @NotBlank
        val title: String,

        @NotBlank
        val author: String,

        @NotBlank
        @Lob
        val text: String,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        var date: LocalDate?
)
package com.example.Quizzes_Application.EntryDTOs;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CreateQuizDTO {

    private String question;

    private String[] options;

    private int rightAnswer ;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}

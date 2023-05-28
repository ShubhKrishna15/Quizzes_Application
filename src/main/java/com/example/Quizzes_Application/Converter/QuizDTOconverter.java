package com.example.Quizzes_Application.Converter;

import com.example.Quizzes_Application.Entities.Quiz;
import com.example.Quizzes_Application.EntryDTOs.CreateQuizDTO;
import lombok.Builder;

public class QuizDTOconverter {

    public static Quiz convertDTO(CreateQuizDTO createQuizDTO){

        Quiz quiz =Quiz.builder()
                .question(createQuizDTO.getQuestion())
                .endDate(createQuizDTO.getEndDate())
                .startDate(createQuizDTO.getStartDate())
                .options(createQuizDTO.getOptions())
                .rightAnswer(createQuizDTO.getRightAnswer())
                .build();

        return quiz;
    }
}

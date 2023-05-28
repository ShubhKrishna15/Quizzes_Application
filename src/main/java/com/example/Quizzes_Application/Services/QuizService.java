package com.example.Quizzes_Application.Services;


import com.example.Quizzes_Application.Converter.QuizDTOconverter;
import com.example.Quizzes_Application.Entities.Quiz;
import com.example.Quizzes_Application.EntryDTOs.CreateQuizDTO;
import com.example.Quizzes_Application.Enums.QuizEnum;
import com.example.Quizzes_Application.Repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {


    @Autowired
    QuizRepository quizRepository;
    public String createQuiz(CreateQuizDTO createQuizDTO) throws Exception {
        Quiz quiz = QuizDTOconverter.convertDTO(createQuizDTO);

        quizRepository.save(quiz);

        return "Your Quiz has been created";


    }

    @Cacheable("dataCache")
    public Quiz retrieveActiveQuiz() throws Exception {

        List<Quiz> quizList = quizRepository.findAll();
        LocalDateTime now = LocalDateTime.now();
        List<Quiz> ans = new ArrayList<>();

        for (Quiz quiz : quizList) {
            if (quiz.getStartDate().isBefore(now) && quiz.getEndDate().isAfter(now)) {
                ans.add(quiz);
            }
        }

        if (!ans.isEmpty()) {
            return ans.get(0);
        }

        return null;


    }


    @Cacheable("dataCache")
    public List<Quiz> retrieveAllQuizzes() throws Exception{

        List<Quiz> quizzes = quizRepository.findAll();
        if(!quizzes.isEmpty()){
            return quizzes;
        }
        return null;
    }


    @Scheduled(cron = "0 * * * * *")
    public void updateStatus(){
        List<Quiz> quizList = quizRepository.findAll();
        LocalDateTime now = LocalDateTime.now();
        for(Quiz quiz : quizList){

            if(quiz.getEndDate().isBefore(now)){
                quiz.setStatus(QuizEnum.finished);
            }else if(quiz.getEndDate().isAfter(now) && quiz.getStartDate().isBefore(now)){
                quiz.setStatus(QuizEnum.active);
            }else if(quiz.getStartDate().isAfter(now)){
                quiz.setStatus(QuizEnum.inactive);

            }
        }

        quizRepository.saveAll(quizList);


    }

    public int resultOdQuiz(int id) {

        Quiz quiz = quizRepository.getReferenceById(id);
        return quiz.getRightAnswer();
    }
}

package com.example.Quizzes_Application.Controllers;


import com.example.Quizzes_Application.Entities.Quiz;
import com.example.Quizzes_Application.EntryDTOs.CreateQuizDTO;
import com.example.Quizzes_Application.Services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {


    @Autowired
    QuizService quizService;



    @PostMapping()
    public ResponseEntity<String> createQuiz(@RequestBody CreateQuizDTO createQuizDTO){
        try{
            String result = quizService.createQuiz(createQuizDTO);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch(Exception e){
            String response = "Quiz was not created";
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

    }

        @GetMapping("/active")
    public ResponseEntity<Quiz> retrieveActiveQuiz(){

        try {
            Quiz result = quizService.retrieveActiveQuiz();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/all")
        public ResponseEntity<List<Quiz>> retrieveAllQuizzes(){

        try {
            List<Quiz> result = quizService.retrieveAllQuizzes();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/{id}/result")
    public ResponseEntity<Integer> resultOfQuiz(@PathVariable("id") int id){
        try{
            int result = quizService.resultOdQuiz(id);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}

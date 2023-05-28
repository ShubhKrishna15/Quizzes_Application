package com.example.Quizzes_Application.Repositories;


import com.example.Quizzes_Application.Entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {



}

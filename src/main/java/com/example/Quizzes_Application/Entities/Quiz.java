package com.example.Quizzes_Application.Entities;


import com.example.Quizzes_Application.Enums.QuizEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "quiz")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String question;

    private String[] options;

    private int rightAnswer ;


    @NonNull
    private LocalDateTime startDate;
    @NonNull
    private LocalDateTime endDate;

    @Enumerated(value = EnumType.STRING)
    private QuizEnum status;

}

package com.example.coursework_2;

import com.example.coursework_2.Exceptions.Bad_Request;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{
//    Random random = new Random();
   private final QuestionService questionService;

    ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection <Question> getQuestions(int amount) {
        Set<Question> que = new HashSet<>();
        for (int i = 0; i < amount; i++) {
            que.add(questionService.getRandomQuestion());
        }
        if (amount > que.size()) {
            throw new Bad_Request();
        }
        return que;
    }
}

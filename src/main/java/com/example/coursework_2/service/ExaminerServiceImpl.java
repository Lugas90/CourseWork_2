package com.example.coursework_2.service;

import com.example.coursework_2.exceptions.BadRequest;
import com.example.coursework_2.Question;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{
   public final QuestionService questionService;

    ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection <Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size() || amount < 0) {
            throw new BadRequest();
        }
        Set<Question> que = new HashSet<>();
        while (amount > que.size()) {
            que.add(questionService.getRandomQuestion());
        }
        return que;
    }
}

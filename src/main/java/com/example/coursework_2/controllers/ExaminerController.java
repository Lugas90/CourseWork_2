package com.example.coursework_2.controllers;

import com.example.coursework_2.service.ExaminerService;
import com.example.coursework_2.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/get")
public class ExaminerController {

    public final ExaminerService examinerService;

    ExaminerController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/amount")
    public Collection<Question> getQuestions(int amount) {
       return examinerService.getQuestions(amount);
    }
}

package com.example.coursework_2.controllers;

import com.example.coursework_2.Question;
import com.example.coursework_2.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class QuestionController {

    public final QuestionService questionService;

    QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/java/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/java")
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }

    @GetMapping("/java/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        return questionService.remove(new Question(question, answer));
    }
}

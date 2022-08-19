package com.example.coursework_2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class QuestionController {

    private  final QuestionService questionService;

    QuestionController (QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/java/add")
    Question addQuestion(@RequestParam("question") String question,
                         @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/java")
    Collection <Question> getQuestions () {
        return questionService.getAll();
    }

    @GetMapping("/java/remove")
    Question removeQuestion (@RequestParam("question") String question,
                             @RequestParam("answer") String answer) {
        Question que = new Question(question, answer);
        return questionService.remove(que);
    }

}

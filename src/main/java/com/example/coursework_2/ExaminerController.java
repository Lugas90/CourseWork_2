package com.example.coursework_2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/exam/get")
public class ExaminerController {

    private final ExaminerServiceImpl examinerServiceImpl;

    ExaminerController(ExaminerServiceImpl examinerServiceImpl) {
        this.examinerServiceImpl = examinerServiceImpl;
    }

    @GetMapping("/amount")
    public Collection<Question> getQuestions(int amount) {
        Set<Question> que = new HashSet<>();
        examinerServiceImpl.getQuestions(amount);
        return que;
    }
}

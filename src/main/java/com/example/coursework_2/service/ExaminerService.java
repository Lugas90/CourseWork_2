package com.example.coursework_2.service;

import com.example.coursework_2.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}

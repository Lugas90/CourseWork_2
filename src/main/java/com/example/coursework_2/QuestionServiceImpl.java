package com.example.coursework_2;

import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class QuestionServiceImpl implements QuestionService {

    Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question que = new Question(question, answer);
        questions.add(que);
        return que;
    }

    @Override
    public Question add(Question question) {
        Question que = new Question(question.getQuestion(), question.getAnswer());
        questions.add(que);
        return que;
    }

    @Override
    public Question remove(Question question) {
        Question que = new Question(question.getQuestion(), question.getAnswer());
        questions.remove(que);
        return que;
    }

    @Override
    public Question find(Question question) {
        return new Question(question.getQuestion(), question.getAnswer());
    }


    @Override
    public Collection<Question> getAll() {
        Collection collection = new HashSet();
        collection.addAll(Arrays.asList(questions.toArray()));
        return collection;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> result = new ArrayList<>();
        result.addAll(questions);
        Question randomElement = result.get(random.nextInt(result.size()));
        return randomElement;
    }
}

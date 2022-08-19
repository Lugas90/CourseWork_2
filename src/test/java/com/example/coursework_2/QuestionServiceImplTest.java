package com.example.coursework_2;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static com.example.coursework_2.Constants.*;
import static org.assertj.core.api.Assertions.*;

public class QuestionServiceImplTest {

    QuestionServiceImpl out = new QuestionServiceImpl();


    @Test
    public void shouldReturnAddQuestion() {
        Question expected = new Question(QUE1, ANS1);
        Question actual = out.add(QUE1, ANS1);
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void shouldReturnRemoveQuestion(){
        Question que1 = new Question(QUE1, ANS1);
        Question que2 = new Question(QUE2, ANS2);
        Question que3 = new Question(QUE3, ANS3);
        out.add(que1);
        out.add(que2);
        out.add(que3);
        Set <Question> expected  = new HashSet<>(Set.of(que1, que2));
        out.remove(que3);
        assertThat(out.getAll()).isEqualTo(expected);
    }

    @Test
    public void shouldReturnFindQuestion() {
        Question que1 = new Question(QUE1, ANS1);
        Question que2 = new Question(QUE2, ANS2);
        Question que3 = new Question(QUE3, ANS3);
        out.add(que1);
        out.add(que2);
        out.add(que3);
        Question expected = new Question(QUE2, ANS2);
        Question actual = out.find(que2);
        assertThat(actual).isEqualTo(expected);
    }
}

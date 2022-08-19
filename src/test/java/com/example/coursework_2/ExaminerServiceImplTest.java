package com.example.coursework_2;

import com.example.coursework_2.Exceptions.Bad_Request;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.example.coursework_2.Constants.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {


    Question que1 = new Question(QUE1, ANS1);
    Question que2 = new Question(QUE2, ANS2);
    Question que3 = new Question(QUE3, ANS3);
    Question que4 = new Question(QUE4, ANS4);
    Question que5 = new Question(QUE5, ANS5);

    @Mock
    QuestionServiceImpl questionServiceimpl;

    @InjectMocks
    ExaminerServiceImpl examinerServiceimpl;

    @Test
    public void shouldReturnRandomQuestions() {
        Mockito.when(questionServiceimpl.getRandomQuestion()).thenReturn(que1, que2, que3, que4, que5);
        Set<Question> expected = new HashSet<>(Arrays.asList(
                new Question(QUE1, ANS1),
                new Question(QUE2, ANS2),
                new Question(QUE3, ANS3),
                new Question(QUE4, ANS4),
                new Question(QUE5, ANS5)));
        assertThat(examinerServiceimpl.getQuestions(5)).isEqualTo(expected);
    }

    @Test
    public void shouldReturnBadRequestException() {
        Mockito.when(questionServiceimpl.getRandomQuestion()).thenReturn(que1, que2, que3, que4, que5);
        assertThrows(Bad_Request.class, () -> examinerServiceimpl.getQuestions(7));
    }
}


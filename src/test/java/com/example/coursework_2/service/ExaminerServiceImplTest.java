package com.example.coursework_2.service;

import com.example.coursework_2.Question;
import com.example.coursework_2.exceptions.BadRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

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
    private QuestionServiceImpl questionServiceimpl;

    @InjectMocks
    private ExaminerServiceImpl examinerServiceimpl;

    @Test
    public void shouldReturnGetQuestions() {
        Set<Question> expected = new HashSet<>(Arrays.asList(
                new Question(QUE1, ANS1),
                new Question(QUE2, ANS2),
                new Question(QUE3, ANS3),
                new Question(QUE4, ANS4),
                new Question(QUE5, ANS5)));
        Mockito.when(questionServiceimpl.getRandomQuestion()).thenReturn(que5, que1, que3, que2, que4);
        Mockito.when(questionServiceimpl.getAll()).thenReturn(expected);
        assertThat(examinerServiceimpl.getQuestions(3)).containsExactlyInAnyOrder(que5,que1,que3);
    }

    @Test
    public void shouldReturnBadRequestException() {
        Mockito.when(questionServiceimpl.getAll()).thenReturn(Collections.emptyList());
        assertThrows(BadRequest.class, () -> examinerServiceimpl.getQuestions(7));
    }
}


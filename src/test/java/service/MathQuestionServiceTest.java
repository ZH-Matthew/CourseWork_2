package service;

import exception.QuestionNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.MathQuestionRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static service.Constants.*;
import static service.Constants.Q1;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @Mock
    private MathQuestionRepository repository;

    @InjectMocks
    private MathQuestionService service;


    @Test
    void add() {
        when(repository.add(S1_1, S1_2))
                .thenReturn(Q1);
        assertEquals(Q1, service.add(S1_1, S1_2));
    }

    @Test
    void add2() {
        when(repository.add(Q2))
                .thenReturn(Q2);
        assertEquals(Q2, service.add(Q2));
    }

    @Test
    void removeException() {
        when(repository.remove(S1_1, S1_2))
                .thenThrow(QuestionNotFoundException.class);
        assertThrows(QuestionNotFoundException.class, () -> service.remove(S1_1, S1_2));
    }

    @Test
    void remove() {
        when(repository.remove(S1_1, S1_2))
                .thenReturn(Q1);
        assertEquals(Q1, service.remove(S1_1, S1_2));
    }

    @Test
    void getAll() {
        when(repository.getAll())
                .thenReturn(QUEST_LIST2);
        assertEquals(QUEST_LIST2, service.getAll());
    }

    @Test
    void getRandom() {
        when(repository.getRandomQuestion())
                .thenReturn(Q1);
        assertEquals(Q1, service.getRandomQuestion());
    }

}
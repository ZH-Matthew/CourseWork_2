package service;

import exception.RequestedQuantityMoreAvailableException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static service.Constants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionServiceImpl repository;

    @InjectMocks
    private ExaminerServiceImpl out;


    @Test
    void getQuestionsTest() {
        when(repository.getAll())
                .thenReturn(QUEST_LIST);
        when(repository.getRandomQuestion())
                .thenReturn(Q1).thenReturn(Q2);
        assertEquals(QUEST_LIST, out.getQuestions(2));
    }

    @Test
    void qetQuestionsTestException(){
        when(repository.getAll())
                .thenReturn(QUEST_LIST);
        assertThrows(RequestedQuantityMoreAvailableException.class, ()-> out.getQuestions(10));
    }
}
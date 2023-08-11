package serviceExam;

import exception.RequestedQuantityMoreAvailableException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.MathQuestionService;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static service.Constants.*;

@ExtendWith(MockitoExtension.class)
class MathExaminerServiceTest {
    @Mock
    private MathQuestionService repository;

    @InjectMocks
    private MathExaminerService out;


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
                .thenReturn(QUEST_LIST2);
        assertThrows(RequestedQuantityMoreAvailableException.class, ()-> out.getQuestions(10));
    }
}
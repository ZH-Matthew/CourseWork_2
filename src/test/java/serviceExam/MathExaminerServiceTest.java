package serviceExam;

import cw_2.exception.RequestedQuantityMoreAvailableException;
import cw_2.serviceExam.ExaminerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import cw_2.service.MathQuestionService;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static service.Constants.*;

@ExtendWith(MockitoExtension.class)
class MathExaminerServiceTest {
    @Mock
    private MathQuestionService repository;

    @InjectMocks
    private ExaminerServiceImpl out;


    @Test
    void getQuestionsTest() {
        when(repository.getAll())
                .thenReturn(QUEST_LIST);
        when(repository.getRandomQuestion())
                .thenReturn(Q1).thenReturn(Q2);
        assertEquals(QUEST_LIST, out.getQuestions(2,1));
    }

    @Test
    void qetQuestionsTestException(){
        when(repository.getAll())
                .thenReturn(QUEST_LIST2);
        assertThrows(RequestedQuantityMoreAvailableException.class, ()-> out.getQuestions(10,1));
    }
}
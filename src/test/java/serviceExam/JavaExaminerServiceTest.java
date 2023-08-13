package serviceExam;

import cw_2.service.JavaQuestionService;
import cw_2.serviceExam.ExaminerServiceImpl;
import cw_2.exception.RequestedQuantityMoreAvailableException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static service.Constants.*;

@ExtendWith(MockitoExtension.class)
class JavaExaminerServiceTest {
    @Mock
    private JavaQuestionService repository;

    @InjectMocks
    private ExaminerServiceImpl out;


    @Test
    void getQuestionsTest() {
        when(repository.getAll())
                .thenReturn(QUEST_LIST);
        when(repository.getRandomQuestion())
                .thenReturn(Q1).thenReturn(Q2);
        assertEquals(QUEST_LIST, out.getQuestions(2,0));
    }

    @Test
    void qetQuestionsTestException(){
        when(repository.getAll())
                .thenReturn(QUEST_LIST2);
        assertThrows(RequestedQuantityMoreAvailableException.class, ()-> out.getQuestions(10,0));
    }
}
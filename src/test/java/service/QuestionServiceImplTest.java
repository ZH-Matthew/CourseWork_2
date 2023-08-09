package service;

import cw_2.Question;
import exception.QuestionNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static service.Constants.*;

class QuestionServiceImplTest {

    QuestionService service = new QuestionService() {
        @Override
        public Question add(String question, String answer) {
            return null;
        }

        @Override
        public Question add(Question question) {
            return null;
        }

        @Override
        public Question remove(String question, String answer) {
            return null;
        }

        @Override
        public Collection<Question> getAll() {
            return null;
        }

        @Override
        public Question getRandomQuestion() {
            return null;
        }
    };

    @Test
    void add() {
        assertEquals(Q1, service.add(S1_1, S1_2));
    }

    @Test
    void add2() {
        assertEquals(Q1, service.add(Q1));
    }

    @Test
    void removeException() {
        assertThrows(QuestionNotFoundException.class, () -> service.remove(S1_1, S1_2));
    }

    @Test
    void remove() {
        service.add(Q1);
        assertEquals(Q1, service.remove(S1_1, S1_2));
    }

    @Test
    void getAll() {
        service.add(Q1);
        service.add(Q2);
        service.add(Q3);
        service.add(Q4);
        service.add(Q5);
        assertEquals(QUEST_LIST2, service.getAll());
    }

    @Test
    void getRandom() {
        service.add(Q1);
        assertEquals(Q1, service.getRandomQuestion());
    }
}
package repository;

import exception.QuestionNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static service.Constants.*;
import static service.Constants.Q1;

class JavaQuestionRepositoryTest {
    QuestionRepository data = new JavaQuestionRepository();

    @Test
    void add1() {
        assertEquals(data.add(S1_1, S1_2), Q1);
    }

    @Test
    void add2() {
        assertEquals(Q1, data.add(Q1));
    }

    @Test
    void remove() {
        data.add(Q1);
        assertEquals(Q1, data.remove(S1_1, S1_2));
    }

    @Test
    void removeException() {
        assertThrows(QuestionNotFoundException.class, () -> data.remove(S1_1, S1_2));
    }

    @Test
    void getAll() {
        data.add(Q1);
        data.add(Q2);
        assertEquals(QUEST_LIST, data.getAll());
    }

    @Test
    void getRandomQuestion() {
        data.add(Q1);
        assertEquals(Q1, data.getRandomQuestion());
    }

}
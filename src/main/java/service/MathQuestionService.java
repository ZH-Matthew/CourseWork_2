package service;

import cw_2.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import repository.MathQuestionRepository;
import repository.QuestionRepository;

import java.util.*;
@Service
@Qualifier("MathQuestionRepository")
public class MathQuestionService implements QuestionService{

    private final QuestionRepository data;

    public MathQuestionService(QuestionRepository data) {
        this.data = data;
    }

    @Override
    public Question add(String question, String answer) {
        return data.add(question,answer);
    }

    @Override
    public Question add(Question question) {
        return data.add(question);
    }

    @Override
    public Question remove(String question, String answer) {
        return data.remove(question,answer);
    }

    @Override
    public Collection<Question> getAll() {
        return data.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return data.getRandomQuestion();
    }
}

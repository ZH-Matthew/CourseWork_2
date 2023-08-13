package cw_2.service;

import cw_2.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import cw_2.repository.QuestionRepository;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{

    private final QuestionRepository repository;

    public JavaQuestionService(@Qualifier("javaQuestionRepository")QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return repository.add(question,answer);
    }

    @Override
    public Question add(Question question) {
        return repository.add(question);
    }

    @Override
    public Question remove(String question, String answer) {
        return repository.remove(question,answer);
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return repository.getRandomQuestion();
    }
}

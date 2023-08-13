package cw_2.service;

import cw_2.Question;
import cw_2.exception.BlockException;
import org.springframework.stereotype.Service;
import cw_2.repository.QuestionRepository;
import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    private final QuestionRepository data;

    public MathQuestionService(QuestionRepository data) {
        this.data = data;
    }

    @Override
    public Question add(String question, String answer) {
        throw new BlockException();
    }

    @Override
    public Question add(Question question) {
        throw new BlockException();
    }

    @Override
    public Question remove(String question, String answer) {
        throw new BlockException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new BlockException();
    }

    @Override
    public Question getRandomQuestion() {
        int leftLimit = 97; // буква 'a'
        int rightLimit = 122; // буква 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String quest = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String answer = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return new Question(quest,answer);
    }
}

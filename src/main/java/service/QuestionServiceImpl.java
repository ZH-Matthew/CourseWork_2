package service;

import cw_2.Question;
import exception.QuestionNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService{
    List<Question> questions = new ArrayList<>();

    final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question,answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question newQuestion = new Question(question,answer);
        if (questions.contains(newQuestion)) {
            questions.remove(newQuestion);
            return newQuestion;
        } else {
            throw new QuestionNotFoundException();
        }
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableList(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return questions.get(random.nextInt(questions.size()));
    }
}

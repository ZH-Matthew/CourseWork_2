package repository;
import cw_2.Question;
import exception.QuestionNotFoundException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
@Repository
public class JavaQuestionRepository implements QuestionRepository {
    List<Question> questions = new ArrayList<>();

    final Random random = new Random();

    @PostConstruct
    void init(){
        Question q1 = new Question("Как пользоваться этим спрингом?", "На этот вопрос ответит Александр Друзь");
        Question q2 = new Question("Куда ставить эту чертову аннотацию Qualifier?", "На этот вопрос ответит Александр Друзь");
        Question q3 = new Question("Как не сойти с ума при написании юнит тестов?", "На этот вопрос ответит Александр Друзь");
        Question q4 = new Question("Как держать себя в руках когда 2 строчки пишутся один час?", "На этот вопрос ответит Александр Друзь");
        Question q5 = new Question("Как, Карл? Как?", "На этот вопрос ответит Александр Друзь");
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
        questions.add(q5);
    }

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

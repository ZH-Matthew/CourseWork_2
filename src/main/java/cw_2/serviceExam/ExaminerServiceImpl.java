package cw_2.serviceExam;
import cw_2.Question;
import cw_2.exception.RequestedQuantityMoreAvailableException;
import cw_2.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> questionServices = new ArrayList<>();

    public ExaminerServiceImpl(
            @Qualifier("javaQuestionService") QuestionService javaQuestionService,
            @Qualifier("mathQuestionService") QuestionService mathQuestionService
    ) {
        questionServices.add(javaQuestionService);
        questionServices.add(mathQuestionService);
    }

    @Override
    public Collection<Question> getQuestions(int amount, int numberService) {

        int sizeList = questionServices.get(numberService).getAll().size();
        if (amount > sizeList) {
            throw new RequestedQuantityMoreAvailableException();
        }
        List<Question> questions = new ArrayList<>();
        while (questions.size() != amount) {
            Question newQuestion = questionServices.get(numberService).getRandomQuestion();
            if (questions.contains(newQuestion)) {
                continue;
            } else {
                questions.add(newQuestion);
            }
        }
        return questions;
    }
}


package serviceExam;

import cw_2.Question;
import exception.RequestedQuantityMoreAvailableException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.QuestionService;
import serviceExam.ExaminerService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class MathExaminerServiceImpl implements ExaminerService {
    private final QuestionService data;

    public MathExaminerServiceImpl(@Qualifier("mathQuestionService") QuestionService data) {
        this.data = data;
    }
    @Override
    public Collection<Question> getQuestions(int amount) {
        int sizeList = data.getAll().size();
        if (amount>sizeList) {
            throw new RequestedQuantityMoreAvailableException();
        }
        List<Question> questions = new ArrayList<>();
        while(questions.size()!=amount){
            Question newQuestion = data.getRandomQuestion();
            if (questions.contains(newQuestion)){
                continue;
            } else {
                questions.add(newQuestion);
            }
        }
        return questions;
    }
}

package service;

import cw_2.Question;
import exception.RequestedQuantityMoreAvailableException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
@Qualifier("MathQuestionService")
public class MathExaminerServiceImpl implements ExaminerService{
    private final QuestionService data;

    public MathExaminerServiceImpl(QuestionService data) {
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

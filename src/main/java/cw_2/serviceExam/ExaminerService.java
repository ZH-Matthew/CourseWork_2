package cw_2.serviceExam;

import cw_2.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount, int service);
}
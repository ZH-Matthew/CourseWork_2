package cw_2.controllerExam;

import cw_2.Question;
import cw_2.serviceExam.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/get")
public class ExamController {
    private final ExaminerServiceImpl service;

    public ExamController(ExaminerServiceImpl service) {
        this.service = service;
    }


    @GetMapping("/java/{id}")
    public Collection<Question> getQuestions(@PathVariable int id) {
        int ser = 0;
        return service.getQuestions(id, ser);
    }

    @GetMapping("/math/{id}")
    public Collection<Question> getQuestions2(@PathVariable int id) {
        int ser = 1;
        return service.getQuestions(id, ser);
    }
}

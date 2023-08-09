package controller;

import cw_2.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
@Qualifier("MathQuestionService")
public class MathQuestionController {

    private final QuestionService service;

    public MathQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<Question> getAllQuestions() {
        return service.getAll();
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.remove(question, answer);
    }
}

package controllerExam;

import cw_2.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import serviceExam.ExaminerService;
import java.util.Collection;

@RestController
@RequestMapping("/exam/get/java")
public class JavaExamController {

    private final ExaminerService service;

    public JavaExamController(@Qualifier("javaExaminerServiceImpl") ExaminerService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Collection<Question> getQuestions(@PathVariable int id){
        return service.getQuestions(id);
    }

}

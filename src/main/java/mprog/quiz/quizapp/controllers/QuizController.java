package mprog.quiz.quizapp.controllers;

import lombok.extern.slf4j.Slf4j;
import mprog.quiz.quizapp.domain.Quiz;
import mprog.quiz.quizapp.exceptions.QuizNotFoundException;
import mprog.quiz.quizapp.repositories.QuizRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class QuizController {

    private final QuizRepository quizRepository;

    public QuizController(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @GetMapping("quizzes")
    public List<Quiz> getQuizzes(){
        log.debug("Get all quizzes");
        return quizRepository.findAll();
    }

    @GetMapping("quizzes/{id}")
    public Quiz getQuizById(@PathVariable UUID id) throws QuizNotFoundException {
        log.debug("Get quiz by id");

         return quizRepository.findById(id)
                 .orElseThrow(() -> new QuizNotFoundException(id));
    }

    @PostMapping("quizzes")
    public Quiz newQuiz(@RequestBody Quiz newQuiz) {
        log.debug("Post quiz");
        return quizRepository.save(newQuiz);
    }
}

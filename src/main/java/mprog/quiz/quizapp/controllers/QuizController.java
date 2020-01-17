package mprog.quiz.quizapp.controllers;

import lombok.extern.slf4j.Slf4j;
import mprog.quiz.quizapp.domain.Quiz;
import mprog.quiz.quizapp.exceptions.QuizNotFoundException;
import mprog.quiz.quizapp.repositories.QuizRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Quiz>> getQuizzes(){
        log.debug("Get all quizzes");
        return new ResponseEntity<>(quizRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("quizzes/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable UUID id) throws QuizNotFoundException {
        log.debug("Get quiz by id");

         return new ResponseEntity<>(quizRepository.findById(id)
                 .orElseThrow(() -> new QuizNotFoundException(id)), HttpStatus.OK
         );
    }

    @PostMapping("quizzes")
    public ResponseEntity<Quiz> newQuiz(@RequestBody Quiz newQuiz) {
        log.debug("Post quiz");
        return new ResponseEntity<>(quizRepository.save(newQuiz), HttpStatus.OK);
    }
}

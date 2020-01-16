package mprog.quiz.quizapp.controllers;

import lombok.extern.slf4j.Slf4j;
import mprog.quiz.quizapp.exceptions.QuizNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class QuizNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(QuizNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String quizNotFoundHandler(QuizNotFoundException e){
        log.debug("QuizNotFoundException " + e.getMessage());
        return e.getMessage();
    }
}

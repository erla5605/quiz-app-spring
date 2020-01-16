package mprog.quiz.quizapp.exceptions;

import java.util.UUID;

public class QuizNotFoundException extends Exception {

    public QuizNotFoundException(UUID id) {
        super("Could not find Quiz with id: " +  id);
    }
}

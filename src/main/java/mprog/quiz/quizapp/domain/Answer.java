package mprog.quiz.quizapp.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Answer {

    @Id @GeneratedValue
    private UUID id;
    private String answerText;
    private boolean isCorrectAnswer;
}

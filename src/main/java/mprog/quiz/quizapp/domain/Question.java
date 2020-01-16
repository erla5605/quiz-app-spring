package mprog.quiz.quizapp.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue
    private UUID id;
    private String questionText;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();
    private QuestionType type;
    private String video;

}

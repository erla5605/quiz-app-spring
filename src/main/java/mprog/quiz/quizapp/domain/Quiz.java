package mprog.quiz.quizapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Quiz {

    @Id @GeneratedValue
    private UUID id;
    private String name;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Question> questions;


}

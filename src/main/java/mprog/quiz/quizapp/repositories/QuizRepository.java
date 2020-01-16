package mprog.quiz.quizapp.repositories;

import mprog.quiz.quizapp.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuizRepository extends JpaRepository<Quiz, UUID> {
}

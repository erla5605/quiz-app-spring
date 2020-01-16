package mprog.quiz.quizapp.bootstrap;

import mprog.quiz.quizapp.domain.Answer;
import mprog.quiz.quizapp.domain.Question;
import mprog.quiz.quizapp.domain.QuestionType;
import mprog.quiz.quizapp.domain.Quiz;
import mprog.quiz.quizapp.repositories.QuizRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final QuizRepository quizRepository;

    public Bootstrap(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Quiz quiz = new Quiz();
        quiz.setName("Quiz");
        quiz.setDescription("Quiz");
        quiz.setQuestions(getQuestions());

        Quiz quiz1 = new Quiz();
        quiz1.setName("Quiz1");
        quiz1.setDescription("Quiz1");
        quiz1.setQuestions(getQuestions());

        quizRepository.save(quiz);
        quizRepository.save(quiz1);
    }

    private List<Question> getQuestions(){
        Question question1 = new Question();
        question1.setQuestionText("Q1");
        question1.setType(QuestionType.TEXT);
        question1.setAnswers(getAnswers());

        Question question2 = new Question();
        question2.setQuestionText("Q2");
        question2.setType(QuestionType.TEXT);
        question2.setAnswers(getAnswers());

        List<Question> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);

        return questions;
    }

    private List<Answer> getAnswers() {
        Answer answer1 = new Answer();
        answer1.setAnswerText("a1");
        answer1.setCorrectAnswer(true);

        Answer answer2 = new Answer();
        answer2.setAnswerText("a2");
        answer2.setCorrectAnswer(false);

        List<Answer> answers = new ArrayList<>();
        answers.add(answer1);
        answers.add(answer2);

        return answers;
    }
}

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
        quiz.setName("Countries");
        quiz.setDescription("This is a quiz about the countries of the world.");
        quiz.setQuestions(getQuestions());

        quizRepository.save(quiz);
    }

    private List<Question> getQuestions(){
        Question question1 = new Question();
        question1.setQuestionText("What is the largest country in the world?");
        question1.setType(QuestionType.TEXT);
        question1.setAnswers(getFirstAnswers());

        Question question2 = new Question();
        question2.setQuestionText("The video shows the national anthem of the USA, what country borders the USA to the north?");
        question2.setType(QuestionType.VIDEO);
        question2.setAnswers(getSecondAnswers());
        question2.setVideo("https://www.youtube.com/watch?v=M1wLtAXDgqg");

        Question question3 = new Question();
        question3.setQuestionText("How many people live in Germany?");
        question3.setType(QuestionType.TEXT);
        question3.setAnswers(getThirdAnswers());

        List<Question> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);

        return questions;
    }

    private List<Answer> getFirstAnswers() {
        Answer russia = new Answer();
        russia.setAnswerText("Russia");
        russia.setCorrectAnswer(true);

        Answer canada = new Answer();
        canada.setAnswerText("Canada");
        canada.setCorrectAnswer(false);

        Answer china = new Answer();
        china.setAnswerText("China");
        china.setCorrectAnswer(false);

        List<Answer> answers = new ArrayList<>();
        answers.add(russia);
        answers.add(canada);
        answers.add(china);

        return answers;
    }

    private List<Answer> getSecondAnswers() {

        Answer mexico = new Answer();
        mexico.setAnswerText("Mexico");
        mexico.setCorrectAnswer(false);

        Answer canada = new Answer();
        canada.setAnswerText("Canada");
        canada.setCorrectAnswer(true);

        Answer iceland = new Answer();
        iceland.setAnswerText("Iceland");
        iceland.setCorrectAnswer(false);

        List<Answer> answers = new ArrayList<>();
        answers.add(mexico);
        answers.add(canada);
        answers.add(iceland);

        return answers;
    }

    private List<Answer> getThirdAnswers() {
        Answer eightyTwo = new Answer();
        eightyTwo.setAnswerText("82 million");
        eightyTwo.setCorrectAnswer(true);

        Answer seventyNine = new Answer();
        seventyNine.setAnswerText("79 million");
        seventyNine.setCorrectAnswer(false);

        Answer eightyFive = new Answer();
        eightyFive.setAnswerText("85 million");
        eightyFive.setCorrectAnswer(false);

        List<Answer> answers = new ArrayList<>();
        answers.add(eightyTwo);
        answers.add(seventyNine);
        answers.add(eightyFive);

        return answers;
    }
}

package mprog.quiz.quizapp.controllers;

import mprog.quiz.quizapp.domain.Quiz;
import mprog.quiz.quizapp.repositories.QuizRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class QuizControllerTest {

    public static final String URL = "/quizzes";
    public static final String ID = "61932695-9a41-4a2b-afe9-f97bb240be93";
    public static final String NAME = "Name";
    public static final String DESCRIPTION = "Description";
    @Mock
    QuizRepository quizRepository;

    @InjectMocks
    QuizController quizController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(quizController).build();

    }

    @Test
    void getQuizzes() throws Exception {
        List<Quiz> quizList = Arrays.asList(new Quiz(), new Quiz());

        when(quizRepository.findAll()).thenReturn(quizList);

        mockMvc.perform(get(URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void getQuizById() throws Exception {
        Quiz quiz = new Quiz();
        quiz.setId(UUID.fromString(ID));
        quiz.setName(NAME);
        quiz.setDescription(DESCRIPTION);
        quiz.setQuestions(new ArrayList<>());

        Optional<Quiz> quizOptional = Optional.of(quiz);

        when(quizRepository.findById(any())).thenReturn(quizOptional);

        mockMvc.perform(get(URL + "/" + ID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(ID)))
                .andExpect(jsonPath("$.name", equalTo(NAME)))
                .andExpect(jsonPath("$.description", equalTo(DESCRIPTION)))
                .andExpect(jsonPath("$.questions", hasSize(0)));
    }
}
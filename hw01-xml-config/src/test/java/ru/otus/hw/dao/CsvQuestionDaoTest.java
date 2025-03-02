package ru.otus.hw.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.hw.config.TestFileNameProvider;
import ru.otus.hw.domain.Answer;
import ru.otus.hw.domain.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CsvQuestionDaoTest {

    private TestFileNameProvider fileNameProvider;
    private CsvQuestionDao csvQuestionDao;

    @BeforeEach
    void setUp() {
        fileNameProvider = Mockito.mock(TestFileNameProvider.class);
        csvQuestionDao = new CsvQuestionDao(fileNameProvider);
    }

    @Test
    void findAll_shouldReturnCorrectListOfQuestions() {
        String testFileName = "src/main/resources/questions.csv";
        when(fileNameProvider.getTestFileName()).thenReturn(testFileName);

        List<Question> questions = csvQuestionDao.findAll();

        assertNotNull(questions);
        assertEquals(3, questions.size());

        Question firstQuestion = questions.get(0);
        assertEquals("Is there life on Mars?", firstQuestion.text());
        assertEquals(3, firstQuestion.answers().size());

        Answer firstAnswer = firstQuestion.answers().get(0);
        assertEquals("Science doesn't know this yet", firstAnswer.text());
        assertTrue(firstAnswer.isCorrect());

        Answer secondAnswer = firstQuestion.answers().get(1);
        assertEquals("Certainly. The red UFO is from Mars. And green is from Venus", secondAnswer.text());
        assertFalse(secondAnswer.isCorrect());

        Question secondQuestion = questions.get(1);
        assertEquals("How should resources be loaded form jar in Java?", secondQuestion.text());
        assertEquals(3, secondQuestion.answers().size());

        Answer thirdAnswer = secondQuestion.answers().get(0);
        assertEquals("ClassLoader#geResourceAsStream or ClassPathResource#getInputStream", thirdAnswer.text());
        assertTrue(thirdAnswer.isCorrect());

        Answer fourthAnswer = secondQuestion.answers().get(1);
        assertEquals("ClassLoader#geResource#getFile + FileReader", fourthAnswer.text());
        assertFalse(fourthAnswer.isCorrect());

    }

    @Test
    void findAll_shouldThrowExceptionWhenFileDoesNotExist() {
        String nonExistentFileName = "non-exists-file.csv";
        when(fileNameProvider.getTestFileName()).thenReturn(nonExistentFileName);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            csvQuestionDao.findAll();
        });

        String expectedMessage = "Ошибка при чтении файла";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}

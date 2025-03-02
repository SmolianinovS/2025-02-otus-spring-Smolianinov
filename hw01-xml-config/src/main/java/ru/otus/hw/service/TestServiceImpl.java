package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import ru.otus.hw.dao.CsvQuestionDao;
import ru.otus.hw.domain.Answer;
import ru.otus.hw.domain.Question;
import java.util.List;

@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final IOService ioService;
    private final CsvQuestionDao csvQuestionDao;

    @Override
    public void executeTest() {
        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below%n");
        // Получить вопросы из дао и вывести их с вариантами ответов

        List<Question> questions = csvQuestionDao.findAll();

        for (Question question : questions) {
            ioService.printFormattedLine(question.text());
            for (Answer answer : question.answers()) {
                ioService.printFormattedLine(question.answers().indexOf(answer) + 1 + "." + answer.text());
            }
            ioService.printFormattedLine("");
        }

    }
}

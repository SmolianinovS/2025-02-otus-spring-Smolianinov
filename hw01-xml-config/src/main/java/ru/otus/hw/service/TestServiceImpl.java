package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.hw.dao.CsvQuestionDao;
import ru.otus.hw.dao.QuestionDao;
import ru.otus.hw.domain.Question;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final IOService ioService;

    @Override
    public void executeTest() {
        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below%n");
        // Получить вопросы из дао и вывести их с вариантами ответов

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        var csvQuestionDao = context.getBean(CsvQuestionDao.class);


        List<Question> questions = csvQuestionDao.findAll();


        for (Question question : questions) {
            System.out.println(question.text());
        }


    }
}

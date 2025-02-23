package ru.otus.hw.dao;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import lombok.RequiredArgsConstructor;
import ru.otus.hw.config.TestFileNameProvider;
import ru.otus.hw.dao.dto.QuestionDto;
import ru.otus.hw.domain.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CsvQuestionDao implements QuestionDao {
    private final TestFileNameProvider fileNameProvider;

    @Override
    public List<Question> findAll() {
        // Использовать CsvToBean
        // https://opencsv.sourceforge.net/#collection_based_bean_fields_one_to_many_mappings
        // Использовать QuestionReadException
        // Про ресурсы: https://mkyong.com/java/java-read-a-file-from-resources-folder/

        String fileName = fileNameProvider.getTestFileName();
        FileReader fileReader = null;
        List<Question> questions = List.of();

        try {
            fileReader = new FileReader(fileName);
            CsvToBean<QuestionDto> csvToBean = new CsvToBeanBuilder<QuestionDto>(fileReader)
                    .withSkipLines(1)
                    .withType(QuestionDto.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(';')
                    .build();

            List<QuestionDto> questionDtos = csvToBean.parse();

            questions = new ArrayList<>();
            for (QuestionDto dto : questionDtos) {
                questions.add(dto.toDomainObject());
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Ошибка при закрытии файла: " + e.getMessage());
        }

        return questions;
    }
}


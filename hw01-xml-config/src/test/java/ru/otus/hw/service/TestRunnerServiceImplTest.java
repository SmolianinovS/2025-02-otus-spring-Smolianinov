package ru.otus.hw.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class TestRunnerServiceImplTest {

    @Mock
    private TestService testService;

    @InjectMocks
    private TestRunnerServiceImpl testRunnerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void run_ShouldCallExecuteTest() {
        testRunnerService.run();
        verify(testService).executeTest();
    }
}
package com.epam.training.student_arkadii_ilinov;

import com.epam.tat.module4.Calculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public abstract class BaseCalculatorTest {
    protected Calculator calculator;
    protected final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    public void calculatorSetUp(TestInfo testInfo) {
        calculator = new Calculator();
        logger.info("Created a new Calculator for: {}", testInfo.getDisplayName());
    }

    @AfterEach
    public void calculatorCleanUp(TestInfo testInfo) {
        calculator = null;
        logger.info("Cleaned up a Calculator for: {}", testInfo.getDisplayName());
    }
}

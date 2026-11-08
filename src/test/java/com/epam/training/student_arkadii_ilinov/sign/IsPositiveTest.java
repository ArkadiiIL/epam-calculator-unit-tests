package com.epam.training.student_arkadii_ilinov.sign;

import com.epam.training.student_arkadii_ilinov.BaseCalculatorTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsPositiveTest extends BaseCalculatorTest {

    @ParameterizedTest(name = "isPositive({0}) = true")
    @ValueSource(longs = {1, 5, 1000000000000L, Long.MAX_VALUE})
    void shouldReturnTrueForPositiveNumber(long value) {
        assertTrue(calculator.isPositive(value));
    }

    @ParameterizedTest(name = "isPositive({0}) = false")
    @ValueSource(longs = {0, -1, -5, -1000000000000L, Long.MIN_VALUE})
    void shouldReturnFalseForNonPositiveNumber(long value) {
        assertFalse(calculator.isPositive(value));
    }
}

package com.epam.training.student_arkadii_ilinov.sign;

import com.epam.training.student_arkadii_ilinov.BaseCalculatorTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsNegativeTest extends BaseCalculatorTest {

    @ParameterizedTest(name = "isNegative({0}) = true")
    @ValueSource(longs = {-1, -5, -1000000000000L, Long.MIN_VALUE})
    void shouldReturnTrueForNegativeNumber(long value) {
        assertTrue(calculator.isNegative(value));
    }

    @ParameterizedTest(name = "isNegative({0}) = false")
    @ValueSource(longs = {0, 1, 5, 1000000000000L, Long.MAX_VALUE})
    void shouldReturnFalseForNonNegativeNumber(long value) {
        assertFalse(calculator.isNegative(value));
    }
}

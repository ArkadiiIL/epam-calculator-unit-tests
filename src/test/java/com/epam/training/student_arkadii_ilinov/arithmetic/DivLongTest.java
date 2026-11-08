package com.epam.training.student_arkadii_ilinov.arithmetic;

import com.epam.training.student_arkadii_ilinov.BaseCalculatorTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivLongTest extends BaseCalculatorTest {

    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "12, 4, 3",
            "-12, -4, 3",
            "12, -4, -3",
            "-12, 4, -3",
            "7, 2, 3",
            "-7, 2, -3",
            "0, 5, 0",
            "5, 1, 5",
            "5, 5, 1",
            "3000000000000, 1000000000000, 3"
    })
    void shouldReturnCorrectQuotient(long a, long b, long expected) {
        long result = calculator.div(a, b);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "{0} / 0 throws ArithmeticException")
    @ValueSource(longs = {1, -1, 0})
    void shouldThrowExceptionOnDivisionByZero(long a) {
        assertThrows(ArithmeticException.class, () -> calculator.div(a, 0L));
    }

    @Test
    void shouldThrowExceptionOnOverflow() {
        assertThrows(ArithmeticException.class, () -> calculator.div(Long.MIN_VALUE, -1L));
    }
}

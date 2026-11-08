package com.epam.training.student_arkadii_ilinov.arithmetic;

import com.epam.training.student_arkadii_ilinov.BaseCalculatorTest;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubLongTest extends BaseCalculatorTest {

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "5, 3, 2",
            "3, 5, -2",
            "-4, -6, 2",
            "-6, -4, -2",
            "10, -3, 13",
            "-10, 3, -13",
            "7, 7, 0",
            "8, 0, 8",
            "0, 8, -8",
            "3000000000000, 1000000000000, 2000000000000"
    })
    void shouldReturnCorrectDifference(long a, long b, long expected) {
        long result = calculator.sub(a, b);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "{0} - {1} overflows")
    @MethodSource("overflowCases")
    void shouldThrowExceptionOnOverflow(long a, long b) {
        assertThrows(ArithmeticException.class, () -> calculator.sub(a, b));
    }

    static Stream<Arguments> overflowCases() {
        return Stream.of(
                Arguments.of(Named.of("Long.MIN_VALUE", Long.MIN_VALUE), 1L),
                Arguments.of(Named.of("Long.MAX_VALUE", Long.MAX_VALUE), -1L)
        );
    }
}

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

public class MultLongTest extends BaseCalculatorTest {

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "3, 4, 12",
            "-3, -4, 12",
            "3, -4, -12",
            "-3, 4, -12",
            "0, 5, 0",
            "5, 0, 0",
            "1, 7, 7",
            "-1, 7, -7",
            "1000000, 1000000, 1000000000000"
    })
    void shouldReturnCorrectProduct(long a, long b, long expected) {
        long result = calculator.mult(a, b);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "{0} * {1} overflows")
    @MethodSource("overflowCases")
    void shouldThrowExceptionOnOverflow(long a, long b) {
        assertThrows(ArithmeticException.class, () -> calculator.mult(a, b));
    }

    static Stream<Arguments> overflowCases() {
        return Stream.of(
                Arguments.of(Named.of("Long.MAX_VALUE", Long.MAX_VALUE), 2L),
                Arguments.of(Named.of("Long.MIN_VALUE", Long.MIN_VALUE), -1L)
        );
    }
}

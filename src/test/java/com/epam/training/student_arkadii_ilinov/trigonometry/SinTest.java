package com.epam.training.student_arkadii_ilinov.trigonometry;

import com.epam.training.student_arkadii_ilinov.BaseCalculatorTest;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinTest extends BaseCalculatorTest {

    @ParameterizedTest(name = "sin({0}) = {1}")
    @MethodSource("angles")
    void shouldReturnCorrectSine(double angle, double expected) {
        double result = calculator.sin(angle);
        assertEquals(expected, result, DELTA);
    }

    static Stream<Arguments> angles() {
        return Stream.of(
                Arguments.of(Named.of("0", 0.0), 0.0),
                Arguments.of(Named.of("π/6", Math.PI / 6), 0.5),
                Arguments.of(Named.of("π/4", Math.PI / 4), Math.sqrt(2) / 2),
                Arguments.of(Named.of("π/2", Math.PI / 2), 1.0),
                Arguments.of(Named.of("π", Math.PI), 0.0),
                Arguments.of(Named.of("3π/2", 3 * Math.PI / 2), -1.0),
                Arguments.of(Named.of("-π/2", -Math.PI / 2), -1.0),
                Arguments.of(Named.of("2π", 2 * Math.PI), 0.0)
        );
    }

    @ParameterizedTest(name = "sin({0}) = {1}")
    @CsvSource({
            "NaN, NaN",
            "Infinity, NaN",
            "-Infinity, NaN"
    })
    void shouldHandleSpecialValues(double angle, double expected) {
        double result = calculator.sin(angle);
        assertEquals(expected, result, DELTA);
    }
}

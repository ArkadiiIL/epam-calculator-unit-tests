package com.epam.training.student_arkadii_ilinov.trigonometry;

import com.epam.training.student_arkadii_ilinov.BaseCalculatorTest;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TgTest extends BaseCalculatorTest {

    @ParameterizedTest(name = "tg({0}) = {1}")
    @MethodSource("angles")
    void shouldReturnCorrectTangent(double angle, double expected) {
        double result = calculator.tg(angle);
        assertEquals(expected, result, DELTA);
    }

    static Stream<Arguments> angles() {
        return Stream.of(
                Arguments.of(Named.of("0", 0.0), 0.0),
                Arguments.of(Named.of("π/6", Math.PI / 6), 1 / Math.sqrt(3)),
                Arguments.of(Named.of("π/4", Math.PI / 4), 1.0),
                Arguments.of(Named.of("π/3", Math.PI / 3), Math.sqrt(3)),
                Arguments.of(Named.of("-π/4", -Math.PI / 4), -1.0),
                Arguments.of(Named.of("3π/4", 3 * Math.PI / 4), -1.0),
                Arguments.of(Named.of("π", Math.PI), 0.0)
        );
    }

    @ParameterizedTest(name = "tg({0}) = {1}")
    @CsvSource({
            "NaN, NaN",
            "Infinity, NaN",
            "-Infinity, NaN"
    })
    void shouldHandleSpecialValues(double angle, double expected) {
        double result = calculator.tg(angle);
        assertEquals(expected, result, DELTA);
    }
}

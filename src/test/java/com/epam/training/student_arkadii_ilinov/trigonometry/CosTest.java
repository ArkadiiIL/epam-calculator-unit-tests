package com.epam.training.student_arkadii_ilinov.trigonometry;

import com.epam.training.student_arkadii_ilinov.BaseCalculatorTest;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosTest extends BaseCalculatorTest {

    @ParameterizedTest(name = "cos({0}) = {1}")
    @MethodSource("angles")
    void shouldReturnCorrectCosine(double angle, double expected) {
        double result = calculator.cos(angle);
        assertEquals(expected, result, DELTA);
    }

    static Stream<Arguments> angles() {
        return Stream.of(
                Arguments.of(Named.of("0", 0.0), 1.0),
                Arguments.of(Named.of("π/3", Math.PI / 3), 0.5),
                Arguments.of(Named.of("π/4", Math.PI / 4), Math.sqrt(2) / 2),
                Arguments.of(Named.of("π/2", Math.PI / 2), 0.0),
                Arguments.of(Named.of("π", Math.PI), -1.0),
                Arguments.of(Named.of("-π/3", -Math.PI / 3), 0.5),
                Arguments.of(Named.of("2π", 2 * Math.PI), 1.0)
        );
    }

    @ParameterizedTest(name = "cos({0}) = {1}")
    @CsvSource({
            "NaN, NaN",
            "Infinity, NaN",
            "-Infinity, NaN"
    })
    void shouldHandleSpecialValues(double angle, double expected) {
        double result = calculator.cos(angle);
        assertEquals(expected, result, DELTA);
    }
}

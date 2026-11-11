package com.epam.training.student_arkadii_ilinov.arithmetic;

import com.epam.training.student_arkadii_ilinov.BaseCalculatorTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqrtTest extends BaseCalculatorTest {

    @ParameterizedTest(name = "sqrt({0}) = {1}")
    @CsvSource({
            "4.0, 2.0",
            "9.0, 3.0",
            "1.0, 1.0",
            "0.0, 0.0",
            "2.25, 1.5",
            "0.25, 0.5",
            "2.0, 1.4142135623730951",
            "1.0E10, 1.0E5"
    })
    void shouldReturnCorrectRoot(double value, double expected) {
        double result = calculator.sqrt(value);
        assertEquals(expected, result, DELTA);
    }

    @ParameterizedTest(name = "sqrt({0}) = NaN")
    @ValueSource(doubles = {-1.0, -4.0, -0.25, Double.NEGATIVE_INFINITY})
    void shouldReturnNaNForNegativeNumber(double value) {
        double result = calculator.sqrt(value);
        assertEquals(Double.NaN, result);
    }

    @ParameterizedTest(name = "sqrt({0}) = {1}")
    @CsvSource({
            "Infinity, Infinity",
            "NaN, NaN"
    })
    void shouldHandleSpecialValues(double value, double expected) {
        double result = calculator.sqrt(value);
        assertEquals(expected, result, DELTA);
    }
}

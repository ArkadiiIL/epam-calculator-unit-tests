package com.epam.training.student_arkadii_ilinov.arithmetic;

import com.epam.training.student_arkadii_ilinov.BaseCalculatorTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultDoubleTest extends BaseCalculatorTest {

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "2.0, 3.0, 6.0",
            "-2.0, -3.5, 7.0",
            "-0.5, 4.0, -2.0",
            "0.0, 8.8, 0.0",
            "2.5, 2.5, 6.25",
            "-1.5, 1.5, -2.25",
            "0.5, 0.5, 0.25",
            "1.0, 3.75, 3.75",
            "0.1, 3.0, 0.3"
    })
    void shouldReturnCorrectProduct(double a, double b, double expected) {
        double result = calculator.mult(a, b);
        assertEquals(expected, result, DELTA);
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "Infinity, 2.0, Infinity",
            "Infinity, -2.0, -Infinity",
            "Infinity, 0.0, NaN",
            "NaN, 2.0, NaN",
            "1.7976931348623157E308, 2.0, Infinity"
    })
    void shouldHandleSpecialValues(double a, double b, double expected) {
        double result = calculator.mult(a, b);
        assertEquals(expected, result, DELTA);
    }
}

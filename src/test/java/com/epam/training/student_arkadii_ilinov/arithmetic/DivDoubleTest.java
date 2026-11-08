package com.epam.training.student_arkadii_ilinov.arithmetic;

import com.epam.training.student_arkadii_ilinov.BaseCalculatorTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivDoubleTest extends BaseCalculatorTest {

    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "7.5, 2.5, 3.0",
            "-7.5, -2.5, 3.0",
            "7.5, -2.5, -3.0",
            "-7.5, 2.5, -3.0",
            "7.0, 2.0, 3.5",
            "1.0, 4.0, 0.25",
            "1.0, 3.0, 0.3333333333",
            "0.3, 0.1, 3.0",
            "0.0, 5.5, 0.0"
    })
    void shouldReturnCorrectQuotient(double a, double b, double expected) {
        double result = calculator.div(a, b);
        assertEquals(expected, result, DELTA);
    }

    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "1.0, 0.0, Infinity",
            "-1.0, 0.0, -Infinity",
            "0.0, 0.0, NaN",
            "Infinity, 2.0, Infinity",
            "1.0, Infinity, 0.0",
            "Infinity, Infinity, NaN",
            "NaN, 2.0, NaN"
    })
    void shouldHandleSpecialValues(double a, double b, double expected) {
        double result = calculator.div(a, b);
        assertEquals(expected, result, DELTA);
    }
}

package com.epam.training.student_arkadii_ilinov.arithmetic;

import com.epam.training.student_arkadii_ilinov.BaseCalculatorTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumDoubleTest extends BaseCalculatorTest {

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "2.5, 3.5, 6.0",
            "-1.5, -2.25, -3.75",
            "10.75, -3.25, 7.5",
            "2.5, -10.0, -7.5",
            "4.2, -4.2, 0.0",
            "0.0, 8.8, 8.8",
            "0.1, 0.2, 0.3",
            "1234.5678, 8765.4321, 9999.9999"
    })
    void shouldReturnCorrectSum(double a, double b, double expected) {
        double result = calculator.sum(a, b);
        assertEquals(expected, result, DELTA);
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "Infinity, 1.0, Infinity",
            "-Infinity, -1.0, -Infinity",
            "Infinity, -Infinity, NaN",
            "NaN, 1.0, NaN",
            "1.7976931348623157E308, 1.7976931348623157E308, Infinity"
    })
    void shouldHandleSpecialValues(double a, double b, double expected) {
        double result = calculator.sum(a, b);
        assertEquals(expected, result, DELTA);
    }
}

package com.epam.training.student_arkadii_ilinov.arithmetic;

import com.epam.training.student_arkadii_ilinov.BaseCalculatorTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubDoubleTest extends BaseCalculatorTest {

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "5.5, 2.5, 3.0",
            "3.25, 10.75, -7.5",
            "-1.5, -2.25, 0.75",
            "2.5, -10.0, 12.5",
            "-2.5, 10.0, -12.5",
            "4.2, 4.2, 0.0",
            "8.8, 0.0, 8.8",
            "0.0, 8.8, -8.8",
            "0.3, 0.1, 0.2",
            "9999.9999, 1234.5678, 8765.4321"
    })
    void shouldReturnCorrectDifference(double a, double b, double expected) {
        double result = calculator.sub(a, b);
        assertEquals(expected, result, DELTA);
    }

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "Infinity, 1.0, Infinity",
            "-Infinity, 1.0, -Infinity",
            "1.0, Infinity, -Infinity",
            "Infinity, Infinity, NaN",
            "NaN, 1.0, NaN",
            "-1.7976931348623157E308, 1.7976931348623157E308, -Infinity"
    })
    void shouldHandleSpecialValues(double a, double b, double expected) {
        double result = calculator.sub(a, b);
        assertEquals(expected, result, DELTA);
    }
}

package com.epam.training.student_arkadii_ilinov.arithmetic;

import com.epam.training.student_arkadii_ilinov.BaseCalculatorTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowTest extends BaseCalculatorTest {

    @ParameterizedTest(name = "{0} ^ {1} = {2}")
    @CsvSource({
            "2.0, 3.0, 8.0",
            "5.0, 1.0, 5.0",
            "7.0, 0.0, 1.0",
            "-2.0, 3.0, -8.0",
            "-2.0, 2.0, 4.0",
            "2.0, -2.0, 0.25",
            "1.5, 2.0, 2.25",
            "0.0, 5.0, 0.0"
    })
    void shouldReturnCorrectPowerForIntegerExponent(double base, double exponent, double expected) {
        double result = calculator.pow(base, exponent);
        assertEquals(expected, result, DELTA);
    }

    @ParameterizedTest(name = "{0} ^ {1} = {2}")
    @CsvSource({
            "4.0, 0.5, 2.0",
            "9.0, 0.5, 3.0",
            "4.0, 1.5, 8.0",
            "4.0, -0.5, 0.5",
            "-4.0, 0.5, NaN"
    })
    void shouldReturnCorrectPowerForFractionalExponent(double base, double exponent, double expected) {
        double result = calculator.pow(base, exponent);
        assertEquals(expected, result, DELTA);
    }

    @ParameterizedTest(name = "{0} ^ {1} = {2}")
    @CsvSource({
            "0.0, 0.0, 1.0",
            "NaN, 0.0, 1.0",
            "NaN, 2.0, NaN",
            "2.0, NaN, NaN",
            "2.0, Infinity, Infinity",
            "0.5, Infinity, 0.0",
            "1.7976931348623157E308, 2.0, Infinity"
    })
    void shouldHandleSpecialValues(double base, double exponent, double expected) {
        double result = calculator.pow(base, exponent);
        assertEquals(expected, result, DELTA);
    }
}

package ec.edu.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ec.edu.epn.calculator.Calculator;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }


    @Test
    public void testSum() {
        int result = calculator.sum(2, 2);
        assertEquals(4, result);
    }

    @Test
    public void testMinus() {
        int result = calculator.minus(2, 1);
        assertEquals(1, result);
    }

    @Test
    public void testDivideSuccess() {
        int result = calculator.divide(4, 2);
        assertEquals(2, result);
    }

    @Test
    public void testDivideFail() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(4, 0));
    }

    @Test
    public void testMultiply() {
        int result = calculator.multiply(10, 3);
        assertEquals(30, result);
    }

}

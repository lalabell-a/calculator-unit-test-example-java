package ec.edu.calculator;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Parsed;

import ec.edu.epn.calculator.Calculator;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }


    @Test
    @DisplayName("Test unitaria que realiza la verificación del método")
    public void testSum() {
       /*  //Arrange + act
        int result = calculator.sum(2, 2);
        //Assert
        assertEquals(4, result);*/
        assertAll ("Suma de valores en varios casos",
            () -> {
                int resultado = calculator.sum(2, 2);
                assertEquals(4, resultado);
            },
            () -> {
                int resultado = calculator.sum(-1, 1);
                assertEquals(0, resultado);
            }
        );
    }

    public void testSum2() {
        //Arrange + act
        int result = calculator.sum(4, 6);
        //Assert
        assertEquals(4, result);
    }

    @ParameterizedTest
    @CsvSource({
        "2, 1, 3",
        "0, 5, 5",
        "-1, 2, 1"
    })
    public void testSumMultipleData(int a, int b, int expected){
        //Arrange + act
        int result = calculator.sum(a, b);
        //Assert
        assertEquals(expected, result);

    }

   @ParameterizedTest
   @ValueSource(ints = {1, 2, 3, 5, 10, 100, -1})
    public void testSumWithFixesValues(int value) {
        //Arrange + act
        int result = calculator.sum(value, 0);
        //Assert
        assertTrue(result == value);
    }

    @Test
    public void testMinus() {
        //Arrange + act
        int result = calculator.minus(2, 1);
        //Assert
        assertEquals(1, result);
    }

    @Test
    public void testDivideSuccess() {
        //Arrange + act
        int result = calculator.divide(4, 2);
        //Assert
        assertEquals(2, result);
    }

    @Test
    public void testDivideFail() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(4, 0));
    }

    @Test
    public void testMultiply() {
        //Arrange + act
        int result = calculator.multiply(10, 3);
        //Assert
        assertEquals(30, result);
    }

}

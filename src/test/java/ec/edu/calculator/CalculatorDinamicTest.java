package ec.edu.calculator;

    import static org.junit.jupiter.api.DynamicTest.dynamicTest;
    import java.util.Arrays;
    import java.util.function.BinaryOperator;
    import java.util.stream.Stream;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.DynamicTest;
    import org.junit.jupiter.api.TestFactory;
    import ec.edu.epn.calculator.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDinamicTest {
        
        private Calculator calculator;
    
        @BeforeEach
        public void setUp() {
            calculator = new Calculator();
        }
    
        @TestFactory
        Stream<DynamicTest> dynamicTestsForSum() {
            int[][] data = new int[][] {
                {1, 2, 3},
                {4, 5, 9},
                {10, 20, 30},
                {1, -1, 0}
            };
    
            return Arrays.stream(data).map((item)-> {
                int a = item[0];
                int b = item[1];
                int expected = item[2];
                return dynamicTest("Sumando " + a + " + " + b, () -> {
                    assertEquals(expected, calculator.sum(a, b));
                });
            });
        }


}

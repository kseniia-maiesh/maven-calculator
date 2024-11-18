package hello;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class ApplicationTests {

    @Test
    public void testValidExpression() {
        String expression = "1+1";
        double expectedResult = 2.0;

        try {
            Expression e = new ExpressionBuilder(expression).build();
            double result = e.evaluate();
            assertEquals(expectedResult, result, 0.001); 
        } catch (Exception e) {
            fail("Exception should not have been thrown");
        }
    }
    @Test
    public void testInvalidExpression() {
        String expression = "5-2";
        double expectedResult = 3.0;  
    
        try {
            Expression e = new ExpressionBuilder(expression).build();
            double result = e.evaluate();
            assertEquals(expectedResult, result, 0.001);  
        } catch (Exception e) {
            fail("Exception should not have been thrown");
        }
    }
    
}
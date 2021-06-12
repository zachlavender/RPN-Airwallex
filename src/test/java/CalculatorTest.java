import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calc;
    Stack<Double> output = new Stack<>();

    public CalculatorTest() {
        this.output.push(10.0);
    }


    @Before
    public void init() {
        calc = new Calculator();
    }
    @Test
    public void calculateSingle() throws emptyStackException {
        calc.calculate("3 7 +");
        assert output.equals(calc.stack);
    }

    @Test
    public void calculateMultiple() throws emptyStackException {
        calc.calculate("2 3 +");
        calc.calculate("2 *");
        assert output.equals(calc.stack);
    }

    @Test
    public void addUndo() throws emptyStackException {
        calc.calculate("7 3 + 3 undo");
        assert output.equals(calc.stack);
    }

    @Test
    public void undoUndo() throws emptyStackException  {
        calc.calculate("7 3 + 3 6 undo undo");
        assert output.equals(calc.stack);
    }

    @Test (expected = emptyStackException.class)
    public void undoEmpty() throws emptyStackException {
        calc.calculate("undo");
    }


    @Test
    public void clearUndo() throws emptyStackException {
        calc.calculate("10 clear undo");
        assert output.equals(calc.stack);
    }
}
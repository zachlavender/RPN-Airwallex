import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.Assert.*;

public class OperatorsTest {

    Operators operators = new Operators();
    Stack<Double> exampleStack;
    Stack<Double> checkStack;

    @Before
    public void init() {
        exampleStack = new Stack();
        exampleStack.push(18.0);
        exampleStack.push(9.0);
        checkStack = new Stack<>();
    }


    @Test
    public void clear(){
        exampleStack = operators.operate("clear",exampleStack);
        assert exampleStack.empty();
    }

    @Test
    public void numbers(){
        checkStack = operators.operate("18",checkStack);
        checkStack = operators.operate("9",checkStack);
        assert exampleStack.equals(checkStack);
    }

    @Test
    public void sqrt(){
        exampleStack = operators.operate("sqrt",exampleStack);
        checkStack.push(18.0);
        checkStack.push(3.0);
        assert exampleStack.equals(checkStack);
    }

    @Test
    public void subtract() {
        exampleStack = operators.operate("-", exampleStack);
        checkStack.push(9.0);
        assert exampleStack.equals(checkStack);
    }

    @Test
    public void addition() {
        exampleStack = operators.operate("+", exampleStack);
        checkStack.push(27.0);
        assert exampleStack.equals(checkStack);
    }

    @Test
    public void multiplication() {
        exampleStack = operators.operate("*", exampleStack);
        checkStack.push(162.0);
        assert exampleStack.equals(checkStack);
    }

    @Test
    public void division() {
        exampleStack = operators.operate("/", exampleStack);
        checkStack.push(2.0);
        assert exampleStack.equals(checkStack);
    }

    @Test(expected = EmptyStackException.class)
    public void emptyStack() {
        exampleStack = operators.operate("/", exampleStack);
        exampleStack = operators.operate("/", exampleStack);
    }

    @Test
    public void operate() {
    }
}
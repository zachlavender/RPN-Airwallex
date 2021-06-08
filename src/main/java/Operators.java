import java.util.EmptyStackException;
import java.util.Stack;
import com.google.common.primitives.Doubles;

public class Operators {
    Stack<Double> operate(String element,Stack<Double> stack) throws emptyStackException {
        try {
            switch (element) {
                case "clear":
                    stack = new Stack<>();
                    break;
                case "sqrt":
                    stack.push(Math.sqrt(stack.pop()));

                    break;
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    double sub = stack.pop();
                    stack.push(stack.pop() - sub);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    double denominator = stack.pop();
                    stack.push(stack.pop() / denominator);
                    break;
                default:
                    if (Doubles.tryParse(element) == null) {

                        throw new IllegalArgumentException();
                    }
                    stack.push(Double.parseDouble(element));

                    break;
            }
        }catch (EmptyStackException e) {
            throw new emptyStackException(e, element);
        }

        return stack;
    }
}
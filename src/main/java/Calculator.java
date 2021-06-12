import java.util.EmptyStackException;
import java.util.Stack;

class Calculator {
    Stack<Stack<Double>> stacks = new Stack<>();
    Stack<Double> stack = new Stack<>();
    Operators operators = new Operators();
    Calculator() {
    }

    public Stack<Double> calculate(String in) throws emptyStackException{
        String[] elements = in.split(" ");
        int position = 1;
        for (String element : elements){
            try {
                if (element.equals("undo")){
                    stack = stacks.pop();
                }else{
                    stacks.push((Stack<Double>)stack.clone());
                    stack = operators.operate(element,stack);
                }
            }catch (EmptyStackException e) {
                throw new emptyStackException(e, element, position);
            }
            position = position + element.length();
            position = position + 1;
        }

        return stack;
    }
}

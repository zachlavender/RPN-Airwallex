import java.util.EmptyStackException;
import java.util.Stack;

class Calculator {
    Stack<Stack<Double>> stacks = new Stack<>();
    Stack<Double> stack = new Stack<>();
    Operators operators = new Operators();
    Calculator() {
    }

    public Stack calculate(String in) throws emptyStackException{
        String[] elements = in.split(" ");
        int elementNum;
        for (elementNum = 0; elementNum < elements.length; elementNum++) {
            String element = elements[elementNum];
            try {
                if (element.equals("undo")){
                    stack = stacks.pop();
                }else{
                    stacks.push(stack);
                    stack = operators.operate(element,stack);
                }


            }catch (EmptyStackException e) {
                throw new emptyStackException(e, element, elementNum);
            }

        }

        return stack;
    }
}

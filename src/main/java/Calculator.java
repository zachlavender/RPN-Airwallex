import java.util.Stack;

class Calculator {
    Stack<Stack> stacks = new Stack<>();
    Stack<Double> stack = new Stack<>();
    Operators operators = new Operators();
    Calculator() {
    }

    public Stack calculate(String in) throws emptyStackException{
        String[] elements = in.split(" ");
        for (String element: elements){
            try {
                if (element.equals("undo")){
                    stack = stacks.pop();
                }else{
                    stack = operators.operate(element,stack);
                    stacks.push(stack);
                }


            }catch (Exception e){
                stack = new Stack<>();
                throw e;
            }

        }

        return stack;
    }
}

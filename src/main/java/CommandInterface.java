import java.io.InputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class CommandInterface {
    private static final DecimalFormat df10 = new DecimalFormat("#.##########");
    public void run(InputStream in, PrintStream out) {
        out.println("Welcome to Reverse Polish Notation calculator Please input a valid expression or type e to exit");
        String input;
        Scanner myScanner = new Scanner(in);
        Calculator calc = new Calculator();
        while (myScanner.hasNextLine()) {
            input = myScanner.nextLine();
            if (input.equals("e")) {
                System.exit(1);
                break;
            } else try {
                printStack(out,calc.calculate(input));
            } catch (IllegalArgumentException e) {
                out.println("Invalid notation, please try again or enter e to exit");
                printStack(out,calc.stack);
            } catch (emptyStackException e) {
                out.println("Operator "  + e.getOperator() + " (position " + e.getPosition() +  " ): insufficient parameters");
                printStack(out, calc.stack);
            }
        }
    }
    private void printStack(PrintStream out, Stack<Double> stack){
        out.print("stack: ");
        out.println(
                StreamSupport.stream(Spliterators.spliteratorUnknownSize(stack.iterator(), Spliterator.ORDERED), false)
                        .map(df10::format)
                        .collect(Collectors.joining(" ")));
    }


}


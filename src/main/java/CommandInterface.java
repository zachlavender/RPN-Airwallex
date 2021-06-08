import java.util.EmptyStackException;
import java.util.Scanner;

public class CommandInterface {
    public void run() {
        System.out.println("Welcome to Reverse Polish Notation calculator Please input a valid expression or type e to exit");
        String input;
        Scanner myScanner = new Scanner(System.in);
        Calculator calc = new Calculator();
        while (true) {
            input = myScanner.nextLine();
            if (input.equals("e")) {
                System.exit(1);
                break;
            } else try {
                System.out.println(calc.calculate(input).toString());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid notation calculator has been cleared, please try again or enter e to exit");
            } catch (emptyStackException e) {
                System.out.println("Operator "  + e.getOperator() + " : insufficient parameters");
            }
        }
    }
}


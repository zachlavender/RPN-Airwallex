import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CommandInterfaceTest {

    @Test
    public void runPrintTest() {
        CommandInterface clc = new CommandInterface();
        String input = "1 2 3 4 +\n1 2 3 3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        clc.run(in, new PrintStream(out));
        String a = out.toString();
        assertEquals(a, ("Welcome to Reverse Polish Notation calculator Please input a valid expression or type e to exit\r\n" +
                "stack: 1 2 7\r\nstack: 1 2 7 1 2 3 3\r\n"));
    }
    @Test
    public void errorPrintTest() {
        CommandInterface clc = new CommandInterface();
        String input = "1 clear /";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        clc.run(in, new PrintStream(out));
        String a = out.toString();
        assertEquals(a, ("Welcome to Reverse Polish Notation calculator Please input a valid expression or type e to exit\r\n" +
                "Operator / (position 9 ): insufficient parameters\r\n" +
                "stack: \r\n"));
    }


}
package org.howard.edu.lsp.assignment1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {

    @Test
    public void testGetMessage() {
        HelloWorld hello = new HelloWorld();
        String result = hello.getMessage();
        assertEquals("Hello World", result);
    }
}

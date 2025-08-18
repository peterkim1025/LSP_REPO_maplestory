/**
Name: maplestory
 */

package org.howard.edu.lsp.assignment1;

public class HelloWorld {
    public String getMessage() {
        return "Hello World";
    }

    public static void main(String[] args) {
        HelloWorld hello = new HelloWorld();
        System.out.println(hello.getMessage());
    }
}
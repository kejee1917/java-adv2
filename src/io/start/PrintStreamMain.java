package io.start;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class PrintStreamMain {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;

        byte[] bytes = "Hello!\n".getBytes(StandardCharsets.UTF_8);
        out.write(bytes);
    }
}

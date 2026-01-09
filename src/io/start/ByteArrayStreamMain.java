package io.start;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayStreamMain {
    public static void main(String[] args) throws IOException {
        byte[] input = {1, 2, 3};

        // 메모리에 저장
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write(input);

        ByteArrayInputStream bais = new ByteArrayInputStream(bos.toByteArray());
        byte[] readAllBytes = bais.readAllBytes();
        System.out.println(Arrays.toString(readAllBytes));
    }
}

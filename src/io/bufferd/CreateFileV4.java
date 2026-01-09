package io.bufferd;

import java.io.FileOutputStream;
import java.io.IOException;

import static io.bufferd.BufferedConst.FILE_NAME;
import static io.bufferd.BufferedConst.FILE_SIZE;

public class CreateFileV4 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        byte[] buffer = new byte[FILE_SIZE];
        for (int i = 0; i < FILE_SIZE; i++) {
            buffer[i] = 1;
        }
        fos.write(buffer);
        fos.close();

        long endTime = System.currentTimeMillis();

        System.out.println("File create = " + FILE_NAME);
        System.out.println("Time taken = " + (endTime - startTime) + "ms");

    }
}

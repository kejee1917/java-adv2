package io.bufferd;

import java.io.FileOutputStream;
import java.io.IOException;

import static io.bufferd.BufferedConst.*;

public class CreateFileV2 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bufferIndex = 0;

        for (int i = 0; i < FILE_SIZE; i++) {
            buffer[bufferIndex++] = 1;

            if(bufferIndex == BUFFER_SIZE) {
                fos.write(buffer);
                bufferIndex = 0;
            }
        }

        if(bufferIndex > 0) {
            fos.write(buffer, 0, bufferIndex);
        }

        fos.close();
        long endTime = System.currentTimeMillis();
        System.out.println("File create = " + FILE_NAME);
        System.out.println("Time taken = " + (endTime - startTime) + "ms");

    }
}

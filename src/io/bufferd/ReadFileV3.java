package io.bufferd;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import static io.bufferd.BufferedConst.BUFFER_SIZE;
import static io.bufferd.BufferedConst.FILE_NAME;

public class ReadFileV3 {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        BufferedInputStream bis = new BufferedInputStream(fis, BUFFER_SIZE);
        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        int data;

        while ((data = bis.read()) != -1) {
            fileSize++;
        }
        bis.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File create = " + FILE_NAME);
        System.out.println("Time taken = " + (endTime - startTime) + "ms");
    }
}

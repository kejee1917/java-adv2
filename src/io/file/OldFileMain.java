package io.file;

import java.io.File;
import java.io.IOException;

// 옛날 방식이긴 하지만, 여전히 사용하는 경우가 많기 때문에 알아둘 것.
public class OldFileMain {

    public static void main(String[] args) throws IOException {
        File file = new File("temp/example.txt");
        File directory = new File("temp/exampleDir");

        System.out.println("file.exists() = " + file.exists());

        boolean newFile = file.createNewFile();
        System.out.println("newFile = " + newFile);

        System.out.println("file.isFile() = " + file.isFile());
        System.out.println("file.isDirectory() = " + file.isDirectory());
        System.out.println("file.getName() = " + file.getName());
        System.out.println("file.length() = " + file.length() + " bytes");

    }
}

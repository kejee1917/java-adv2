package io.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class NewFilesMain {

    public static void main(String[] args) throws IOException {
        Path file = Path.of("temp/example.txt");
        Path directory = Path.of("temp/exampleDir");

        try {
            Files.createFile(file);
        }catch (FileAlreadyExistsException e) {
            System.out.println("File already exist.");
        }

        try {
            Files.createDirectory(directory);
        }catch (FileAlreadyExistsException e) {
            System.out.println("directory already exist.");
        }

//        Files.delete(file);

        System.out.println("Files.isRegularFile(file) = " + Files.isRegularFile(file));
        System.out.println("Files.isDirectory(directory) = " + Files.isDirectory(directory));
        System.out.println("file.getFileName() = " + file.getFileName());
        System.out.println("Files.size = " + Files.size(file));

        Path newFile = Path.of("temp/newExam.txt");
        Files.move(file, newFile, StandardCopyOption.REPLACE_EXISTING);

        FileTime lastModifiedTime = Files.getLastModifiedTime(newFile);
        System.out.println("lastModifiedTime = " + lastModifiedTime);

        BasicFileAttributes attr = Files.readAttributes(newFile, BasicFileAttributes.class);
        System.out.println("attr.creationTime() = " + attr.creationTime());
        System.out.println("attr.isDirectory() = " + attr.isDirectory());
        System.out.println("attr.isRegularFile() = " + attr.isRegularFile());
        System.out.println("attr.isSymbolicLink() = " + attr.isSymbolicLink());
    }
}

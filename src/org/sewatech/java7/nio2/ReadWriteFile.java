package org.sewatech.java7.nio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author alexis
 */
public class ReadWriteFile {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    public static void main(String... args) throws IOException {
        readWithReader();
        writeWithWriter();
        System.out.println("***************************");
        readAllLines();
    }

    private static void readWithReader() throws IOException {
        Path sourcePath = Paths.get("src/org/sewatech/java7/nio2/UsingFileStore.java");
        try (BufferedReader reader = Files.newBufferedReader(sourcePath, UTF8)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
    private static void readAllLines() throws IOException {
            Path sourcePath = Paths.get("src/org/sewatech/java7/nio2/UsingFileStore.java");
            List<String> lines = Files.readAllLines(sourcePath, UTF8);
            for (String line : lines) {
                System.out.println(line);
            }
    }
    private static void writeWithWriter() throws IOException {
        Path sourcePath = Paths.get("nothing.txt");
        String content = "line 1\nline 2\nline 3";
        try (BufferedWriter writer = Files.newBufferedWriter(sourcePath, UTF8)) {
            writer.write(content);
        }
    }
}
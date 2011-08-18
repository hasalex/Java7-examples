package org.sewatech.java7.nio2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author alexis
 */
public class Directories {

    public static void main(String... args) throws Exception {
        Path homePath = Paths.get(System.getProperty("user.home"));
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(homePath)) {
            for (Path entry : stream) {
                // System.out.println(entry);
            }
        }
        System.out.println("********************************");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(homePath, "*.{java,xml}")) {
            for (Path entry : stream) {
                System.out.println(entry);
            }
        }
        System.out.println("********************************");
        Files.walkFileTree(Paths.get(".").normalize(), new PathMatcherVisitor("glob:**/*.java"));
    }

}

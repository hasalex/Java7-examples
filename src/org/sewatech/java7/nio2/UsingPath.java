package org.sewatech.java7.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 *
 * @author alexis
 */
public class UsingPath {

    public static void main(String... args) throws IOException {
        Path projectPath = Paths.get(".");

        Path srcPath = Paths.get("src", "..", ".", "src");
        System.out.println(srcPath.toAbsolutePath());
        System.out.println(srcPath.normalize().toAbsolutePath());

        Path docPath = Paths.get("nio-doc");
        System.out.println(docPath.toAbsolutePath());
        System.out.println(docPath.toRealPath());

        Path jarPath = projectPath.resolve("dist").resolve("Java7Examples.jar").normalize().toAbsolutePath();
        System.out.println("jarPath : " + jarPath);
        Path jar2Path = projectPath.resolve(Paths.get("dist", "Java7Examples.jar")).normalize().toAbsolutePath();
        System.out.println("jar2Path : " + jar2Path);

        Path homePath = Paths.get(System.getProperty("user.home"));
        System.out.println("homePath : " + homePath);
        System.out.println("jarPath (relative) : " + homePath.relativize(jarPath));
    }
}

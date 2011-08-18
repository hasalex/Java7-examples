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
public class SymLinkSupport {

    public static void main(String... args) throws IOException {        
        Path projectPath = Paths.get(".");

        Path docPath = Paths.get("nio-doc");
        System.out.println("docPath : " + docPath.toAbsolutePath());
        Path docRealPath = docPath.toRealPath();
        System.out.println("docRealPath : " + docRealPath);

        Files.delete(docPath);
        System.out.print("docPath exists : " + Files.exists(docPath));
        System.out.println(" // docRealPath exists : " + Files.exists(docRealPath));

        Files.createSymbolicLink(docPath, docRealPath);
        System.out.print("docPath exists : " + Files.exists(docPath));
        System.out.println(" and is sym link : " + Files.isSymbolicLink(docPath));

        System.out.println("Real path : " + Files.readSymbolicLink(docPath));
        
    }
}

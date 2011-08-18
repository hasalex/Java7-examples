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
public class MetadataAttributes {

    public static void main(String... args) throws IOException {
        Path projectPath = Paths.get(".");

        Path jarPath = projectPath.resolve("dist").resolve("Java7Examples.jar").normalize().toAbsolutePath();
        System.out.println("jarPath : " + jarPath);

        BasicFileAttributes jarBasicAttrs = Files.readAttributes(jarPath, BasicFileAttributes.class);
        System.out.println("creationTime is " + jarBasicAttrs.creationTime());
        System.out.println("lastAccessTime is " + jarBasicAttrs.lastAccessTime());

        BasicFileAttributeView jarBasicAttrView = Files.getFileAttributeView(jarPath, BasicFileAttributeView.class);
        jarBasicAttrView.setTimes(FileTime.fromMillis(0), FileTime.fromMillis(0), FileTime.fromMillis(0));
        
        DosFileAttributes jarDosAttrs = Files.readAttributes(jarPath, DosFileAttributes.class);
        System.out.println("isReadOnly is " + jarDosAttrs.isReadOnly());
        System.out.println("isHidden is " + jarDosAttrs.isHidden());
        System.out.println("isArchive is " + jarDosAttrs.isArchive());
        System.out.println("isSystem is " + jarDosAttrs.isSystem());
    }
}

package org.sewatech.java7.nio2;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.Set;

/**
 *
 * @author alexis
 */
public class UsingFileSystem {

    public static void main(String... args) throws IOException {
        NumberFormat formatter = NumberFormat.getIntegerInstance();

        FileSystem defaultFS = FileSystems.getDefault();
        Iterable<Path> rootDirectories = defaultFS.getRootDirectories();
        for (Path root : rootDirectories) {
            System.out.println(root);
        }
        Set<String> supportedFileAttributeViews = defaultFS.supportedFileAttributeViews();
    }
}

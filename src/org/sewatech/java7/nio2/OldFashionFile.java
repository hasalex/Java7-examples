package org.sewatech.java7.nio2;

import java.io.File;

/**
 *
 * @author alexis
 */
public class OldFashionFile {

    public static void main(String... args) {
        printRoots();
        printDirectoryContent(".");
    }

    private static void printDirectoryContent(String path) {
        File defaultDir = new File(path);
        System.out.println(defaultDir.getAbsolutePath());
        File[] children = defaultDir.listFiles();
        if (children == null) {
            System.out.println("Empty directory");
        } else {
            for (File child : children) {
                System.out.println(child.getAbsolutePath());
            }
        }

    }

    private static void printRoots() {
        File[] roots = File.listRoots();
        for (File root : roots) {
            System.out.println(root.getAbsolutePath());
        }
    }
}

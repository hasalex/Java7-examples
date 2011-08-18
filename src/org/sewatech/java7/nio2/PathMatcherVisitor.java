package org.sewatech.java7.nio2;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author alexis
 */
public class PathMatcherVisitor extends SimpleFileVisitor<Path> {

    private static final Path EMPTY_PATH = Paths.get("");
    
    private final PathMatcher matcher;

    public PathMatcherVisitor(PathMatcher matcher) {
        this.matcher = matcher;
    }

    public PathMatcherVisitor(String pattern) {
        this.matcher = EMPTY_PATH.getFileSystem().getPathMatcher(pattern);
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attr) {
        if (matcher.matches(path)) {
            System.out.println(path);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attrs) throws IOException {
        if (!Files.isSameFile(path, EMPTY_PATH) && Files.isHidden(path)) {
            return FileVisitResult.SKIP_SUBTREE;
        } else {
            return FileVisitResult.CONTINUE;
        }
    }
}

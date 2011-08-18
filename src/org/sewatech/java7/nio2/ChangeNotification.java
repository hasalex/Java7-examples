package org.sewatech.java7.nio2;

import static java.nio.file.StandardWatchEventKinds.*;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * @author alexis
 */
public class ChangeNotification {

    public static void main(String... args) throws IOException {
        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path sourcePath = Paths.get("");
        WatchKey key = sourcePath.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

        try {
            watcher.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(event.context() + " - " + event.kind());
            }
            key.reset();
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }

        key.cancel();
        // ou
        watcher.close();
    }
}

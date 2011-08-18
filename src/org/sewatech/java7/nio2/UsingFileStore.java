package org.sewatech.java7.nio2;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.text.NumberFormat;

/**
 *
 * @author alexis
 */
public class UsingFileStore {

    public static void main(String... args) throws IOException {
        NumberFormat formatter = NumberFormat.getIntegerInstance();

        Path homePath = Paths.get(System.getProperty("user.home"));
        System.out.println("homePath : " + homePath);
        FileStore homeStore = Files.getFileStore(homePath);
        System.out.println("Classe : " + homeStore.getClass());
        System.out.println("Nom : " + homeStore.name());
        System.out.println("Type : " + homeStore.type());
        System.out.println("Support Posix : " + homeStore.supportsFileAttributeView(PosixFileAttributeView.class));
        System.out.println("Support Dos : " + homeStore.supportsFileAttributeView(DosFileAttributeView.class));
        System.out.println("Taille (Go) : " + formatter.format(homeStore.getTotalSpace() / 1048576));
        System.out.println("Espace disponible (Go) : " + homeStore.getUsableSpace() / 1048576);
        System.out.println("Espace inoccupé (Go) : " + homeStore.getUnallocatedSpace() / 1048576);

        Iterable<FileStore> fileStores = FileSystems.getDefault().getFileStores();
        for (FileStore fileStore : fileStores) {
            System.out.print(fileStore);
            System.out.println(", type : " + fileStore.type());
        }
    }
}

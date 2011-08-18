package org.sewatech.java7.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author alexis
 */
public class PosixPermissions {

    public static void main(String... args) throws IOException {
        Path projectPath = Paths.get(".").toAbsolutePath().normalize();
        Path manifestPath = projectPath.resolve("manifest.mf");

        UserPrincipal fileOwner = Files.getOwner(manifestPath);
        System.out.println("Propriétaire du fichier : " + fileOwner);

        PosixFileAttributes attributes = Files.readAttributes(manifestPath, PosixFileAttributes.class);
        UserPrincipal owner = attributes.owner();
        GroupPrincipal group = attributes.group();
        System.out.println("Le fichier appartient à " + owner + ":" + group);

        Set<PosixFilePermission> permissions = attributes.permissions();
        System.out.println(PosixFilePermissions.toString(permissions));
        
        Set<PosixFilePermission> newPermissions = PosixFilePermissions.fromString("rw-r--r--");
        Files.setPosixFilePermissions(manifestPath, newPermissions);

        PosixFilePermission[] permissionsArray 
                = {PosixFilePermission.OWNER_READ, 
                   PosixFilePermission.OWNER_WRITE,
                   PosixFilePermission.GROUP_READ,
                   //PosixFilePermission.GROUP_WRITE,
                   PosixFilePermission.OTHERS_READ};
        newPermissions = new HashSet<>(Arrays.asList(permissionsArray));
        Files.setPosixFilePermissions(manifestPath, newPermissions);

        modifyPermissions(manifestPath);
    }

    private static void modifyPermissions(Path path) throws IOException {
        PosixFileAttributes attributes = Files.readAttributes(path, PosixFileAttributes.class);
        Set<PosixFilePermission> permissions = attributes.permissions();
        System.out.println(PosixFilePermissions.toString(permissions));

        permissions.add(PosixFilePermission.OTHERS_EXECUTE);
        permissions.remove(PosixFilePermission.OTHERS_READ);
        Files.setPosixFilePermissions(path, permissions);
    }
}

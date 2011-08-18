package org.sewatech.java7.coin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author alexis
 */
public class TryWithResources {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //mainOld(args);
        mainNew(args);
    }

    public static void mainOld(String[] args) {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("example.txt"));
            try {
                System.out.println(br.readLine());
            } catch (IOException e) {
                System.err.println("Problème de lecture du fichier");
            } finally {
                try {
                    br.close();
                } catch (IOException ex) {
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Fichier non trouvé");
        }
    }

    public static void mainNew(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("example.txt"))) {
            System.out.println(br.readLine());
        } catch (FileNotFoundException ex) {
            System.err.println("Fichier non trouvé");
        } catch (IOException e) {
            System.err.println("Problème de lecture du fichier");
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sewatech.java7.coin;

/**
 *
 * @author alexis
 */
public class MultiCatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //mainOld(args);
        mainNew(args);
    }
    
    public static void mainOld(String[] args) {
        try {
            Class.forName("org.sewatech.examples.java7.MyClass").newInstance();
            //...
        } catch (ClassNotFoundException e) {
            System.err.printf("Problème de création de mon objet (%s)\n", e);
        } catch (InstantiationException e) {
            System.err.printf("Problème de création de mon objet (%s)\n", e);
        } catch (IllegalAccessException e) {
            System.err.printf("Problème de création de mon objet (%s)\n", e);
        }
    }
    public static void mainNew(String[] args) {
        try {
            Class.forName("org.sewatech.examples.java7.MyClass").newInstance();
            //...
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.err.printf("Problème de création de mon objet (%s)\n", e);
        }
    }
}

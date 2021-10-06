/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.proyecto.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josed
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File fichero = new File("C:/Users/josed/Documents/UNIVERSIDAD");
        getPrev("C:/Users/josed/Documents/PRUEBAS DE ARCHIVOS.pdf", -1);
    }

    public static void mostrarCarpeta(File fichero) {
        if (fichero.isDirectory()) {
            File[] lista = fichero.listFiles();
            for (int i = 0; i < lista.length; i++) {
                String name = lista[i].getName();

                if (lista[i].isDirectory()) {
                    mostrarCarpeta(lista[i]);
                } else {
                    if (isPDF(name)) {
                        System.out.println(lista[i].getName());
                    }
                }
            }
        }
    }

    public static String getXref(String path, long offset) {
        String offsetString = "";
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            if (offset == -1) {
                offset = file.length() - 8;
                file.seek(offset);
                boolean OA = false;
                boolean OD = false;

                //Busca 0D 0A
                while (!OA) {
                    byte B[] = new byte[1];
                    file.read(B);
                    System.out.println("Nombre:*" + Integer.toHexString(B[0]) + "*");
                    if ("a".equals(Integer.toHexString(B[0]))) {
                        System.out.println("OA");
                        OA = true;
                    } else {
                        offset -= 1;
                    }

                    file.seek(offset);
                }

                OA = false;
                file.seek(offset + 1);
                
                while (!OD) {
                    byte B[] = new byte[1];
                    file.read(B);
                    if ("d".equals(Integer.toHexString(B[0]))) {
                        OD = true;
                    } else {
                        offsetString += new String(B);

                    }
                }
                System.out.println(offsetString);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return offsetString;
    }

    public static String getPrev(String path, long offset) {
        String offsetString = "";
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");

            if (offset == -1) {
                offset = file.length();
                file.seek(offset);
            } else {
                file.seek(offset);
            }

            boolean prev = false;
            int j=0;
            while (!prev) {
                byte B[] = new byte[1];
                file.read(B);
                if ("/".equals(new String(B))) {
                    j++;
                    if(j==2){
                        prev = true;
                    }
                    else{
                        offset -= 1;
                    }
                } else {
                    offset -= 1;
                }

                file.seek(offset);
            }
            file.seek(offset + 6);
            boolean slash=false;
            while (!slash) {
                    byte B[] = new byte[1];
                    file.read(B);
                    if ("/".equals(new String(B))) {
                        slash = true;
                    } else {
                        offsetString += new String(B);

                    }
                }
            System.out.println("*"+offsetString+"*");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  offsetString;
    }

    public static boolean isPDF(String name) {

        int len = name.length();
        String res = "";
        char letter = name.charAt(len - 4);
        res += letter;
        letter = name.charAt(len - 3);
        res += String.valueOf(letter);
        letter = name.charAt(len - 2);
        res += String.valueOf(letter);
        letter = name.charAt(len - 1);
        res += String.valueOf(letter);
        if (res.equals(".pdf")) {
            System.out.println("PDF:");
            return true;
        }

        return false;

    }

}

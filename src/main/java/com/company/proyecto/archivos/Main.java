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
        
       long x=getXrefRecursivo("C:/Users/josed/Documents/PRUEBAS DE ARCHIVOS.pdf",-1);
        System.out.println("Long: "+x);
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

    

    public static long getXrefRecursivo(String path, long offset) {
        long offsetInicial=offset;
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            if (offset == -1) {
                offset = file.length() - 5;
                file.seek(offset);
                
            }
            else{
                offset = offset - 7;
                file.seek(offset);
            }
            //COMPRUEBA %%OEF
                
                byte EOF[] = new byte[5];
                file.read(EOF);
                System.out.println("|" + new String(EOF) + "|");
                if("%%EOF".equals(new String(EOF))){
                    System.out.println("si entro");
                offset = file.getFilePointer() - 8;
                file.seek(offset);
                boolean OA = false;
                
                //Busca BYTE 0A
                while (!OA) {
                    byte byteB[] = new byte[1];
                    file.read(byteB);
                    System.out.println("BYTE:*" + Integer.toHexString(byteB[0]) + "*");
                    if ("a".equals(Integer.toHexString(byteB[0]))) {
                        System.out.println("OA");
                        OA = true;
                    } else {
                        offset -= 1;
                    }

                    file.seek(offset);
                }
                file.seek(offset+1);
                //Recorre hasta BYTE 0D
                boolean OD = false;
                while (!OD) {
                    byte B[] = new byte[1];
                    file.read(B);
                    if ("d".equals(Integer.toHexString(B[0]))) {
                        OD = true;
                    } else {
                        offsetString += new String(B);

                    }
                }
                
                System.out.println("Xref Offset: |"+offsetString+"|");
                offset=Long.parseLong(offsetString);
                }
                else{
                    return offset+7;
                }
                
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getXrefRecursivo(path, offset);
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

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
import java.util.ArrayList;

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
        
       File file=new File("C:/Users/Adrian/Documents/Universdidad/Prueba1");
       mostrarCarpeta(file); 


        
    }
    
  /**
   * Metodo para recorrer un directorio recursivamente 
   * En busca de formtamos PDF y leer sus metadatos
   * @param fichero con el directorio a explorar
   */
    public static void mostrarCarpeta(File fichero) {
        ArrayList<PDF> pdfs=new ArrayList<PDF>();
        ReadBinaryFile Read = new ReadBinaryFile();
        
        if (fichero.isDirectory()) {
            File[] lista = fichero.listFiles();
            for (int i = 0; i < lista.length; i++) {
                String name = lista[i].getName();

                if (lista[i].isDirectory()) {
                    mostrarCarpeta(lista[i]);
                } else {
                    if (isPDF(name)) {
                        System.out.println(lista[i].getName());
                        String path=lista[i].getAbsolutePath().replace("\\", "/");
                        PdfMetadata pdf=new PdfMetadata(path);
                        pdfs.add(pdf.getPdf());
                        pdf.ShowInfo();
                        
                        
                    }
                }
            }
        }
        WriteBinaryFile write=new WriteBinaryFile(pdfs);
        write.writeFile();
        Read.ReadFile();
        Read.showInfo();

    }
   
    /**
     * Metodo para determinar si un fichero es extension PDF
     * @param name path del fichero
     * @return booleano si es PDF
     */
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

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
        File fichero = new File("C:/Users/Adrian/Documents/Universdidad/Prueba1/Hola.pdf");
        
       long x=getXrefRecursivo("C:/Users/Adrian/Documents/Universdidad/Prueba1/Hola.pdf",-1);
       
        int obj=getInfoObj("C:/Users/Adrian/Documents/Universdidad/Prueba1/Hola.pdf");
        long e=getOffsetObj("C:/Users/Adrian/Documents/Universdidad/Prueba1/Hola.pdf",x , obj);
        System.out.println(e);
        ReadData(e,"C:/Users/Adrian/Documents/Universdidad/Prueba1/Hola.pdf");
        
    }
    
    public  static void ReadData(long e,String path){  // Leer infrmacion del PDF
        try {
            RandomAccessFile file = new RandomAccessFile(path,"r");
            
            
            boolean endobj = false;
            
            file.seek(e);
            
            while(!endobj){
                String etiqueta = "";
                String data = "";
                byte info[] = new byte[1];
                file.read(info);
                
                if("/".equals(new String(info))){
                    boolean fin = false;
   
                    while(!fin){
                        
                        byte info_e[] = new byte[1];
                        file.read(info_e);
                    
                        if("(".equals(new String(info_e))){
                            System.out.println("Etiqueta: " + etiqueta);
                            etiqueta+="|";
                            boolean fin2 = false;
                            
                            while(!fin2){
                            byte info_d[] = new byte[1];
                            file.read(info_d);
                            
                            if(")".equals(new String(info_d))){
                             System.out.println("Data: " + data);
                             data+="|";
                             fin2 = true;
                             
                            }else{
                             data+= new String(info_d);
                            }
                        
                            
                            }
                         fin = true;
                         
                       
                         }else{
                        etiqueta+= new String(info_e);
                        
                    
                        }
                    
                    }
                    
                }
                
                if(">".equals(new String(info))){
                     
                    endobj = true;
                    
                   
                }
                
                
                
            }
            
            
           
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        String offsetString="";
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

    public static int getInfoObj(String path){
        String obj="";
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            
            long offset = file.length();
            file.seek(offset);
            boolean info=false;
            while(!info){
                byte byteB[] = new byte[1];
                file.read(byteB);
                System.out.println("|"+Integer.toHexString(byteB[0])+"|");
                if("/".equals(new String(byteB))){
                    byte infoString[] = new byte[4];
                    file.read(infoString);
                    System.out.println("O: |"+new String(infoString)+"|");
                    if("Info".equals(new String(infoString))){
                        file.read(byteB);
                        System.out.println(Integer.toHexString(byteB[0]));
                        boolean isRead=false;
                        while(!isRead){
                            file.read(byteB);
                            if("20".equals(Integer.toHexString(byteB[0]))){
                                isRead=true;
                            }
                            else{
                                obj+=new String(byteB);
                            }
                        }
                        info=true;
                    }
                    else{
                       offset -= 4; 
                    }
                    
                }else{
                    offset -= 1;
                }
                file.seek(offset);
                System.out.println("OBJ:"+obj);
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Integer.valueOf(obj);
    }
    
    public static boolean inRange(String path,long offset,int obj){
        boolean inRange=false;
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            file.seek(offset);
            boolean startRange=false;
            String startRangeString="";
            while(!startRange){
                
                byte byteB[]=new byte[1];
                file.read(byteB);
                if("20".equals(Integer.toHexString(byteB[0]))){
                    startRange=true;
                }
                else{
                    startRangeString+=new String(byteB);
                }
                
                
            }
            System.out.println("|"+startRangeString+"|");
            
            boolean endRange=false;
            String endRangeString="";
            while(!endRange){
                
                byte byteB[]=new byte[1];
                file.read(byteB);
                if("d".equals(Integer.toHexString(byteB[0]))){
                    endRange=true;
                }
                else{
                    endRangeString+=new String(byteB);
                }
                
                
            }
            System.out.println("|"+endRangeString+"|");
            System.out.println("Last"+file.getFilePointer());
            
            
            if( obj>=Integer.valueOf(startRangeString) && obj<=Integer.valueOf(endRangeString)){
                inRange=true;
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  inRange;
    }
    
    public static int startRange(String path,long offset){
        String startRangeString="";
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            file.seek(offset);
            boolean startRange=false;
            while(!startRange){
                
                byte byteB[]=new byte[1];
                file.read(byteB);
                if("20".equals(Integer.toHexString(byteB[0]))){
                    startRange=true;
                }
                else{
                    startRangeString+=new String(byteB);
                }
                
                
            }
            System.out.println("|"+startRangeString+"|");
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  Integer.valueOf(startRangeString);
    }
    
    public static long beforeObj(String path,long offset){
        boolean OA=false;
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            file.seek(offset);
            while(!OA){
                byte byteB[]=new byte[1];
                file.read(byteB);
                {
                    if("a".equals(Integer.toHexString(byteB[0]))){
                        OA=true;
                        offset=file.getFilePointer();
                    }
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return offset;
    }
    
    public static long getOffsetObj(String path,long xref,int obj){
        byte offsetObj[]=new byte[10];
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            xref+=6;
            file.seek(xref);
            System.out.println(inRange(path, file.getFilePointer(), obj));
            System.out.println(startRange(path, xref));
            int position=obj-startRange(path, xref);
            System.out.println(file.getFilePointer());
            file.read();
            file.read();
            long offset=position*20+beforeObj(path, xref);
            System.out.println("long:"+offset);
            file.seek(offset);
            file.read(offsetObj);
            
            System.out.println(new String(offsetObj));
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return  Long.valueOf(new String(offsetObj));
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

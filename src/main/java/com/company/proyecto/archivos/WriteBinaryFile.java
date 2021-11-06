/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.proyecto.archivos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josed
 */
public class WriteBinaryFile {
   
    private ArrayList<PDF> pdfs;

    public WriteBinaryFile(ArrayList<PDF> pdfs) {
        this.pdfs =pdfs;
    }
    
    public void writeFile(){
        try {
            RandomAccessFile file=new RandomAccessFile("datos.bin","rw");
            
            file.writeBytes("ADES");
            for(int i=0;i<this.pdfs.size();i++){
                file.write(pdfs.get(i).getName().length());
                file.writeBytes(pdfs.get(i).getName());
                file.write(pdfs.get(i).getVersion().length());
                file.writeBytes(pdfs.get(i).getVersion());
                file.writeLong(pdfs.get(i).getSize());
                String[] keys={"Title","Subject","Keywords","Author","CreationDate","ModDate","Creator","Producer"};
                
                //Itera el Map de los metadatos si no existe una key escribe 0
                for(int j=0; j<keys.length;j++){
                    if(pdfs.get(i).getMetadata().get(keys[j])!=null){
                        int len=pdfs.get(i).getMetadata().get(keys[j]).length();
                        String value=pdfs.get(i).getMetadata().get(keys[j]);
                        file.write(len);
                        file.writeBytes(value);
                    }
                    else{
                        byte b=0;
                        file.write(b);
                    }
                }
                
                file.writeInt(pdfs.get(i).getPages());
                file.writeInt(pdfs.get(i).getImages());
                
                //Escribe el tamaño de la lista de fuentes
                file.write(pdfs.get(i).getFonts().size());
                //Escribe todas las fuentes
                for(int j=0;j<pdfs.get(i).getFonts().size();j++){
                    int len=pdfs.get(i).getFonts().get(j).length();
                    String value=pdfs.get(i).getFonts().get(j);
                    file.write(len);
                    file.writeBytes(value);
                }
                
                
                //Marca de un nuevo registro
               if(i==this.pdfs.size()-1){
                   file.writeBytes("EOF");
               }
               else{
                   file.writeBytes("NXT");
               }
            }
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteBinaryFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WriteBinaryFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}

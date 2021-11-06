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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class ReadBinaryFile {
    private ArrayList<PDF> pdfList;
    
    public ReadBinaryFile(){
        this.pdfList = new ArrayList<PDF>();
    }
    
    public void ReadFile(){
        
        PDF data = new PDF();
        HashMap<String,String> metadata = new HashMap<>();
        ArrayList<String> fonts = new ArrayList<String>();
        try {
            
            RandomAccessFile file = new RandomAccessFile("datos.bin","r");
            
            int tamanio = file.read();
            
            //boolean endfile = false;ss
            file.seek(0);
            byte ades[] = new byte[4];
            file.read(ades);
            System.out.println(new String(ades));
          if("ADES".equals(new String(ades))){
              boolean fin = false;
              
              while(!fin){
                                
            
              byte size = file.readByte();
              byte nombre[] = new byte[size];
              file.read(nombre);
              String name = new String(nombre);
              System.out.println(name);
              data.setName(name);
              
              size = file.readByte();
              byte ver[] = new byte[size];
              file.read(ver);
              String version = new String(ver);
              System.out.println(version);
              data.setVersion(version);
              
              long size2 = file.readLong();
              data.setSize(size2);
              size = file.readByte();
              
              if(size !=0){
                  byte titulo [] = new byte[size];
                  file.read(titulo);
                  String title = new String(titulo);
                  System.out.println(title);
                  metadata.put("Title", title);
              }
              
               size = file.readByte();
               System.out.println(size);
              
              if(size !=0){
                  byte subjet [] = new byte[size];
                  file.read(subjet);
                  String subj = new String(subjet);
                  System.out.println(subj);
                  metadata.put("Subject", subj);
              }
              
              size = file.readByte();
              
              
              if(size !=0){
                  byte keywrods [] = new byte[size];
                  file.read(keywrods);
                  String keyW = new String(keywrods);
                  System.out.println(keyW);
                  metadata.put("Keywords", keyW);
              }
              
               size = file.readByte();
              
              
              if(size !=0){
                  byte author [] = new byte[size];
                  file.read(author);
                  String autor = new String(author);
                  System.out.println(autor);
                  metadata.put("Author", autor);
              }
              
              size = file.readByte();
               
              if(size !=0){
                  byte CreationDate [] = new byte[size];
                  file.read(CreationDate);
                  String date = new String(CreationDate);
                  System.out.println(date);
                  metadata.put("CreationDate", date); 
              }
              
              size = file.readByte();
               
              if(size !=0){
                  byte ModDate [] = new byte[size];
                  file.read(ModDate);
                  String mdate = new String(ModDate);
                  System.out.println(mdate);
                  metadata.put("ModDate", mdate);
              }
              
              size = file.readByte();
               
              if(size !=0){
                  byte Creador [] = new byte[size];
                  file.read(Creador);
                  String Creator = new String(Creador);
                  System.out.println(Creator);
                  metadata.put("Cretor", Creator);
              }
              
              size = file.readByte();
               
              if(size !=0){
                  byte Lproducer [] = new byte[size];
                  file.read(Lproducer);
                  String productor = new String(Lproducer);
                  System.out.println(productor);
                  metadata.put("Producer", productor);
                  
              }
              
              
              int page = file.readInt();
              System.out.println(page);
              data.setPages(page);
              int images = file.readInt();
              System.out.println(images);
              data.setImages(images);
              byte items = file.readByte();
             
              
              for(int i=0;i<items;i++){
                  size = file.readByte();
                  System.out.println(size);
                  byte fuente[] = new byte[size];
                  file.read(fuente);
                  String font = new String(fuente);
                  fonts.add(font);
              }
              
              byte marca[] = new byte[3];
              file.read(marca);
              String marc = new String(marca);
              
              if(marc.equals("EOF")){
                  fin = true;
              }
            
              
              data.setFonts(fonts);
              data.setMetadata(metadata);
              System.out.println(data.getMetadata().get("Title"));
              this.pdfList.add(data);
              }
              
          }
            
            
          file.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadBinaryFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadBinaryFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
}

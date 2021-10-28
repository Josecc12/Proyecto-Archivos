/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.proyecto.archivos;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josed
 */
public class WriteBinaryFile {
    
    private PdfMetadata pdf;

    public WriteBinaryFile(PdfMetadata pdf) {
        this.pdf = pdf;
    }
    
    public void writeFile(){
        try {
            RandomAccessFile file=new RandomAccessFile("datos.bin","rw");
            //String namePdf=
            String version=this.pdf.getVersion();
            Long size=this.pdf.getFileSize();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteBinaryFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}

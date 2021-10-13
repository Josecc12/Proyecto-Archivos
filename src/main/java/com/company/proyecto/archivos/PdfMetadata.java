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

public class PdfMetadata {
    String path;
    long xref;

    public PdfMetadata(String path) {
        this.path = path;

        //offset xref Table
         this.xref = getXref(-1);

        //obj
        int objRoot = getRootObj();
        int objInfo = getInfoObj();

        //ofsset Objs
        long offsetobjInfo = getOffsetObj(xref, objInfo);
        long offsetObjRoot = getOffsetObj(xref, objRoot);
        int objPages = getObjPages(offsetObjRoot);
        long offsetObjPages = getOffsetObj(xref, objPages);


        //Info-Pages
        ArrayList<Integer> arr = getKidsPages(offsetObjPages);
        ArrayList<String> fonts = new ArrayList<String>();

        for (int i = 0; i < arr.size(); i++) {
            long offset = getOffsetObj(xref, arr.get(i));
            int objF = getObjFont(offset);
            offset = getOffsetObj(xref, objF);

            String font = getFontName(offset);
            if (!fonts.contains(font)) {
                fonts.add(font);
            }
        }

        //DATOS -OUTPUT
        String verisonPDf=getVersion();
        long size=getFileSize();
        int countPages = getCountPages(offsetObjPages);
        
        

        

        System.out.println("VERSION:"+verisonPDf);
        System.out.println("Peso:"+size);
        ReadData(offsetobjInfo);
        System.out.println("PAGINAS:"+countPages);
        System.out.println("FUENTES:");
        for (int j = 0; j < fonts.size(); j++) {
            System.out.println(fonts.get(j));
        }

    }

    public long getXref(long offset) {
        String offsetString = "";
        long offsetInicial = offset;
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            if (offset == -1) {
                offset = file.length() - 5;
                file.seek(offset);

            } else {
                offset = offset - 7;
                file.seek(offset);
            }
            // COMPRUEBA %%OEF

            byte EOF[] = new byte[5];
            file.read(EOF);
            if ("%%EOF".equals(new String(EOF))) {

                offset = file.getFilePointer() - 8;
                file.seek(offset);
                boolean OA = false;

                // Busca BYTE 0A
                while (!OA) {
                    byte byteB[] = new byte[1];
                    file.read(byteB);
                    if ("a".equals(Integer.toHexString(byteB[0]))) {
                        OA = true;
                    } else {
                        offset -= 1;
                    }

                    file.seek(offset);
                }
                file.seek(offset + 1);
                // Recorre hasta BYTE 0D
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

                offset = Long.parseLong(offsetString);
            } else {
                return offset + 7;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getXref(offset);
    }

    public int getInfoObj() {
        String obj = "";
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");

            long offset = file.length();
            file.seek(offset);
            boolean info = false;
            while (!info) {
                byte byteB[] = new byte[1];
                file.read(byteB);
                if ("/".equals(new String(byteB))) {
                    byte infoString[] = new byte[4];
                    file.read(infoString);
                    if ("Info".equals(new String(infoString))) {
                        file.read(byteB);
                        boolean isRead = false;
                        while (!isRead) {
                            file.read(byteB);
                            if ("20".equals(Integer.toHexString(byteB[0]))) {
                                isRead = true;
                            } else {
                                obj += new String(byteB);
                            }
                        }
                        info = true;
                    } else {
                        offset -= 4;
                    }

                } else {
                    offset -= 1;
                }
                file.seek(offset);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Integer.valueOf(obj);
    }

    public int getRootObj() {
        String obj = "";
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            long offset = file.length();
            file.seek(offset);
            boolean root = false;
            while (!root) {
                byte byteB[] = new byte[1];
                file.read(byteB);
                if ("/".equals(new String(byteB))) {
                    byte rootString[] = new byte[4];
                    file.read(rootString);
                    if ("Root".equals(new String(rootString))) {
                        file.read(byteB);
                        boolean isRead = false;
                        while (!isRead) {
                            file.read(byteB);
                            if ("20".equals(Integer.toHexString(byteB[0]))) {
                                isRead = true;
                            } else {
                                obj += new String(byteB);
                            }
                        }
                        root = true;
                    } else {
                        offset -= 4;
                    }

                } else {
                    offset -= 1;
                }
                file.seek(offset);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Integer.valueOf(obj);
    }

    public int getObjFont(long offset) {
        RandomAccessFile file;
        String objFont = "";
        try {
            file = new RandomAccessFile(path, "rw");
            file.seek(offset);
            boolean font = false;
            while (!font) {
                byte byteB[] = new byte[1];
                file.read(byteB);
                if ("/".equals(new String(byteB))) {
                    byte fontLabel[] = new byte[6];
                    file.read(fontLabel);
                    if ("Font<<".equals(new String(fontLabel))) {
                        font = true;
                        file.read();
                        file.read();
                        file.read();
                        file.read();
                        boolean isRead = false;
                        while (!isRead) {
                            file.read(byteB);
                            if ("20".equals(Integer.toHexString(byteB[0]))) {
                                isRead = true;
                            } else {
                                objFont += new String(byteB);
                            }
                        }
                    } else {
                        file.seek(file.getFilePointer() - 5);
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Integer.valueOf(objFont);

    }

    public int getObjPages(long offset) {
        RandomAccessFile file;
        String objString = "";
        try {
            file = new RandomAccessFile(path, "rw");
            file.seek(offset);
            boolean obj = false;

            while (!obj) {
                byte byteB[] = new byte[1];
                file.read(byteB);
                if ("/".equals(new String(byteB))) {
                    byte pagesString[] = new byte[5];
                    file.read(pagesString);

                    if ("Pages".equals(new String(pagesString))) {
                        obj = true;
                        file.read();
                        boolean isRead = false;
                        while (!isRead) {
                            file.read(byteB);
                            if ("20".equals(Integer.toHexString(byteB[0]))) {
                                isRead = true;
                            } else {
                                objString += new String(byteB);
                            }
                        }
                    } else {
                        file.seek(file.getFilePointer() - 4);
                    }

                }

            }


        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Integer.valueOf(objString);
    }

    public long getOffsetObj(long xref, int obj) {
        byte offsetObj[] = new byte[10];
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            xref += 6;
            file.seek(xref);
            int position = obj - startRange(xref);
            file.read();
            file.read();
            long offset = position * 20 + beforeObj(xref);
            file.seek(offset);
            file.read(offsetObj);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Long.valueOf(new String(offsetObj));
    }

    public boolean inRange(long offset, int obj) {
        boolean inRange = false;
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            file.seek(offset);
            boolean startRange = false;
            String startRangeString = "";
            while (!startRange) {

                byte byteB[] = new byte[1];
                file.read(byteB);
                if ("20".equals(Integer.toHexString(byteB[0]))) {
                    startRange = true;
                } else {
                    startRangeString += new String(byteB);
                }

            }

            boolean endRange = false;
            String endRangeString = "";
            while (!endRange) {

                byte byteB[] = new byte[1];
                file.read(byteB);
                if ("d".equals(Integer.toHexString(byteB[0]))) {
                    endRange = true;
                } else {
                    endRangeString += new String(byteB);
                }

            }

            if (obj >= Integer.valueOf(startRangeString) && obj <= Integer.valueOf(endRangeString)) {
                inRange = true;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return inRange;
    }

    public int startRange(long offset) {
        String startRangeString = "";
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            file.seek(offset);
            boolean startRange = false;
            while (!startRange) {

                byte byteB[] = new byte[1];
                file.read(byteB);
                if ("20".equals(Integer.toHexString(byteB[0]))) {
                    startRange = true;
                } else {
                    startRangeString += new String(byteB);
                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Integer.valueOf(startRangeString);
    }

    public long beforeObj(long offset) {
        boolean OA = false;
        try {
            RandomAccessFile file = new RandomAccessFile(this.path, "rw");
            file.seek(offset);
            while (!OA) {
                byte byteB[] = new byte[1];
                file.read(byteB);
                {
                    if ("a".equals(Integer.toHexString(byteB[0]))) {
                        OA = true;
                        offset = file.getFilePointer();
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

    public ArrayList<Integer> getKidsPages(long offset) {
        ArrayList<Integer> kidsList = new ArrayList<Integer>();
        String objKid = "";
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            file.seek(offset);
            boolean kids = false;
            while (!kids) {
                byte byteB[] = new byte[1];
                file.read(byteB);
                if ("/".equals(new String(byteB))) {
                    byte kidsLabel[] = new byte[5];
                    file.read(kidsLabel);
                    if ("Kids[".equals(new String(kidsLabel))) {
                        kids = true;
                        boolean isRead = false;
                        int i = 0;
                        while (!isRead) {
                            file.read(byteB);
                            if ("]".equals(new String(byteB))) {
                                isRead = true;
                            } else if ("20".equals(Integer.toHexString(byteB[0]))) {
                                i++;
                            }

                            if (i == 2) {
                                int x = Integer.parseInt(objKid.replace(" ", ""));
                                kidsList.add(x);
                                file.seek(file.getFilePointer() + 3);
                                i = 0;
                                objKid = "";
                            } else {
                                objKid += new String(byteB);

                            }
                        }
                    } else {
                        file.seek(file.getFilePointer() - 4);
                    }

                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kidsList;
    }

    public long getFileSize() {
        long sizeF;
        File file = new File(path);
        sizeF = file.length();
        return sizeF;
    }

    public String getVersion() {
        String obj = "";
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            long offset = 0;
            file.seek(offset);
            byte byteB[] = new byte[3];
            String line = file.readLine();
            obj = line.substring(5, 8);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public String getFontName(long offset) {
        String nameFont = "";
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            file.seek(offset);

            boolean font = false;
            while (!font) {
                byte byteB[] = new byte[1];
                file.read(byteB);
                if ("/".equals(new String(byteB))) {
                    byte baseFont[] = new byte[9];
                    file.read(baseFont);
                    if ("BaseFont/".equals(new String(baseFont))) {
                        font = true;
                        boolean isRead = false;
                        while (!isRead) {
                            file.read(byteB);
                            if ("/".equals(new String(byteB))) {
                                isRead = true;
                            } else {
                                nameFont += new String(byteB);
                            }
                        }
                    } else {
                        file.seek(file.getFilePointer() - 8);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return nameFont;
    }

    public void ReadData(long e) { // Leer infrmacion del PDF
        try {
            RandomAccessFile file = new RandomAccessFile(path, "r");

            boolean endobj = false;

            file.seek(e);

            while (!endobj) {
                String etiqueta = "";
                String data = "";
                byte info[] = new byte[1];
                file.read(info);

                if ("/".equals(new String(info))) {
                    boolean fin = false;

                    while (!fin) {

                        byte info_e[] = new byte[1];
                        file.read(info_e);

                        if ("(".equals(new String(info_e))) {
                            System.out.println("Etiqueta: " + etiqueta);
                            etiqueta += "|";
                            boolean fin2 = false;

                            while (!fin2) {
                                byte info_d[] = new byte[1];
                                file.read(info_d);

                                if (")".equals(new String(info_d))) {
                                    System.out.println("Data: " + data);
                                    data += "|";
                                    fin2 = true;

                                } else {
                                    data += new String(info_d);
                                }

                            }
                            fin = true;

                        } else {
                            etiqueta += new String(info_e);

                        }

                    }

                }

                if (">".equals(new String(info))) {

                    endobj = true;

                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getCountPages(long offset) {
        RandomAccessFile file;
        String countPages = "";
        try {
            file = new RandomAccessFile(path, "rw");
            file.seek(offset);
            boolean count = false;
            while (!count) {
                byte byteB[] = new byte[1];
                file.read(byteB);
                if ("/".equals(new String(byteB))) {
                    byte countString[] = new byte[5];
                    file.read(countString);
                    if ("Count".equals(new String(countString))) {
                        count = true;
                        file.read();
                        boolean isRead = false;
                        while (!isRead) {
                            file.read(byteB);
                            if ("/".equals(new String(byteB))) {
                                isRead = true;
                            } else {
                                countPages += new String(byteB);
                            }
                        }
                    } else {
                        file.seek(file.getFilePointer() - 4);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Integer.valueOf(countPages);

    }

}

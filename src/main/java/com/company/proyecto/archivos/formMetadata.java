/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.proyecto.archivos;

import java.awt.Component;
import java.awt.PopupMenu;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;

/**
 *
 * @author HP
 */
public class formMetadata extends javax.swing.JDialog {
    ArrayList<PDF> pdfs=new ArrayList<PDF>();

    /**
     * Creates new form formMetadata
     */
    public formMetadata(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Background = new javax.swing.JPanel();
        btnExplore = new javax.swing.JButton();
        btnSafe = new javax.swing.JButton();
        filesPanel = new javax.swing.JPanel();
        filesList = new java.awt.List();
        jScrollPane1 = new javax.swing.JScrollPane();
        metadataPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        versionLabel = new javax.swing.JLabel();
        sizeLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        versionField = new javax.swing.JTextField();
        sizeField = new javax.swing.JTextField();
        metadataLabel = new javax.swing.JLabel();
        pagesLabel = new javax.swing.JLabel();
        fontsLabel = new javax.swing.JLabel();
        imagesLabel = new javax.swing.JLabel();
        pagesField = new javax.swing.JTextField();
        fontsField = new javax.swing.JTextField();
        imagesField = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        subjectLabel = new javax.swing.JLabel();
        keywordsLabel = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        subjectField = new javax.swing.JTextField();
        keywordsField = new javax.swing.JTextField();
        authorLabel1 = new javax.swing.JLabel();
        creationdateLabel = new javax.swing.JLabel();
        moddateLabel = new javax.swing.JLabel();
        producerLabel = new javax.swing.JLabel();
        creatorLabel = new javax.swing.JLabel();
        authorField = new javax.swing.JTextField();
        creationdateField = new javax.swing.JTextField();
        moddateField = new javax.swing.JTextField();
        creatorField = new javax.swing.JTextField();
        producerField = new javax.swing.JTextField();
        btnChanges = new javax.swing.JButton();
        documentLabel = new javax.swing.JLabel();
        documentField = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Background.setBackground(new java.awt.Color(204, 204, 204));
        Background.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "LEER METADATOS PDF   ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 51, 255))); // NOI18N

        btnExplore.setBackground(new java.awt.Color(0, 51, 255));
        btnExplore.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnExplore.setForeground(new java.awt.Color(255, 255, 255));
        btnExplore.setText("EXPLORAR");
        btnExplore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExploreActionPerformed(evt);
            }
        });

        btnSafe.setBackground(new java.awt.Color(255, 255, 255));
        btnSafe.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSafe.setText("GUARDAR");
        btnSafe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSafeActionPerformed(evt);
            }
        });

        filesPanel.setBackground(new java.awt.Color(255, 255, 255));
        filesPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        filesList.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        filesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filesListMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout filesPanelLayout = new javax.swing.GroupLayout(filesPanel);
        filesPanel.setLayout(filesPanelLayout);
        filesPanelLayout.setHorizontalGroup(
            filesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filesList, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
        );
        filesPanelLayout.setVerticalGroup(
            filesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filesList, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
        );

        metadataPanel.setBackground(new java.awt.Color(255, 255, 255));
        metadataPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        nameLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(0, 0, 0));
        nameLabel.setText("Nombre:");

        versionLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        versionLabel.setForeground(new java.awt.Color(0, 0, 0));
        versionLabel.setText("Versión:");

        sizeLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        sizeLabel.setForeground(new java.awt.Color(0, 0, 0));
        sizeLabel.setText("Tamaño:");

        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameFieldKeyReleased(evt);
            }
        });

        versionField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                versionFieldKeyReleased(evt);
            }
        });

        sizeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sizeFieldKeyReleased(evt);
            }
        });

        metadataLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        metadataLabel.setForeground(new java.awt.Color(0, 0, 0));
        metadataLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        metadataLabel.setText("Metadatos:");

        pagesLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        pagesLabel.setForeground(new java.awt.Color(0, 0, 0));
        pagesLabel.setText("Paginas:");

        fontsLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fontsLabel.setForeground(new java.awt.Color(0, 0, 0));
        fontsLabel.setText("Fuentes:");

        imagesLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        imagesLabel.setForeground(new java.awt.Color(0, 0, 0));
        imagesLabel.setText("Imagenes:");

        pagesField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pagesFieldKeyReleased(evt);
            }
        });

        fontsField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fontsFieldKeyReleased(evt);
            }
        });

        imagesField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                imagesFieldKeyReleased(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setText("Titulo:");

        subjectLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        subjectLabel.setForeground(new java.awt.Color(0, 0, 0));
        subjectLabel.setText("Tema:");

        keywordsLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        keywordsLabel.setForeground(new java.awt.Color(0, 0, 0));
        keywordsLabel.setText("Palabras clave:");

        titleField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                titleFieldKeyReleased(evt);
            }
        });

        subjectField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                subjectFieldKeyReleased(evt);
            }
        });

        keywordsField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keywordsFieldKeyReleased(evt);
            }
        });

        authorLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        authorLabel1.setForeground(new java.awt.Color(0, 0, 0));
        authorLabel1.setText("Autor:");

        creationdateLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        creationdateLabel.setForeground(new java.awt.Color(0, 0, 0));
        creationdateLabel.setText("Fecha de creación:");

        moddateLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        moddateLabel.setForeground(new java.awt.Color(0, 0, 0));
        moddateLabel.setText("Fecha de modificación:");

        producerLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        producerLabel.setForeground(new java.awt.Color(0, 0, 0));
        producerLabel.setText("Programa productor:");

        creatorLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        creatorLabel.setForeground(new java.awt.Color(0, 0, 0));
        creatorLabel.setText("Programa creador:");

        authorField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                authorFieldKeyReleased(evt);
            }
        });

        creationdateField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                creationdateFieldKeyReleased(evt);
            }
        });

        moddateField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                moddateFieldKeyReleased(evt);
            }
        });

        creatorField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                creatorFieldKeyReleased(evt);
            }
        });

        producerField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                producerFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout metadataPanelLayout = new javax.swing.GroupLayout(metadataPanel);
        metadataPanel.setLayout(metadataPanelLayout);
        metadataPanelLayout.setHorizontalGroup(
            metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(metadataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addComponent(creationdateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(creationdateField))
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addComponent(producerLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(producerField))
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addComponent(subjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subjectField))
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addComponent(keywordsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keywordsField))
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addComponent(fontsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fontsField))
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addComponent(imagesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imagesField))
                    .addComponent(metadataLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addComponent(sizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sizeField))
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(versionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameField)
                            .addComponent(versionField)))
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addComponent(pagesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pagesField))
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleField))
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addComponent(authorLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(authorField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, metadataPanelLayout.createSequentialGroup()
                        .addComponent(moddateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moddateField, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addComponent(creatorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(creatorField)))
                .addGap(19, 19, 19))
        );
        metadataPanelLayout.setVerticalGroup(
            metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(metadataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameField)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(versionLabel)
                    .addComponent(versionField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sizeLabel)
                    .addComponent(sizeField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(metadataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(titleField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectLabel)
                    .addComponent(subjectField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keywordsLabel)
                    .addComponent(keywordsField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authorLabel1)
                    .addComponent(authorField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creationdateLabel)
                    .addComponent(creationdateField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moddateLabel)
                    .addComponent(moddateField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creatorLabel)
                    .addComponent(creatorField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(producerLabel)
                    .addComponent(producerField))
                .addGap(18, 18, 18)
                .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pagesLabel)
                    .addComponent(pagesField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fontsLabel)
                    .addComponent(fontsField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imagesLabel)
                    .addComponent(imagesField))
                .addGap(98, 98, 98))
        );

        jScrollPane1.setViewportView(metadataPanel);

        btnChanges.setBackground(new java.awt.Color(255, 255, 255));
        btnChanges.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnChanges.setText("APLICAR");
        btnChanges.setEnabled(false);
        btnChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangesActionPerformed(evt);
            }
        });

        documentLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        documentLabel.setForeground(new java.awt.Color(0, 0, 0));
        documentLabel.setText("Nombre del documento:");

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(filesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(documentLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                                .addComponent(btnChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSafe, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                                .addComponent(documentField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExplore, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExplore, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(documentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(documentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSafe, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public  void mostrarCarpeta(File fichero) {
        
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
                        
                        
                        
                        filesList.add(pdfs.get(i).getName());
                    }
                }
            }
        }
    }
   
    /**
     * Metodo para determinar si un fichero es extension PDF
     * @param name path del fichero
     * @return booleano si es PDF
     */
    public boolean isPDF(String name) {

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
    
    public void enableChangesButton() {
        if (!nameField.getText().isEmpty()) {
            btnChanges.setEnabled(true);
        }
        else {
            btnChanges.setEnabled(false);
        }
    }
    
    private void btnExploreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExploreActionPerformed
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int selection = filechooser.showOpenDialog(this);
        if (selection == JFileChooser.APPROVE_OPTION) {
            File file = filechooser.getSelectedFile();
            this.mostrarCarpeta(file);
        }
    }//GEN-LAST:event_btnExploreActionPerformed

    private void filesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filesListMouseClicked
        nameField.setText(pdfs.get(filesList.getSelectedIndex()).getName());
        versionField.setText(pdfs.get(filesList.getSelectedIndex()).getVersion());
        sizeField.setText(pdfs.get(filesList.getSelectedIndex()).getSize().toString());
        titleField.setText(pdfs.get(filesList.getSelectedIndex()).getMetadata().get("Title"));
        subjectField.setText(pdfs.get(filesList.getSelectedIndex()).getMetadata().get("Subject"));
        keywordsField.setText(pdfs.get(filesList.getSelectedIndex()).getMetadata().get("Keywords"));
        authorField.setText(pdfs.get(filesList.getSelectedIndex()).getMetadata().get("Author"));
        creationdateField.setText(pdfs.get(filesList.getSelectedIndex()).getMetadata().get("CreationDate"));
        moddateField.setText(pdfs.get(filesList.getSelectedIndex()).getMetadata().get("ModDate"));
        creatorField.setText(pdfs.get(filesList.getSelectedIndex()).getMetadata().get("Creator"));
        producerField.setText(pdfs.get(filesList.getSelectedIndex()).getMetadata().get("Producer"));
        pagesField.setText(Integer.toString(pdfs.get(filesList.getSelectedIndex()).getPages()));
        fontsField.setText(pdfs.get(filesList.getSelectedIndex()).getFonts().toString());
        imagesField.setText(Integer.toString(pdfs.get(filesList.getSelectedIndex()).getImages()));
    }//GEN-LAST:event_filesListMouseClicked

    private void btnSafeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSafeActionPerformed
        String name = documentField.getText();
        WriteBinaryFile write=new WriteBinaryFile(pdfs);
        write.writeFile(name);
    }//GEN-LAST:event_btnSafeActionPerformed

    private void btnChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangesActionPerformed
       HashMap<String, String> metadataMap = new HashMap<>();
       metadataMap.put("Title", titleField.getText());
       metadataMap.put("Subject", subjectField.getText());
       metadataMap.put("Keywords", keywordsField.getText());
       metadataMap.put("Author", authorField.getText());
       metadataMap.put("CreationDate", creationdateField.getText());
       metadataMap.put("ModDate", moddateField.getText());
       metadataMap.put("Creator", creationdateField.getText());
       metadataMap.put("Producer", producerField.getText());
        ArrayList<String> fontsList = new ArrayList<String>(Arrays.asList(fontsField.getText()));
        
        pdfs.get(filesList.getSelectedIndex()).setName(nameField.getText());
        pdfs.get(filesList.getSelectedIndex()).setVersion(versionField.getText());
        pdfs.get(filesList.getSelectedIndex()).setSize(Long.parseLong(sizeField.getText()));
        pdfs.get(filesList.getSelectedIndex()).setMetadata(metadataMap);
        pdfs.get(filesList.getSelectedIndex()).setPages(Integer.parseInt(pagesField.getText()));
        pdfs.get(filesList.getSelectedIndex()).setFonts(fontsList);
        pdfs.get(filesList.getSelectedIndex()).setImages(Integer.parseInt(imagesField.getText()));
    }//GEN-LAST:event_btnChangesActionPerformed

    private void nameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyReleased
        enableChangesButton();
    }//GEN-LAST:event_nameFieldKeyReleased

    private void versionFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_versionFieldKeyReleased
        enableChangesButton();
    }//GEN-LAST:event_versionFieldKeyReleased

    private void sizeFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sizeFieldKeyReleased
        enableChangesButton();
    }//GEN-LAST:event_sizeFieldKeyReleased

    private void titleFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_titleFieldKeyReleased
        enableChangesButton();
    }//GEN-LAST:event_titleFieldKeyReleased

    private void subjectFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subjectFieldKeyReleased
        enableChangesButton();
    }//GEN-LAST:event_subjectFieldKeyReleased

    private void keywordsFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keywordsFieldKeyReleased
        enableChangesButton();
    }//GEN-LAST:event_keywordsFieldKeyReleased

    private void authorFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_authorFieldKeyReleased
        enableChangesButton();
    }//GEN-LAST:event_authorFieldKeyReleased

    private void creationdateFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creationdateFieldKeyReleased
        enableChangesButton();
    }//GEN-LAST:event_creationdateFieldKeyReleased

    private void moddateFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moddateFieldKeyReleased
        enableChangesButton();
    }//GEN-LAST:event_moddateFieldKeyReleased

    private void creatorFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creatorFieldKeyReleased
        enableChangesButton();
    }//GEN-LAST:event_creatorFieldKeyReleased

    private void producerFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_producerFieldKeyReleased
        enableChangesButton();
    }//GEN-LAST:event_producerFieldKeyReleased

    private void pagesFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pagesFieldKeyReleased
        enableChangesButton();
    }//GEN-LAST:event_pagesFieldKeyReleased

    private void fontsFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fontsFieldKeyReleased
        enableChangesButton();
    }//GEN-LAST:event_fontsFieldKeyReleased

    private void imagesFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_imagesFieldKeyReleased
        enableChangesButton();
    }//GEN-LAST:event_imagesFieldKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formMetadata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formMetadata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formMetadata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formMetadata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                formMetadata dialog = new formMetadata(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JTextField authorField;
    private javax.swing.JLabel authorLabel1;
    private javax.swing.JButton btnChanges;
    private javax.swing.JButton btnExplore;
    private javax.swing.JButton btnSafe;
    private javax.swing.JTextField creationdateField;
    private javax.swing.JLabel creationdateLabel;
    private javax.swing.JTextField creatorField;
    private javax.swing.JLabel creatorLabel;
    private javax.swing.JTextField documentField;
    private javax.swing.JLabel documentLabel;
    private java.awt.List filesList;
    private javax.swing.JPanel filesPanel;
    private javax.swing.JTextField fontsField;
    private javax.swing.JLabel fontsLabel;
    private javax.swing.JTextField imagesField;
    private javax.swing.JLabel imagesLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField keywordsField;
    private javax.swing.JLabel keywordsLabel;
    private javax.swing.JLabel metadataLabel;
    private javax.swing.JPanel metadataPanel;
    private javax.swing.JTextField moddateField;
    private javax.swing.JLabel moddateLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField pagesField;
    private javax.swing.JLabel pagesLabel;
    private javax.swing.JTextField producerField;
    private javax.swing.JLabel producerLabel;
    private javax.swing.JTextField sizeField;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JTextField subjectField;
    private javax.swing.JLabel subjectLabel;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField versionField;
    private javax.swing.JLabel versionLabel;
    // End of variables declaration//GEN-END:variables
}

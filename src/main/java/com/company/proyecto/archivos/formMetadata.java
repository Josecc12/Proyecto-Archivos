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
        authorLabel = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        subjectField = new javax.swing.JTextField();
        authorField = new javax.swing.JTextField();

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

        btnSafe.setBackground(new java.awt.Color(204, 204, 204));
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

        titleLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setText("Titulo:");

        subjectLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        subjectLabel.setForeground(new java.awt.Color(0, 0, 0));
        subjectLabel.setText("Tema:");

        authorLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        authorLabel.setForeground(new java.awt.Color(0, 0, 0));
        authorLabel.setText("Autor:");

        javax.swing.GroupLayout metadataPanelLayout = new javax.swing.GroupLayout(metadataPanel);
        metadataPanel.setLayout(metadataPanelLayout);
        metadataPanelLayout.setHorizontalGroup(
            metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(metadataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addComponent(subjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subjectField, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(authorField, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addComponent(fontsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fontsField, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addComponent(imagesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imagesField, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                    .addComponent(metadataLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addComponent(sizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sizeField, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(versionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(metadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameField)
                            .addComponent(versionField, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)))
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addComponent(pagesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pagesField, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                    .addGroup(metadataPanelLayout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleField, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)))
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
                    .addComponent(authorLabel)
                    .addComponent(authorField))
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
                .addGap(202, 202, 202))
        );

        jScrollPane1.setViewportView(metadataPanel);

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnExplore, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSafe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(filesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)))
                .addContainerGap())
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addComponent(btnExplore, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSafe, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        authorField.setText(pdfs.get(filesList.getSelectedIndex()).getMetadata().get("Author"));
        pagesField.setText(Integer.toString(pdfs.get(filesList.getSelectedIndex()).getPages()));
        fontsField.setText(pdfs.get(filesList.getSelectedIndex()).getFonts().toString());
        imagesField.setText(Integer.toString(pdfs.get(filesList.getSelectedIndex()).getImages()));
    }//GEN-LAST:event_filesListMouseClicked

    private void btnSafeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSafeActionPerformed
        WriteBinaryFile write=new WriteBinaryFile(pdfs);
        write.writeFile();
    }//GEN-LAST:event_btnSafeActionPerformed

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
    private javax.swing.JLabel authorLabel;
    private javax.swing.JButton btnExplore;
    private javax.swing.JButton btnSafe;
    private java.awt.List filesList;
    private javax.swing.JPanel filesPanel;
    private javax.swing.JTextField fontsField;
    private javax.swing.JLabel fontsLabel;
    private javax.swing.JTextField imagesField;
    private javax.swing.JLabel imagesLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel metadataLabel;
    private javax.swing.JPanel metadataPanel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField pagesField;
    private javax.swing.JLabel pagesLabel;
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

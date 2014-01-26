/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JSpreadsheet.Package_26_1_2014;

import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;

/**
 *
 * @author remkoleene
 */
public class GUI extends javax.swing.JFrame {

    
    Model model = new Model();
    Model BGtable = new Model();
    Model Otable = new Model();
    Model ErrorTable = new Model();
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        fileChooser = new javax.swing.JFileChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        openTable = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MENU_OPEN = new javax.swing.JMenuItem();
        MENU_EXIT = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MENU_CLEAR = new javax.swing.JMenuItem();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(453, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );

        fileChooser.setDialogTitle("Choose a XML file to open");
        fileChooser.setFileFilter(new XMLfilter());

        openTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(openTable);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("C:/Users/Remko/Desktop/IconEggCell.gif").getImage());
        setMinimumSize(new java.awt.Dimension(480, 270));

        jTextField2.setMaximumSize(new java.awt.Dimension(140, 28));
        jTextField2.setMinimumSize(new java.awt.Dimension(140, 28));

        jTextField1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextField1PropertyChange(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextField3PropertyChange(evt);
            }
        });

        JTable rowTable = new RowNumberTable(jTable2);
        jScrollPane2.setRowHeaderView(rowTable);
        jScrollPane2.setCorner(JScrollPane.UPPER_LEFT_CORNER,
            rowTable.getTableHeader());
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "2", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}
            },
            new String [] {
                "          1", "          2", "          3", "          4", "          5", "          6", "          7", "          8", "          9", "         10", "         11", "         12", "         13", "         14", "         15", "         16"
            }
        ));
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable2.setCellSelectionEnabled(true);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jTable2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable2PropertyChange(evt);
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        MENU_OPEN.setText("Open");
        MENU_OPEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MENU_OPENActionPerformed(evt);
            }
        });
        jMenu1.add(MENU_OPEN);

        MENU_EXIT.setText("Exit");
        MENU_EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MENU_EXITActionPerformed(evt);
            }
        });
        jMenu1.add(MENU_EXIT);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        MENU_CLEAR.setText("Clear ALL");
        MENU_CLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MENU_CLEARActionPerformed(evt);
            }
        });
        jMenu2.add(MENU_CLEAR);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1))
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable2PropertyChange
    String errorMessage = "";
            for (int y = 0; y<jTable2.getColumnCount(); y++){
            for(int x = 0; x<jTable2.getRowCount(); x++){
                  if(!(((String)jTable2.getValueAt( x, y )).equals("#ERROR"))){
                        Otable.setContent(x, y, ((String)jTable2.getValueAt( x, y )));                
                   }
                  //Strings for the result and for the errormessage
                  String result = (String) ( Otable.cellReader(Otable.getContent(x, y)))[0];
                  errorMessage = (String) ( Otable.cellReader(Otable.getContent(x, y)))[1];
                  ErrorTable.setContent(x,y,errorMessage);
         
                  //Process cellcontents and functions, and set them in B(ack)G(round)Table
                  jTable2.setValueAt( result, x, y);
                  if (jTable2.getSelectedColumnCount() == 1 && jTable2.getSelectedRowCount() == 1 ){
                     jTextField3.setText((String) ErrorTable.getContent(jTable2.getSelectedRow(),jTable2.getSelectedColumn()));
                     jTextField1.setText((String) Otable.getContent(jTable2.getSelectedRow(),jTable2.getSelectedColumn()));
                    }  
            }
        }
         
            
        
    }//GEN-LAST:event_jTable2PropertyChange

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased

        if (jTable2.getSelectedColumnCount() == 1 && jTable2.getSelectedRowCount() == 1 ){

            jTextField2.setText("x" + (jTable2.getSelectedColumn() + 1) + "y" + (jTable2.getSelectedRow()+1));
            
        } else {
       
                jTextField2.setText("x" + (jTable2.getSelectedColumn()+1) + "y" + (jTable2.getSelectedRow()+1) + ":" + "x" + (jTable2.getSelectedColumn()+jTable2.getSelectedColumnCount()) + "y" + (jTable2.getSelectedRow()+jTable2.getSelectedRowCount()));      
                
        }
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        if (jTable2.getSelectedColumnCount() == 1 && jTable2.getSelectedRowCount() == 1 ){
                 jTextField1.setText((String) Otable.getContent(jTable2.getSelectedRow(),jTable2.getSelectedColumn()));
                 jTextField3.setText((String) ErrorTable.getContent(jTable2.getSelectedRow(),jTable2.getSelectedColumn()));
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextField1PropertyChange
         if (jTable2.getSelectedColumnCount() == 1 && jTable2.getSelectedRowCount() == 1 ){
             jTextField1.setText((String) Otable.getContent(jTable2.getSelectedRow(),jTable2.getSelectedColumn()));
         }
    }//GEN-LAST:event_jTextField1PropertyChange

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
       KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0 ,true);
    }//GEN-LAST:event_jTable2KeyPressed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void MENU_EXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MENU_EXITActionPerformed
    System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_MENU_EXITActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
  // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void MENU_CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MENU_CLEARActionPerformed
        
          for (int y = 0; y<jTable2.getColumnCount(); y++){
            for(int x = 0; x<jTable2.getRowCount(); x++){
                    jTable2.setValueAt("",x,y);
            }
          }
    }//GEN-LAST:event_MENU_CLEARActionPerformed

    private void MENU_OPENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MENU_OPENActionPerformed
         int returnVal = fileChooser.showOpenDialog(this);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        for (int y = 0; y<jTable2.getColumnCount(); y++){
            for(int x = 0; x<jTable2.getRowCount(); x++){
                    jTable2.setValueAt("",x,y);
            }
        }
          // What to do with the file, e.g. display it in a TextArea
          openTable.setModel(XMLParser.readXML(file.getAbsolutePath() ));
        for (int y = 0; y<openTable.getColumnCount(); y++){
            for(int x = 0; x<openTable.getRowCount(); x++){
                jTable2.setValueAt(openTable.getValueAt(x, y),x,y);
            }
          }
          
    } else {
        System.out.println("File access cancelled by user.");
    }  
    }//GEN-LAST:event_MENU_OPENActionPerformed

    private void jTextField3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextField3PropertyChange
           if (jTable2.getSelectedColumnCount() == 1 && jTable2.getSelectedRowCount() == 1 ){
                     jTextField3.setText((String) ErrorTable.getContent(jTable2.getSelectedRow(),jTable2.getSelectedColumn()));
           }          
             }//GEN-LAST:event_jTextField3PropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set th eNimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MENU_CLEAR;
    private javax.swing.JMenuItem MENU_EXIT;
    private javax.swing.JMenuItem MENU_OPEN;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable openTable;
    // End of variables declaration//GEN-END:variables


}

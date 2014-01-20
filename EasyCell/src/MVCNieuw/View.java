package MVCNieuw;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.spec.OAEPParameterSpec;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.util.ArrayList;


// VIEW START 

public class View extends javax.swing.JFrame {

    //components 
    private Model m_model;
    
    private Model data_model = XMLParser.readXML("spreadsheet.xml");
    
    //constructor (matisse prefers public)
    View(Model model) {
        m_model = model;
        initComponents();
    
    }
    
    public View() {
        initComponents();
    }
      
    
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField(32);
        jTextField2 = new javax.swing.JTextField(32);
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField3 = new javax.swing.JTextField(32);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemNEW = new javax.swing.JMenuItem();
        jMenuItemOPEN = new javax.swing.JMenuItem();
        jMenuItemSAVE = new javax.swing.JMenuItem();
        jMenuItemIMPORT = new javax.swing.JMenuItem();
        jMenuItemEXPORT = new javax.swing.JMenuItem();
        jMenuItemEXIT = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemUNDO = new javax.swing.JMenuItem();
        jMenuItemREDO = new javax.swing.JMenuItem();
        jMenuItemROW = new javax.swing.JMenuItem();
        jMenuItemCOLUMN = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemGENERATOR = new javax.swing.JMenuItem();
        jMenuItemMANIPULATOR = new javax.swing.JMenuItem();
        jMenuItemGRAPHING = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemTABLEHELP = new javax.swing.JMenuItem();
        jMenuItemFUNCTIONHELP = new javax.swing.JMenuItem();
        jMenuItemABOUT = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EGGcel V1.20.2014");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(480, 270));
        setPreferredSize(new java.awt.Dimension(960, 540));

        jTextField1.setText("X1Y1:X2Y2");

        jTextField2.setText("=SUM(X1Y1:X2Y2)");

        jTable1.setModel(data_model);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);

       
		jTextField3.setText(data_model.getContent(2, 2));
        jMenu1.setText("File");
        
        jMenuItemNEW.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemNEW.setText("New");
        jMenuItemNEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNEWActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemNEW);

        jMenuItemOPEN.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemOPEN.setText("Open");
        jMenu1.add(jMenuItemOPEN);

        jMenuItemSAVE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSAVE.setText("Save");
        jMenu1.add(jMenuItemSAVE);

        jMenuItemIMPORT.setText("Import XML");
        jMenu1.add(jMenuItemIMPORT);

        jMenuItemEXPORT.setText("Export XML");
        jMenuItemEXPORT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEXPORTActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemEXPORT);

        jMenuItemEXIT.setText("Exit");
        jMenu1.add(jMenuItemEXIT);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItemUNDO.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemUNDO.setText("Undo");
        jMenu2.add(jMenuItemUNDO);

        jMenuItemREDO.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemREDO.setText("Redo");
        jMenu2.add(jMenuItemREDO);

        jMenuItemROW.setText("Change Row Count");
        jMenu2.add(jMenuItemROW);

        jMenuItemCOLUMN.setText("Change Column Count");
        jMenu2.add(jMenuItemCOLUMN);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Table");

        jMenuItemGENERATOR.setText("Data Generator");
        jMenu3.add(jMenuItemGENERATOR);

        jMenuItemMANIPULATOR.setText("Data Manipulator");
        jMenu3.add(jMenuItemMANIPULATOR);

        jMenuItemGRAPHING.setText("Data Graphing");
        jMenu3.add(jMenuItemGRAPHING);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Help");

        jMenuItemTABLEHELP.setText("Table Help");
        jMenu4.add(jMenuItemTABLEHELP);

        jMenuItemFUNCTIONHELP.setText("Function Help");
        jMenu4.add(jMenuItemFUNCTIONHELP);

        jMenuItemABOUT.setText("About");
        jMenuItemABOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemABOUTActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemABOUT);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void jMenuItemNEWActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jMenuItemEXPORTActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void jMenuItemABOUTActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    // Variables declaration - do not modify                     
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemABOUT;
    private javax.swing.JMenuItem jMenuItemCOLUMN;
    private javax.swing.JMenuItem jMenuItemEXIT;
    private javax.swing.JMenuItem jMenuItemEXPORT;
    private javax.swing.JMenuItem jMenuItemFUNCTIONHELP;
    private javax.swing.JMenuItem jMenuItemGENERATOR;
    private javax.swing.JMenuItem jMenuItemGRAPHING;
    private javax.swing.JMenuItem jMenuItemIMPORT;
    private javax.swing.JMenuItem jMenuItemMANIPULATOR;
    private javax.swing.JMenuItem jMenuItemNEW;
    private javax.swing.JMenuItem jMenuItemOPEN;
    private javax.swing.JMenuItem jMenuItemREDO;
    private javax.swing.JMenuItem jMenuItemROW;
    private javax.swing.JMenuItem jMenuItemSAVE;
    private javax.swing.JMenuItem jMenuItemTABLEHELP;
    private javax.swing.JMenuItem jMenuItemUNDO;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration          
    
    
    //VIEW END ^^
    
    //CONTROLLER START vv
    
    
    
    
    
}

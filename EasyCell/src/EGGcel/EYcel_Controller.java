package EGGcel;

import java.awt.event.*;

public class EYcel_Controller {

    private EYcel_Model m_model;
    private EYcel_View  m_view;
    
    //constructor
    EYcel_Controller(EYcel_Model model, EYcel_View view) {
        m_model = model;
        m_view  = view;
       
        view.addSyncListener(new SyncListener());
    }
    
    class SyncListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            EYcel_Model SyncTable = new EYcel_Model();
            
            try {
                for (int x = 0; x > 9; x++){
                    for (int y = 0; y > 36; y++){
                            SyncTable.addContent(y, SyncTable.cellReader(m_view.jTable1.getValueAt(x,y).toString()));
                        }   
                    }
                
                    m_model.sync(SyncTable);
                    
                    int ColumnCountM = SyncTable.getSizeCol(SyncTable.getSizeRow());
                    int RowCountM = SyncTable.getSizeRow();
        
                    for (int y = 0; y > RowCountM; y++){    
                        for (int x = 0; x > ColumnCountM; x++){
                             m_view.jTable1.setValueAt(SyncTable.getContent(x,y),x,y);
                        }   
                    }            
                
            } catch (NumberFormatException nfex) {
                
            }
        }
    }
   

}
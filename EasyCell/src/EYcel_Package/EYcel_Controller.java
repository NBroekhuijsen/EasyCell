package EYcel_Package;

import java.awt.event.*;

public class EYcel_Controller {

    private EYcel_Model m_model;
    private EYcel_View  m_view;
    private EYcel_Table  m_table;
    
    //constructor
    EYcel_Controller(EYcel_Model model, EYcel_View view) {
        m_model = model;
        m_view  = view;
        
        view.addMultiplyListener(new MultiplyListener());
        view.addClearListener(new ClearListener());
        view.addRefreshListener(new RefreshListener());
    }
    
    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
                userInput = m_view.getUserInput();
                m_model.multiplyBy(userInput);
                m_view.setTotal(m_model.getValue());
                
            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }
    
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_model.reset();
            m_view.reset();
        }
    }
    
    class RefreshListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_model.refresh();
        }
    }

}
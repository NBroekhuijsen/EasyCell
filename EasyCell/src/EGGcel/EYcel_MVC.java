package EGGcel;

public class EYcel_MVC {
     
    public static void main(String[] args) {
        
        EYcel_Model      model      = new EYcel_Model();
        final EYcel_View       view       = new EYcel_View(model);
        EYcel_Controller controller = new EYcel_Controller(model, view);
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            view.setVisible(true);
            }
        });
    }
}

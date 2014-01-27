
package EGGcel_FINAL;

import java.io.File;

    class XMLfilter extends javax.swing.filechooser.FileFilter {
        @Override
        public boolean accept(File file) {
            // Allow only directories, or files with ".txt" extension
            return file.isDirectory() || file.getAbsolutePath().endsWith(".xml");
        }
        @Override
        public String getDescription() {
            // This description will be displayed in the dialog,
            // hard-coded = ugly, should be done via I18N
            return "XML files (*.xml)";
        }
    } 
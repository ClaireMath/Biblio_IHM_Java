import javax.swing.filechooser.FileFilter;
import java.io.File;

public class MyFilter extends FileFilter {

    public MyFilter() {

    }

    @Override
    public boolean accept(File f) {
        if (f.isDirectory() || f.getName().endsWith(".txt")) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String getDescription() {
        return "Fichiers texte (.txt)";
    }
}

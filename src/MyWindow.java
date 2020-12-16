import javax.swing.*;
import java.awt.*;

import static java.awt.Color.black;

public class MyWindow extends JFrame {
    public MyWindow() {
        super("Ma bibliothèque");
        setSize(900, 700);
        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setBackground(Color.lightGray);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu();
        menu.setText("Fichier");
        menu.add(menu);
        menu.setBackground(Color.gray);
        




    }



}

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.black;

public class MyWindow extends JFrame {
    public MyWindow() {
        super("Biblio.exe");
        setSize(900, 700);
        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setBackground(Color.lightGray);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuF = new JMenu();
        menuF.setText("File");
        menuBar.add(menuF);
        menuF.setBackground(Color.gray);
        JMenu menuO = new JMenu();
        menuO.setText("Open");
        menuF.add(menuO);
        JMenu menuE = new JMenu();
        menuE.setText("Edit");
        menuBar.add(menuE);
        menuE.setBackground(Color.gray);

        JMenu menuA = new JMenu();
        menuA.setText("About");
        menuBar.add(menuA);
        menuA.setBackground(Color.gray);





    }



}

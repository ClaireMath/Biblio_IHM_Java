import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import static java.awt.Color.black;

public class MyWindow extends JFrame {
    public MyWindow() {
        super("Biblio.exe");
        this.setSize(900, 700);
        JPanel panel = new JPanel();
        this.setContentPane(panel);
        panel.setBackground(Color.lightGray);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        menuO.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new MyFilter());
                int dialog = fileChooser.showDialog(panel, "Ouvrir");
                if (dialog == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    System.out.println(file.getName() + " a été ouvert");
                }
                else {
                    System.out.println("Action annulée");
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
}

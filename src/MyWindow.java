import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Arrays;

import static java.awt.Color.black;

public class MyWindow extends JFrame {
    public MyWindow() {
        super("Ma bibliothèque");
        this.setSize(900, 700);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        this.setContentPane(panel);
        panel.setBackground(Color.lightGray);
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu menu = new JMenu();
        menu.setText("Fichier");
        menuBar.add(menu);
        menu.setBackground(Color.gray);

        GridBagLayout monLayout = new GridBagLayout();
        panel.setLayout(monLayout);

        GridBagConstraints gbc = new GridBagConstraints();

        // TABLEAU

        Object[][] donnee = {
                {"Harry Potter", "J.K Rowling", "Voldemor meurt !", 5, 2, 2009},
                {"Eragon", "C. Paolini", "Un monde de dragon", 2, 2, 2000}
        };
        String[] entetes = {"Titre", "Auteur", "Résumé", "Colonne", "Rangée", "Parution"};

        JTable tableau = new JTable(donnee, entetes);
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.gridwidth = 1;
        gbc.gridheight = 1;



        panel.add(tableau.getTableHeader(), gbc);




        gbc.gridx = 0;
        gbc.gridy = 1;

        panel.add(tableau, gbc);


        pack();
        




    }



}

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
        menuBar.add(menu);
        menu.setBackground(Color.gray);
        
        //FORM

        //GridBagLayout
        GridBagLayout monLayout = new GridBagLayout();
        panel.setLayout(monLayout);
        GridBagConstraints gbc = new GridBagConstraints();

        //Titre
        JLabel label = new JLabel("Titre :");
        gbc.gridy = 0;
        panel.add(label, gbc);

        JTextField textFieldTitle = new JTextField();
        textFieldTitle.setPreferredSize(new Dimension(100, 20));
        gbc.gridy = 0;
        panel.add(textFieldTitle, gbc);

        //Author
        JLabel labelAuthor = new JLabel("Auteur :");
        gbc.gridy = 1;
        panel.add(labelAuthor, gbc);

        JTextField textFieldAuthor = new JTextField();
        textFieldAuthor.setPreferredSize(new Dimension(100, 20));
        gbc.insets = new Insets(20, 10 , 0, 0);
        gbc.gridy = 1;
        panel.add(textFieldAuthor, gbc);

        //Parution
        JLabel labelParution = new JLabel("Parution :");
        gbc.gridy = 2;
        panel.add(labelParution, gbc);

        JTextField textFieldParution = new JTextField();
        textFieldParution.setPreferredSize(new Dimension(100, 20));
        gbc.insets = new Insets(20, 10 , 0, 0);
        gbc.gridy = 2;
        panel.add(textFieldParution, gbc);

        //Colonne
        JLabel labelColumn = new JLabel("Colonne :");
        gbc.gridy = 3;
        panel.add(labelColumn, gbc);

        JTextField textFieldColumn = new JTextField();
        textFieldColumn.setPreferredSize(new Dimension(100, 20));
        gbc.insets = new Insets(20, 10 , 0, 0);
        gbc.gridy = 3;
        panel.add(textFieldColumn, gbc);

        //Rangée
        JLabel labelRangee = new JLabel("Rangée :");
        gbc.gridy = 4;
        panel.add(labelRangee, gbc);

        JTextField textFieldRangee = new JTextField();
        textFieldRangee.setPreferredSize(new Dimension(100, 20));
        gbc.insets = new Insets(20, 10 , 0, 0);
        gbc.gridy = 4;
        panel.add(textFieldRangee, gbc);

        //Résumé
        JLabel labelResume = new JLabel("Résumé :");
        gbc.gridy = 5;
        panel.add(labelResume, gbc);

        JTextArea textAreaResume = new JTextArea();
        textAreaResume.setPreferredSize(new Dimension(100, 50));
        gbc.insets = new Insets(20, 10 , 0, 0);
        gbc.gridy = 5;
        panel.add(textAreaResume, gbc);

        //Bouton Valider
        JButton monButton = new JButton("Valider");
        gbc.insets = new Insets(20, 10 , 0, 0);
        gbc.gridy = 6;
        gbc.gridx = 1;
        panel.add(monButton, gbc);
    }



}

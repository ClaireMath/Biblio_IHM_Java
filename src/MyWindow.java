import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

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

        /* File Menu and its sub-menus */
        JMenu menuF = new JMenu();
        menuF.setText("Fichier");
        menuBar.add(menuF);
        menuF.setBackground(Color.gray);
        JMenuItem menuO = new JMenuItem();
        menuO.setText("Ouvrir");
        menuF.add(menuO);
        JMenuItem menuNew = new JMenuItem();
        menuNew.setText("Nouveautés");
        menuF.add(menuNew);
        JMenuItem menuStats = new JMenuItem();
        menuStats.setText("Statistiques");
        menuF.add(menuStats);


        JMenuItem menuQ = new JMenuItem();
        menuQ.setText("Quitter");
        menuF.add(menuQ);
        menuQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        /* Edit Menu */
        JMenu menuE = new JMenu();
        menuE.setText("Editer");
        menuBar.add(menuE);
        menuE.setBackground(Color.gray);
        JMenuItem menuRaz = new JMenuItem();
        menuRaz.setText("RAZ");
        menuE.add(menuRaz);

        /* About menu */
        JMenu menuA = new JMenu();
        menuA.setText("A propos");
        menuBar.add(menuA);
        menuA.setBackground(Color.gray);

        menuA.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(panel, "Vous utilisez actuellement la version " +
                        "1.0 de l'application Bibliothèque.exe créée par Christopher, " +
                        "Nohan, Axel et Claire.");
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

        menuNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Voici la liste des nouveautés, parues à partir de 2018.");
            }
        });

        menuRaz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        menuStats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Voici la liste des livres qui ont pour deuxième lettre dans leur titre la lettre A.");

            }
        });

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

        //FORM

        //GridBagLayout
        GridBagLayout monLayout = new GridBagLayout();
        panel.setLayout(monLayout);
        // GridBagConstraints gbc = new GridBagConstraints();

        //Titre
        JLabel label = new JLabel("Titre :");
        gbc.insets = new Insets(20, 10, 0, 0);
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(label, gbc);

        JTextField textFieldTitle = new JTextField();
        textFieldTitle.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 3;
        gbc.gridy = 0;
        panel.add(textFieldTitle, gbc);

        //Author
        JLabel labelAuthor = new JLabel("Auteur :");
        gbc.insets = new Insets(20, 10, 0, 0);
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(labelAuthor, gbc);

        JTextField textFieldAuthor = new JTextField();
        textFieldAuthor.setPreferredSize(new Dimension(100, 20));
        gbc.insets = new Insets(20, 10, 0, 0);
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(textFieldAuthor, gbc);

        //Parution
        JLabel labelParution = new JLabel("Parution :");
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(labelParution, gbc);

        JTextField textFieldParution = new JTextField();
        textFieldParution.setPreferredSize(new Dimension(100, 20));
        gbc.insets = new Insets(20, 10, 0, 0);
        gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(textFieldParution, gbc);

        //Colonne
        JLabel labelColumn = new JLabel("Colonne :");
        gbc.gridx = 2;
        gbc.gridy = 3;
        panel.add(labelColumn, gbc);

        JTextField textFieldColumn = new JTextField();
        textFieldColumn.setPreferredSize(new Dimension(100, 20));
        gbc.insets = new Insets(20, 10, 0, 0);
        gbc.gridx = 3;
        gbc.gridy = 3;
        panel.add(textFieldColumn, gbc);

        //Rangée
        JLabel labelRangee = new JLabel("Rangée :");
        gbc.gridx = 2;
        gbc.gridy = 4;
        panel.add(labelRangee, gbc);

        JTextField textFieldRangee = new JTextField();
        textFieldRangee.setPreferredSize(new Dimension(100, 20));
        gbc.insets = new Insets(20, 10, 0, 0);
        gbc.gridx = 3;
        gbc.gridy = 4;
        panel.add(textFieldRangee, gbc);

        //Résumé
        JLabel labelResume = new JLabel("Résumé :");
        gbc.gridx = 2;
        gbc.gridy = 5;
        panel.add(labelResume, gbc);

        JTextArea textAreaResume = new JTextArea();
        textAreaResume.setPreferredSize(new Dimension(100, 50));
        gbc.insets = new Insets(20, 10, 0, 0);
        gbc.gridx = 3;
        gbc.gridy = 5;
        panel.add(textAreaResume, gbc);

        //Bouton Valider
        JButton monButton = new JButton("Valider");
        gbc.insets = new Insets(20, 10, 0, 0);
        gbc.gridx = 3;
        gbc.gridy = 6;
        panel.add(monButton, gbc);

        // Fenetre Ouvrir un fichier
        menuO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new MyFilter());
                int dialog = fileChooser.showDialog(panel, "Ouvrir");
                if (dialog == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    Desktop desktop = Desktop.getDesktop();
                    if (file.exists()) {
                        try {
                            desktop.open(file.getAbsoluteFile());
                            System.out.println(file.getName() + " a été ouvert");
                            System.out.println("Le chemin complet du fichier est : " + file.getAbsolutePath());
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                } else {
                    System.out.println("Action annulée");
                }
            }
        });

        // Ecoute bouton valider
        monButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}

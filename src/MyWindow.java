import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

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
                JOptionPane.showMessageDialog(panel, "Version : 1.0 \nProgrammeurs : Christopher, " +
                        "Nohan, Axel et Claire");
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
                List<String> motAvecA = new ArrayList<>();
                String[] testSplit = {"tata", "toto", "tate", "test", "taboule" };

                for (String mot : testSplit) {
                    String[] split = mot.split("");
                    if(split[1].equals("a")) {
                        motAvecA.add(mot);
                    }
                }
                JOptionPane.showMessageDialog(panel, "Voici la liste des livres qui ont pour deuxième lettre dans leur titre la lettre A.\n" + motAvecA);
            }
        });

        //GridBagLayout
        GridBagLayout monLayout = new GridBagLayout();
        panel.setLayout(monLayout);
        GridBagConstraints gbc = new GridBagConstraints();

        // TABLEAU
        String[] entetes = {"Titre", "Auteur", "Résumé", "Colonne", "Rangée", "Parution"};

        Bibliotheque biblio = new Bibliotheque();
        DefaultTableModel model = new DefaultTableModel(biblio.getDonnee(), entetes);
        JTable tableau = new JTable(model);

        tableau.getTableHeader().setFont(new Font("Tahome", Font.BOLD, 14));
        gbc.insets = new Insets(20, 0, 0, 50);
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        panel.add(tableau.getTableHeader(), gbc);

        gbc.insets = new Insets(0, 0, 0, 50);
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        panel.add(tableau, gbc);

        // Bouton Ajouter
        Icon iconAdd = new ImageIcon("img/add.jpg");
        JButton addButton = new JButton(iconAdd);
        addButton.setPreferredSize(new Dimension(37, 37));
        addButton.setBorderPainted(false);

        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panel.add(addButton);

        // Bouton Supprimer
        Icon iconDel = new ImageIcon("img/del.jpg");
        JButton delButton = new JButton(iconDel);
        delButton.setPreferredSize(new Dimension(37, 37));
        delButton.setBorderPainted(false);

        panel.add(delButton);

        //FORM
        //Titre
        JLabel label = new JLabel("Titre :");
        gbc.insets = new Insets(20, 10, 0, 0);
        gbc.gridx = 3;
        gbc.gridy = 0;

        panel.add(label, gbc);

        JTextField textFieldTitle = new JTextField();
        textFieldTitle.setEnabled(false);
        textFieldTitle.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 4;
        gbc.gridy = 0;
        panel.add(textFieldTitle, gbc);

        //Author
        JLabel labelAuthor = new JLabel("Auteur :");
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(labelAuthor, gbc);

        JTextField textFieldAuthor = new JTextField();
        textFieldAuthor.setEnabled(false);
        textFieldAuthor.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 4;
        gbc.gridy = 1;
        panel.add(textFieldAuthor, gbc);

        //Parution
        JLabel labelParution = new JLabel("Parution :");
        gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(labelParution, gbc);

        JTextField textFieldParution = new JTextField();
        textFieldParution.setEnabled(false);
        textFieldParution.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 4;
        gbc.gridy = 2;
        panel.add(textFieldParution, gbc);

        //Colonne
        JLabel labelColumn = new JLabel("Colonne :");
        gbc.gridx = 3;
        gbc.gridy = 3;
        panel.add(labelColumn, gbc);

        JTextField textFieldColumn = new JTextField();
        textFieldColumn.setEnabled(false);
        textFieldColumn.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 4;
        gbc.gridy = 3;
        panel.add(textFieldColumn, gbc);

        //Rangée
        JLabel labelRangee = new JLabel("Rangée :");
        gbc.gridx = 3;
        gbc.gridy = 4;
        panel.add(labelRangee, gbc);

        JTextField textFieldRangee = new JTextField();
        textFieldRangee.setEnabled(false);
        textFieldRangee.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 4;
        gbc.gridy = 4;
        panel.add(textFieldRangee, gbc);

        //Résumé
        JLabel labelResume = new JLabel("Résumé :");
        gbc.gridx = 3;
        gbc.gridy = 5;
        panel.add(labelResume, gbc);

        JTextArea textAreaResume = new JTextArea();
        textAreaResume.setEnabled(false);
        textAreaResume.setPreferredSize(new Dimension(100, 50));
        gbc.gridx = 4;
        gbc.gridy = 5;
        panel.add(textAreaResume, gbc);

        //Bouton Valider
        JButton monButton = new JButton("Valider");
        monButton.setEnabled(false);
        gbc.gridx = 4;
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
                            JOptionPane.showMessageDialog(panel, file.getAbsolutePath());
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                } else {
                    System.out.println("Action annulée");
                }
            }
        });

        int curYear = Calendar.getInstance().get(Calendar.YEAR);

        // Ecoute bouton valider
        monButton.addActionListener(new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (curYear < (Integer.parseInt(textFieldParution.getText()))) {
                    JOptionPane.showMessageDialog(panel, "Veuillez entrer une date de parution valide.");
                }
                else if (Integer.parseInt(textFieldColumn.getText()) <= 0 || Integer.parseInt(textFieldColumn.getText()) > 5) {
                    JOptionPane.showMessageDialog(panel, "Veuillez entrer une colonne comprise entre 1 et 5.");
                }
                else if (Integer.parseInt(textFieldRangee.getText()) <= 0 || Integer.parseInt(textFieldRangee.getText()) > 7) {
                    JOptionPane.showMessageDialog(panel, "Veuillez entrer une rangée comprise entre 1 et 7.");
                }
                else {
                    System.out.println("Tout va bien");
                    biblio.add(textFieldTitle.getText(), textFieldAuthor.getText(), textAreaResume.getText(),
                            Integer.parseInt(textFieldColumn.getText()), Integer.parseInt(textFieldRangee.getText()),
                            Integer.parseInt(textFieldParution.getText()));

                    model.addRow(biblio.getListLivre().get(i++));
//                    i++;
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldTitle.setEnabled(true);
                textFieldAuthor.setEnabled(true);
                textFieldParution.setEnabled(true);
                textFieldColumn.setEnabled(true);
                textFieldRangee.setEnabled(true);
                textAreaResume.setEnabled(true);
                monButton.setEnabled(true);
            }
        });
    }
}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class MyWindow extends JFrame {

    private boolean isNewForm = true;
    private boolean isFocus = false;

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

        /**
         * Instanciation d'un écouteur d'évènement utilisé sur le menu Quitter
         */
        menuQ.addActionListener(new ActionListener() {
            @Override
            /**
             * Méthode qui stoppe le programme au clic du sous-menu quitter
             */
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
        /**
         * Instanciation d'un écouteur d'évènement utilisé sur le menu A propos
         */
        menuA.addMouseListener(new MouseListener() {
            @Override
            /**
             * Méthode permettant d'afficher un message informant de la version et des personnes responsables de l'appli
             */
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

        //GridBagLayout
        GridBagLayout monLayout = new GridBagLayout();
        panel.setLayout(monLayout);
        GridBagConstraints gbc = new GridBagConstraints();

        // TABLEAU
        String[] entetes = {"Titre", "Auteur", "Résumé", "Colonne", "Rangée", "Parution"};

        Bibliotheque biblio = new Bibliotheque();
        DefaultTableModel model = new DefaultTableModel(biblio.getDonnee(), entetes);
        JTable tableau = new JTable(model) {
            @Override
            /**
             * Fonction (car on a un return) permettant d'afficher une ligne du tableau sur deux en gris au lieu du blanc
             */
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component comp = super.prepareRenderer(renderer, row, column);
                comp.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
                return comp;
            }
        };
        tableau.getTableHeader().setFont(new Font("Tahome", Font.BOLD, 14));
        gbc.insets = new Insets(20, 0, 0, 50);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        panel.add(tableau.getTableHeader(), gbc);

        gbc.insets = new Insets(0, 0, 0, 50);
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.gridheight = 7;
        gbc.anchor = GridBagConstraints.NORTH;
        panel.add(tableau, gbc);

        // Bouton Ajouter
        Icon iconAdd = new ImageIcon("img/add.jpg");
        JButton addButton = new JButton(iconAdd);
        addButton.setPreferredSize(new Dimension(37, 37));
        addButton.setBorderPainted(false);
        gbc.insets = new Insets(0, 180, 0, 0);

        gbc.gridx = 0;
        gbc.gridy = 8;

        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panel.add(addButton, gbc);

        // Bouton Supprimer
        Icon iconDel = new ImageIcon("img/del.jpg");
        JButton delButton = new JButton(iconDel);
        delButton.setPreferredSize(new Dimension(37, 37));
        delButton.setBorderPainted(false);
        gbc.insets = new Insets(0, 0, 0, 230);

        gbc.gridx = 1;
        panel.add(delButton, gbc);

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

        ArrayList<JTextComponent> elements = new ArrayList();
        elements.add(textFieldTitle);
        elements.add(textFieldAuthor);
        elements.add(textFieldParution);
        elements.add(textFieldColumn);
        elements.add(textFieldRangee);
        elements.add(textAreaResume);

        // Fenetre Ouvrir un fichier
        /**
         * Instanciation d'un écouteur d'évènement utilisé sur le menu Ouvrir
         */
        menuO.addActionListener(new ActionListener() {
            @Override
            /**
             * Méthode (car ne retourne rien, d'où le void), permettant l'affichage d'une fenêtre filechooser
             * à laquelle on applique un filtre afin de n'afficher que les fichiers .txt
             */
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

        biblio.add("Harry Potter", "J.K Rowling", "Voldemort meurt", "5", "3", "2009");
        model.addRow(biblio.getListLivre().get(tableau.getRowCount()));

        // Ecoute bouton valider
        /**
         * Instanciation d'un écouteur d'évènement utilisé sur le bouton Valider
         */
        monButton.addActionListener(new ActionListener() {
            /**
             * Méthode permettant de vérifier que l'année de parution entrée dans le champs du formulaire est valide,
             * ainsi que la colone et rangée entrée, si la vérification est ok,
             * on ajoute les champs dans le tableau et dans notre listLivres
             * puis on désactive les champs du formulaire
             */
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
                    if(isNewForm) {
                        biblio.add(textFieldTitle.getText(), textFieldAuthor.getText(), textAreaResume.getText(),
                                textFieldColumn.getText(), textFieldRangee.getText(), textFieldParution.getText());

                        model.addRow(biblio.getListLivre().get(tableau.getRowCount()));
                        emptyForm(elements);
                        disableForm(elements, monButton);
                    }
                    else {
                        isFocus = false;
                        for (int i = 0; i < biblio.getListLivre().size(); i++) {
                            if (tableau.getValueAt(tableau.getSelectedRow(), 0).equals(biblio.getListLivre().get(i)[0])) {
                                tableau.setValueAt(elements.get(0).getText(), tableau.getSelectedRow(), 0);
                                tableau.setValueAt(elements.get(1).getText(), tableau.getSelectedRow(), 1);
                                tableau.setValueAt(elements.get(2).getText(), tableau.getSelectedRow(), 5);
                                tableau.setValueAt(elements.get(3).getText(), tableau.getSelectedRow(), 3);
                                tableau.setValueAt(elements.get(4).getText(), tableau.getSelectedRow(), 4);
                                tableau.setValueAt(elements.get(5).getText(), tableau.getSelectedRow(), 2);

                                biblio.getListLivre().remove(i);
                                biblio.add(textFieldTitle.getText(), textFieldAuthor.getText(), textAreaResume.getText(),
                                        textFieldColumn.getText(), textFieldRangee.getText(), textFieldParution.getText());

                                emptyForm(elements);
                                disableForm(elements, monButton);
                                isNewForm = true;
                                break;
                            }
                        }
                    }
                }
            }
        });

        // Ecoute Tableau
        tableau.addFocusListener(new FocusListener() {
            /**
             * Méthode permettant de vérifier si on a le focus sur le tableau
             * @param e notre évènement
             */
            @Override
            public void focusGained(FocusEvent e) {
                isFocus = true;
                isNewForm = false;
                enableForm(elements);
                tableau.addMouseListener(new MouseListener() {
                    /**
                     * Récupération des éléments du tableau pour les mettre dans les champs du formulaire
                     * @param e
                     */
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        monButton.setEnabled(true);
                        elements.get(0).setText((String) tableau.getValueAt(tableau.getSelectedRow(), 0));
                        elements.get(1).setText((String) tableau.getValueAt(tableau.getSelectedRow(), 1));
                        elements.get(2).setText((String) tableau.getValueAt(tableau.getSelectedRow(), 5));
                        elements.get(3).setText((String) tableau.getValueAt(tableau.getSelectedRow(), 3));
                        elements.get(4).setText((String) tableau.getValueAt(tableau.getSelectedRow(), 4));
                        elements.get(5).setText((String) tableau.getValueAt(tableau.getSelectedRow(), 2));
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

            @Override
            public void focusLost(FocusEvent e) {
                isFocus = false;
            }
        });

        // Ecoute menu Stats
        menuStats.addActionListener(new ActionListener() {
            /**
             * Méthode permettant de trouver tous les titres ayant un a en deuxième lettre et
             * de les afficher dans une fenêtre de message
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> motAvecA = new ArrayList<>();
                if(biblio.getListLivre().size() != 0) {
                    for (int i = 0; i < biblio.getListLivre().size() ; i++) {
                        String title = (String) biblio.getListLivre().get(i)[0];
                        if (title.split("")[1].equals("a")) {
                            motAvecA.add(title);
                        }
                    }
                    if(motAvecA.size() != 0) {
                        JOptionPane.showMessageDialog(panel, "Voici la liste des livres qui ont pour deuxième lettre dans leur titre la lettre A.\n" + motAvecA);
                    }
                    else {
                        JOptionPane.showMessageDialog(panel, "Aucun livre ayant pour deuxième lettre un A n'a été trouvé");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(panel, "Aucun livre ayant pour deuxième lettre un A n'a été trouvé");
                }
            }
        });

        menuNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> yearSupp2008 = new ArrayList<>();
                if(biblio.getListLivre().size() != 0) {
                    for (int i = 0; i < biblio.getListLivre().size() ; i++) {
                        int year = Integer.parseInt((String) biblio.getListLivre().get(i)[5]);
                        if (year >= 2008) {
                            yearSupp2008.add("Titre : " + biblio.getListLivre().get(i)[0] + ", Auteur : " + biblio.getListLivre().get(i)[1] + "\n");
                        }
                    }
                    JOptionPane.showMessageDialog(panel, "Voici la liste des livres qui sont sortis depuis 2008 : \n" + yearSupp2008);
                }
                else {
                    JOptionPane.showMessageDialog(panel, "Aucun livre dont l'année est supérieur à 2008 n'a été trouvé");
                }
            }
        });

        // Ecoute bouton ajouter
        addButton.addActionListener(new ActionListener() {
            /**
             * Au clic du bouton ajouter, les champs du formulaire sont vidés et réactivés
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                isNewForm = true;
                emptyForm(elements);
                enableForm(elements);
                monButton.setEnabled(true);
            }
        });

        // Ecoute bouton supprimer
        delButton.addActionListener(new ActionListener() {
            /**
             * au clic du bouton supprimer, la méthode va vérifier si une ligne est selectionnée, si ce
             * n'est pas le cas, une fenêtre de message s'affiche indiquant qu'aucune ligne n'a été selectionnée
             * sinon suppression de la ligne selectionnée.
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowSelected = tableau.getSelectedRow();
                if (rowSelected == -1) {
                    JOptionPane.showMessageDialog(panel, "Aucune ligne n'a été sélectionnée.");
                } else {
                    for (int i = 0; i < biblio.getListLivre().size(); i++) {
                        if (tableau.getValueAt(tableau.getSelectedRow(), 0).equals(biblio.getListLivre().get(i)[0])) {
                            biblio.getListLivre().remove(i);
                        }
                    }
                    model.removeRow(tableau.getSelectedRow());
                    emptyForm(elements);
                    disableForm(elements, monButton);
                }
            }
        });

        menuRaz.addActionListener(new ActionListener() {
            /**
             * Méthode permettant d'affacer tous mes livres
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                while (tableau.getRowCount() != 0) {
                    for (int i = 0; i < biblio.getListLivre().size(); i++) {
                        biblio.getListLivre().remove(i);
                    }
                    model.removeRow(0);
                    disableForm(elements, monButton);
                }
            }
        });
    }

    /**
     * Méthode permettant de vider les champs de mon formulaire
     * @param elements
     */
    public void emptyForm(ArrayList<JTextComponent> elements) {
        for (JTextComponent element : elements) {
            element.setText(null);
        }
    }

    /**
     * Méthode permettant d'activer les champs du formulaire
     * @param elements
     */
    public void enableForm(ArrayList<JTextComponent> elements) {
        for (JTextComponent element : elements) {
            element.setEnabled(true);
        }
    }
    /**
     * Méthode permettant la désactivation des champs du formulaire
     * @param elements
     */
    public void disableForm(ArrayList<JTextComponent> elements, JButton monButton) {
        for (JTextComponent element : elements) {
            element.setEnabled(false);
        }
        monButton.setEnabled(false);
    }
}

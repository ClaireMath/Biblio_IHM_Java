import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

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
        JMenuItem menuO = new JMenuItem();
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
        gbc.insets = new Insets(20, 10, 0, 0);
        gbc.gridy = 1;
        panel.add(textFieldAuthor, gbc);

        //Parution
        JLabel labelParution = new JLabel("Parution :");
        gbc.gridy = 2;
        panel.add(labelParution, gbc);

        JTextField textFieldParution = new JTextField();
        textFieldParution.setPreferredSize(new Dimension(100, 20));
        gbc.insets = new Insets(20, 10, 0, 0);
        gbc.gridy = 2;
        panel.add(textFieldParution, gbc);

        //Colonne
        JLabel labelColumn = new JLabel("Colonne :");
        gbc.gridy = 3;
        panel.add(labelColumn, gbc);

        JTextField textFieldColumn = new JTextField();
        textFieldColumn.setPreferredSize(new Dimension(100, 20));
        gbc.insets = new Insets(20, 10, 0, 0);
        gbc.gridy = 3;
        panel.add(textFieldColumn, gbc);

        //Rangée
        JLabel labelRangee = new JLabel("Rangée :");
        gbc.gridy = 4;
        panel.add(labelRangee, gbc);

        JTextField textFieldRangee = new JTextField();
        textFieldRangee.setPreferredSize(new Dimension(100, 20));
        gbc.insets = new Insets(20, 10, 0, 0);
        gbc.gridy = 4;
        panel.add(textFieldRangee, gbc);

        //Résumé
        JLabel labelResume = new JLabel("Résumé :");
        gbc.gridy = 5;
        panel.add(labelResume, gbc);

        JTextArea textAreaResume = new JTextArea();
        textAreaResume.setPreferredSize(new Dimension(100, 50));
        gbc.insets = new Insets(20, 10, 0, 0);
        gbc.gridy = 5;
        panel.add(textAreaResume, gbc);

        //Bouton Valider
        JButton monButton = new JButton("Valider");
        gbc.insets = new Insets(20, 10, 0, 0);
        gbc.gridy = 6;
        gbc.gridx = 1;
        panel.add(monButton, gbc);

        menuO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new MyFilter());
                int dialog = fileChooser.showDialog(panel, "Ouvrir");
                if (dialog == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    System.out.println(file.getName() + " a été ouvert");
                } else {
                    System.out.println("Action annulée");
                }
            }
        });
    }
}

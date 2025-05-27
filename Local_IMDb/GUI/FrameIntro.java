package GUI;

import Entity.Actor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class FrameIntro extends JFrame implements ActionListener {
    JPanel panel;
    ImageIcon img;
    JLabel imgLabel, localIMDB, nameLabel, yearLabel;
    JTextField nameField, yearField;
    JButton saveButton, searchButton, exitButton;

    Color myColor;
    Font myFont, myFont2;


    public FrameIntro() {
        super("Local IMDb");
        this.setSize(450, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(myColor);

        myColor = new Color(205,249,50);
        panel.setBackground(myColor);
        myFont = new Font("Cambria", Font.BOLD, 28);

        URL imageUrl = getClass().getClassLoader().getResource("Images/imdb_logo.jpg");
        img = new ImageIcon(imageUrl);
        imgLabel = new JLabel(img);
        imgLabel.setBounds(130, 50, 40, 40);
        panel.add(imgLabel);

        localIMDB = new JLabel("Local IMDb");
        localIMDB.setBounds(180, 60, 150, 30);
        localIMDB.setFont(myFont);
        panel.add(localIMDB);

        nameLabel = new JLabel("Please enter the name of the actor");
        nameLabel.setBounds(75, 120, 300, 30);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(75, 150, 300, 30);
        panel.add(nameField);

        yearLabel = new JLabel("When is the new film coming?");
        yearLabel.setBounds(75, 220, 300, 30);
        panel.add(yearLabel);

        yearField = new JTextField();
        yearField.setBounds(75, 250, 300, 30);
        panel.add(yearField);

        saveButton = new JButton("Save");
        saveButton.setBounds(65, 400, 100, 40);
        saveButton.addActionListener(this);
        panel.add(saveButton);

        searchButton = new JButton("Search");
        searchButton.setBounds(175, 400, 100, 40);
        searchButton.addActionListener(this);
        panel.add(searchButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(285, 400, 100, 40);
        exitButton.addActionListener(this);
        panel.add(exitButton);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        String aName = nameField.getText();
        String aYear = yearField.getText();

        if (saveButton.getText().equals(command)) {
            Actor actor = new Actor(aName, aYear);
            boolean successful = actor.addToDataBase();

            if (successful) {
                JOptionPane.showMessageDialog(null, "Added successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Could not add the actor");
            }
        } else if (searchButton.getText().equals(command)) {
            boolean found = Actor.searchDataBase(aName, aYear);

            if (found) {
                JOptionPane.showMessageDialog(null, "Found");
            } else {
                JOptionPane.showMessageDialog(null, "Not found");
            }
        } else {
            int response = JOptionPane.showConfirmDialog(
                    null,
                    "Do you really want to exit?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION
            );

            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else {
            }
        }
    }
}

package model.MainMenu;

import model.Player;
import model.Property;
import services.IMainMenuStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Scanner;

public class EstancieroNewGame extends JPanel implements IMainMenuStrategy {
    private Player player;
    private JTextField nameField;
    private JTextField numPlayersField;
    private JTextField difficultyField;
    private JTextField colorField;
    private JComboBox<String> goalComboBox;
    private Main mainFrame;

    public EstancieroNewGame(Main mainFrame) {
        this.mainFrame = mainFrame;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JLabel("Set up your game"));
        add(Box.createRigidArea(new Dimension(0, 10)));

        add(new JLabel("Name:"));
        nameField = new JTextField(20);
        add(nameField);

        add(new JLabel("Amount players (2-6):"));
        numPlayersField = new JTextField(20);
        add(numPlayersField);

        add(new JLabel("Difficulty:"));
        difficultyField = new JTextField(20);
        add(difficultyField);

        add(new JLabel("Color:"));
        colorField = new JTextField(20);
        add(colorField);

        add(new JLabel("Goal to win:"));
        goalComboBox = new JComboBox<>(new String[]{"Number of properties owned", "Amount of money accumulated"});
        add(goalComboBox);

        add(Box.createRigidArea(new Dimension(0, 10)));

        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(new ContinueButtonListener());
        add(continueButton);

        JButton backButton = new JButton("Go back");
        backButton.addActionListener(new BackButtonListener());
        add(backButton);
    }

    @Override
    public void adjustMainMenu() {
        mainFrame.setContentPane(this);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private class ContinueButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Collect data and proceed with the game setup
            String name = nameField.getText();
            int numPlayers = Integer.parseInt(numPlayersField.getText());
            String difficulty = difficultyField.getText();
            String color = colorField.getText();
            String goal = (String) goalComboBox.getSelectedItem();

            // For demonstration, print the data to the console
            System.out.println("Player name: " + name);
            System.out.println("Amount players: " + numPlayers);
            System.out.println("Difficulty game: " + difficulty);
            System.out.println("Player color: " + color);
            System.out.println("Goal to win: " + goal);

            // Proceed with the game
            System.out.println("Starting game...");
            System.exit(0);  // Exit for now
        }
    }

    private class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.showMainMenu();
        }
    }
}
